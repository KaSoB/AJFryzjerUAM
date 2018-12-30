import React, { Component } from 'react';
import { PageHeader, Button,Alert } from 'react-bootstrap';
import List from './AppointmentList';
import Moment from 'react-moment';

export class AppointmentWidget extends Component {
    displayName = AppointmentWidget.name
    componentDidMount() {

    }

    render() {
        return (
            <div>
                <PageHeader>Appointment</PageHeader>
   
                <Alert bsStyle="success">
                    Time <Moment interval={2000}  format="HH:mm:ss DD/MM/YYYY"></Moment>
                </Alert>

                <List/>

                <span>
                    <Button href="/Appointment/Create" bsStyle="success" style={ {margin : 5} }>Add</Button>
                </span>
            </div>
        );
    }
}
