import React from 'react';
import ReactDOM from 'react-dom';
import EventList from './index';

it('renders without crashing', () => {
  const div = document.createElement('div');
  ReactDOM.render(<EventList />, div);
  ReactDOM.unmountComponentAtNode(div);
});
