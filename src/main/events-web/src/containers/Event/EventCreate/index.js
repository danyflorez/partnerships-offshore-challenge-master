import React, { Component } from "react";
import { Modal, Button, Panel, Alert } from "react-bootstrap";
import API from "../../../api";
import FieldGroup from "../../../components/FieldGroup";
import "./EventCreate.css";
import states from "./states";

const dataInitialState = {
    name: '',
    date: '',
    vname: '',
    vcity: '',
    vstate: ''
};

class EventCreate extends Component {
  constructor(props) {
    super(props);
    this.state = { data: {...dataInitialState}, touched: {}, valid: false };
  }

  handleChange = event => {
    const data = { ...this.state.data };
    data[event.target.name] = event.target.value;
    const touched = { ...this.state.touched };
    touched[event.target.name] = true;
    this.setState({ data, touched, valid: this.validateForm(data) });
  };

  validateForm = data => {
    return (
      ["name", "date", "vname", "vcity", "vstate"].filter(
        v => !data[v] || data[v].length === 0
      ).length === 0
    );
  };

  getValidationState = field => {
    return () => {
      if (this.state.data[field] && this.state.data[field].length > 0) {
        return "success";
      } else if (this.state.touched[field]) {
        return "error";
      }
    };
  };

  create = () => {
    const { data } = this.state;
    const event = {
      name: data.name,
      date: data.date,
      venue: {
        name: data.vname,
        city: data.vcity,
        state: data.vstate
      }
    };
    API.saveEvent(event).then(r => {
        this.props.addEvent(r.data);
        this.setState({ data: {...dataInitialState}, touched: {}, valid: false, created: true });
    });
  };

  handleDismiss = () => {
      this.setState({ created: false });
  }

  render() {
    return (
      <form>
        <Modal show={this.props.show} onHide={this.props.closeModal}>
          <Modal.Header closeButton>
            <Modal.Title>Add New Event</Modal.Title>
          </Modal.Header>
          <Modal.Body>
          {this.state.created && (
              <Alert bsStyle="success" onDismiss={this.handleDismiss}>
                The event was created successfully
              </Alert>
            )}
            <Panel>
              <Panel.Heading>Event Information</Panel.Heading>
              <Panel.Body>
                <div className="field-set">
                  <FieldGroup
                    name="name"
                    type="text"
                    placeholder="Event Name"
                    onChange={this.handleChange}
                    value={this.state.data.name}
                    getValidationState={this.getValidationState("name")}
                  />
                  <FieldGroup
                    name="date"
                    type="date"
                    placeholder="Event Date"
                    onChange={this.handleChange}
                    value={this.state.data.date}
                    getValidationState={this.getValidationState("date")}
                  />
                </div>
              </Panel.Body>
            </Panel>
            <Panel>
              <Panel.Heading>Venue Information</Panel.Heading>
              <Panel.Body>
                <div className="field-set">
                  <FieldGroup
                    name="vname"
                    type="text"
                    placeholder="Name"
                    onChange={this.handleChange}
                    value={this.state.data.vname}
                    getValidationState={this.getValidationState("vname")}
                  />
                  <FieldGroup
                    name="vcity"
                    type="text"
                    placeholder="City"
                    onChange={this.handleChange}
                    value={this.state.data.vcity}
                    getValidationState={this.getValidationState("vcity")}
                  />
                  <FieldGroup
                    name="vstate"
                    componentClass="select"
                    placeholder="State"
                    onChange={this.handleChange}
                    value={this.state.data.vstate}
                    getValidationState={this.getValidationState("vstate")}
                  >
                    <option key="" value="">
                      State
                    </option>
                    {states.map(state => (
                      <option key={state} value={state}>
                        {state}
                      </option>
                    ))}
                  </FieldGroup>
                </div>
              </Panel.Body>
            </Panel>
          </Modal.Body>
          <Modal.Footer>
            <Button disabled={!this.state.valid} onClick={this.create}>
              Create
            </Button>
            <Button onClick={this.props.closeModal}>Close</Button>
          </Modal.Footer>
        </Modal>
      </form>
    );
  }
}

export default EventCreate;
