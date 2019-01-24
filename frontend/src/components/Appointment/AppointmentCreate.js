import React, { Component } from 'react';
import axios from 'axios';
import { Button, FormGroup, Form, ControlLabel, FormControl, HelpBlock, Alert, Well } from 'react-bootstrap';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";

export class AppointmentCreate extends Component {
    displayName = AppointmentCreate.name

    constructor(props) {
        super(props);
        this.dismissAlert.bind(this);
        this.handleAlert.bind(this);

        this.state = {
            showAlert: false,
            clients: [],
            employees: [],
            selectedDateInMilis: 0
        };
    }
    componentDidMount() {
        axios.get(`http://localhost:8080/war/client`)
            .then(res => {
                this.setState({
                    clients: res.data
                })
            })
            .catch(it => {
                console.log(it)
            })

        axios.get(`http://localhost:8080/war/employee`)
            .then(res => {
                this.setState({
                    employees: res.data
                })
            })
            .catch(it => {
                console.log(it)
            })
    }

    dismissAlert = () => {
        this.setState({ showAlert: false });
        window.location.reload();
    }

    handleAlert = () => {
        this.setState({ showAlert: true });
    }

    datePickerChange = (e) => {
        console.log(e.getTime())
        this.setState({selectedDateInMilis: e.getTime()});
    }

    post = (e) => {
        e.preventDefault();
    
        const params = {
            appointmentDate: this.state.selectedDateInMilis,
            clientId: e.target.Client.value,
            employeeId: e.target.Employee.value
        };

        axios.post('http://localhost:8080/war/appointment', params, {
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
                        <FormGroup>
                   
                            <DatePicker
                                    selected={this.state.selectedDateInMilis}
                                    onChange={this.datePickerChange}
                                    showTimeSelect
                                    timeFormat="HH:mm"
                                    timeIntervals={15}
                                    dateFormat="HH:mm d/MM/YYYY"
                                    placeholderText="Click to select a date"
                                    timeCaption="time" />

                        </FormGroup>


                        <FormGroup controlId="formControlsSelect">
                            <ControlLabel>Client</ControlLabel>
                            <FormControl id="Client" componentClass="select" placeholder="select" >
                                {this.state.clients.map(it =>
                                    <option value={it.id}>{it.firstName} {it.lastName}</option>
                                )}
                            </FormControl>
                        </FormGroup>
                        <FormGroup controlId="formControlsSelect2">
                            <ControlLabel>Employee</ControlLabel>
                            <FormControl id="Employee" componentClass="select" placeholder="select" >
                                {this.state.employees.map(it =>
                                    <option value={it.id}>{it.firstName} {it.lastName}</option>
                                )}
                            </FormControl>
                        </FormGroup>
                        <FormControl.Feedback />
                        <Button bsStyle="success" type="submit">Confirm</Button>
                        <Button bsStyle="default" type="button" href="/Appointment">Back</Button>
                    </FormGroup>
                </Form>
            </Well>

        );
    }
}
