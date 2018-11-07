import React from 'react';
import ReactDOM from 'react-dom';
import FieldGroup from './index';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<FieldGroup getValidationState={()=>{}}/>, div);
  ReactDOM.unmountComponentAtNode(div);
});
