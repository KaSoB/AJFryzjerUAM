import React, { Component } from 'react';
import { Route } from 'react-router';
import { Layout } from './components/Layout';
import {ClientWidget } from './components/Client/ClientWidget';
import {ClientCreate} from './components/Client/ClientCreate';
import {ClientUpdate} from './components/Client/ClientUpdate';
import {EmployeeWidget } from './components/Employee/EmployeeWidget';
import {EmployeeCreate} from './components/Employee/EmployeeCreate';
import {EmployeeUpdate} from './components/Employee/EmployeeUpdate';
import {AppointmentWidget } from './components/Appointment/AppointmentWidget';
import {AppointmentCreate} from './components/Appointment/AppointmentCreate';
import {AppointmentUpdate} from './components/Appointment/AppointmentUpdate';
import Home from './components/Home/Home'
import './App.css';

export default class App extends Component {
  render() { 
    return (
      <Layout>
        <Route exact path='/' component={Home} />
        <Route path='/client' component={ClientWidget} />
        <Route exact path='/client/create' component={ClientCreate} />
        <Route exact path='/client/update/:id' component={ClientUpdate} />
        <Route path='/employee' component={EmployeeWidget} />
        <Route exact path='/employee/create' component={EmployeeCreate} />
        <Route exact path='/employee/update/:id' component={EmployeeUpdate} />
        <Route path='/appointment' component={AppointmentWidget} />
        <Route exact path='/appointment/create' component={AppointmentCreate} />
        <Route exact path='/appointment/update/:id' component={AppointmentUpdate} />
      </Layout>
    );
  }
}

