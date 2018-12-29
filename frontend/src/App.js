import React, { Component } from 'react';
import { Route } from 'react-router';
import { Layout } from './components/Layout';
import {ClientWidget } from './components/Client/ClientWidget';
import {ClientCreate} from './components/Client/ClientCreate';
import './App.css';

export default class App extends Component {
  render() {
    return (
      <Layout>
        <Route exact path='/' component={ClientWidget} />
        <Route path='/client' component={ClientWidget} />
        <Route path='/client/create' component={ClientCreate} />
      </Layout>
    );
  }
}

