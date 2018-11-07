import React, { Component } from "react";
import { Table, Button } from "react-bootstrap";
import API from "../../../api";
import "./EventList.css";
import EventCreate from "../EventCreate";

class EventList extends Component {
  constructor(props) {
    super(props);
    this.state = { events: [], createOpen: false };
  }

  componentDidMount() {
    API.getEvents().then(r => this.setState({ events: r.data }));
  }

  openModal = () => {
    this.setState({ createOpen: true });
  };

  closeModal = () => {
    this.setState({ createOpen: false });
  };

  addEvent = (event) => {
    this.setState({ events: [...this.state.events, event] });
  };

  render() {
    const events = this.state.events.map(e => (
      <tr>
        <td>{e.name}</td>
        <td>{e.date}</td>
        <td>{e.venue.name}</td>
        <td>{e.venue.city}</td>
        <td>{e.venue.state}</td>
      </tr>
    ));

    return (
      <div className="center">
        <Table striped bordered condensed hover>
          <thead>
            <tr>
              <th>Event Name</th>
              <th>Date</th>
              <th>Venue</th>
              <th>City</th>
              <th>State</th>
            </tr>
          </thead>
          <tbody>{events}</tbody>
        </Table>
        <Button onClick={this.openModal}>Add Event</Button>
        <EventCreate
          show={this.state.createOpen}
          closeModal={this.closeModal}
          addEvent={this.addEvent}
        />
      </div>
    );
  }
}

export default EventList;
