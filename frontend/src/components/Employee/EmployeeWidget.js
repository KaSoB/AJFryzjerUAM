import React, { Component } from 'react';
import { PageHeader, Button } from 'react-bootstrap';
import List from './EmployeeList';

export class EmployeeWidget extends Component {
    displayName = EmployeeWidget.name
    componentDidMount() {

    }

    render() {
        return (
            <div>
                <PageHeader>Employee</PageHeader>
                <List/>
                <span>
                    <Button href="/Employee/Create" bsStyle="success" style={ {margin : 5} }>Add</Button>
                </span>
            </div>
        );
    }
}
