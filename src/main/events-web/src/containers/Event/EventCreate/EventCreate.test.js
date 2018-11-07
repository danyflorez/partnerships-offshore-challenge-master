import React from 'react';
import ReactDOM from 'react-dom';
import EventCreate from './index';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<EventCreate />, div);
  ReactDOM.unmountComponentAtNode(div);
});
