import React, { Component } from 'react';
import { Route } from 'react-router';
import { Layout } from './components/Layout';
import { Home } from './components/Home/Home';
import { List } from './components/Client/List';
import './App.css';

export default class App extends Component {
  render() {
    return (
      <Layout>
        <Route exact path='/' component={Home} />
        <Route exact path='/client' component={List} />
      </Layout>
    );
  }
}

