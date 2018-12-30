import React, { Component } from 'react';
import axios from 'axios';
import { Button, FormGroup,Form , ControlLabel, FormControl, HelpBlock, Well } from 'react-bootstrap';

function FieldGroup({ id, label, help, ...props }) {
    return (
        <FormGroup controlId={id}>
            <ControlLabel>{label}</ControlLabel>
            <FormControl {...props} ></FormControl>
            {help && <HelpBlock>{help}</HelpBlock>}
        </FormGroup>
    );
}

export class EmployeeUpdate extends Component {
    displayName = EmployeeUpdate.name
  
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            firstName: "",
            lastName: ""
        };
    }
    componentDidMount() {
        axios.get(`http://localhost:8080/war/employee/${this.state.id}`)
            .then(res => {
                let data = res.data;
                this.setState({
                    firstName : data.firstName,
                    lastName : data.lastName
                });
            })
            .catch(it => {
                alert("Błąd serwera " + it)
            })
    }


    put = (e) => {
        e.preventDefault();
 
        const params = {
            id : this.state.id,
            firstName: e.target.firstName.value,
            lastName: e.target.lastName.value
        };

        axios.put('http://localhost:8080/war/employee', params, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((res) => {
            alert('Updated!');
            window.location.reload();
        }).catch((error) => {
            alert('Error!');
            console.log(error);
        })
    }

    render() {
        return (
            <Well>
                <Form onSubmit={this.put}>
                    <FormGroup>
                        <FieldGroup
                            id="firstName"
                            type="text"
                            label="First name"
                            required
                            value={this.state.firstName}
                            onChange={e => this.setState({ firstName: e.target.firstName })}
                            placeholder="Enter text" />
                        <FieldGroup
                            id="lastName"
                            type="text"
                            label="Last name"
                            required
                            value={this.state.lastName}
                            onChange={e => this.setState({ lastName: e.target.lastName })}
                            placeholder="Enter text" />
                        <FormControl.Feedback />
                        <Button bsStyle="success" type="submit">Confirm</Button>
                        <Button bsStyle="default" type="button" href="/Employee">Back</Button>
                    </FormGroup>
                </Form>
            </Well>

        );
    }
}
