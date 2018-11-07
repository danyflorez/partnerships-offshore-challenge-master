import React from "react";
import { FormGroup, FormControl } from "react-bootstrap";

export default function FieldGroup({ id, getValidationState, children, ...props }) {
    return (
      <FormGroup controlId={id} validationState={getValidationState()}>
        <FormControl  bsClass="form-control form-field" {...props} >
            {children}
        </FormControl>
      </FormGroup>
    );
  }