import React, { Component } from 'react';
import { PageHeader, Button } from 'react-bootstrap';
import List from './ClientList';

export class ClientWidget extends Component {
    displayName = ClientWidget.name
    componentDidMount() {

    }

    render() {
        return (
            <div>
                <PageHeader>Clients</PageHeader>
                <List/>
                <span>
                    <Button href="/Client/Create" bsStyle="success" style={ {margin : 5} }>Add</Button>
                </span>
            </div>
        );
    }
}
