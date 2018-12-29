import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Glyphicon, Nav, Navbar, NavItem } from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
import './NavMenu.css';

export class NavMenu extends Component {
  displayName = NavMenu.name

  render() {
    return (
      <Navbar inverse fixedTop fluid collapseOnSelect>
        <Navbar.Header>
          <Navbar.Brand>
            <Link to={'/'}>
              <Glyphicon glyph='heart'/>  Salon Fryzjerski
            </Link>
          </Navbar.Brand>
          <Navbar.Toggle />
        </Navbar.Header>
        <Navbar.Collapse>
          <Nav>
            <LinkContainer to={'/'} exact>
              <NavItem>
                <Glyphicon glyph='home' /> Home
              </NavItem>
            </LinkContainer>
            <LinkContainer to={'/appointment'}>
              <NavItem>
                <Glyphicon glyph='calendar' /> Appointments
              </NavItem>
            </LinkContainer>
            <LinkContainer to={'/client'}>
              <NavItem>
                <Glyphicon glyph='user' /> Clients
              </NavItem>
            </LinkContainer>
            <LinkContainer to={'/employee'}>
              <NavItem>
                <Glyphicon glyph='user' /> Employees
              </NavItem>
            </LinkContainer>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    );
  }
}
