import React, { Component } from 'react';
import axios from 'axios';
import { Button, FormGroup,Form , ControlLabel, FormControl, HelpBlock, Alert,Well } from 'react-bootstrap';

function FieldGroup({ id, label, help, ...props }) {
    return (
        <FormGroup controlId={id}>
            <ControlLabel>{label}</ControlLabel>
            <FormControl {...props} ></FormControl>
            {help && <HelpBlock>{help}</HelpBlock>}
        </FormGroup>
    );
}

export class EmployeeCreate extends Component {
    displayName = EmployeeCreate.name
  
    constructor(props) {
        super(props);
        this.dismissAlert.bind(this);
        this.handleAlert.bind(this);

        this.state = {
            showAlert: false
            
        };
    }
    componentDidMount() {
     
    }

    dismissAlert = () => {
        this.setState({ showAlert: false });
    }

    handleAlert = () => {
        this.setState({ showAlert: true });
    }

    post = (e) => {
        e.preventDefault();

        const params = {
            firstName: e.target.firstName.value,
            lastName: e.target.lastName.value
        };

        axios.post('http://localhost:8080/war/employee', params, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((res) => {
            this.handleAlert()
        }).catch((error) => {
            alert('Błąd! ' + error);
        })
    }

    render() {
        if (this.state.showAlert) {
            return (
                <Alert bsStyle="success" onDismiss={this.dismissAlert}>
                    <h4>Added!</h4>
                    <p>
                        <Button onClick={this.dismissAlert}>Continue</Button>
                    </p>
                </Alert>
            );
        }

        return (
            <Well>
                <Form onSubmit={this.post}>
                    <FormGroup>
                        <FieldGroup
                            id="firstName"
                            type="text"
                            label="First name"
                            required
                            placeholder="Enter text" />
                        <FieldGroup
                            id="lastName"
                            type="text"
                            label="Last name"
                            required
                            placeholder="Enter text" />
                        <FormControl.Feedback />
                        <Button bsStyle="success" type="submit">Confirm</Button>
                        <Button bsStyle="default" type="button" href="/Client">Back</Button>
                    </FormGroup>
                </Form>
            </Well>

        );
    }
}
