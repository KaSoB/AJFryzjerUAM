import React, { Component } from 'react';
import { Route } from 'react-router';
import { Layout } from './components/Layout';
import {ClientWidget } from './components/Client/ClientWidget';
import {ClientCreate} from './components/Client/ClientCreate';
import {ClientUpdate} from './components/Client/ClientUpdate';
import {EmployeeWidget } from './components/Employee/EmployeeWidget';
import {EmployeeCreate} from './components/Employee/EmployeeCreate';
import {EmployeeUpdate} from './components/Employee/EmployeeUpdate';

import './App.css';

export default class App extends Component {
  render() { 
    return (
      <Layout>
        <Route exact path='/' component={ClientWidget} />
        <Route path='/client' component={ClientWidget} />
        <Route exact path='/client/create' component={ClientCreate} />
        <Route exact path='/client/update/:id' component={ClientUpdate} />
        <Route path='/employee' component={EmployeeWidget} />
        <Route exact path='/employee/create' component={EmployeeCreate} />
        <Route exact path='/employee/update/:id' component={EmployeeUpdate} />
      </Layout>
    );
  }
}

