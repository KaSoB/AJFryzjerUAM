import React, { Component } from 'react';
import axios from 'axios';
import { Button, FormGroup,Form , ControlLabel, FormControl, HelpBlock, Well } from 'react-bootstrap';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";


export class AppointmentUpdate extends Component {
    displayName = AppointmentUpdate.name
  
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            clients: [],
            employees: [],     
            selectedDateInMilis: 0,
            cliendId: 0,
            employeeId: 0
        };
    }
    datePickerChange = (e) => {
        console.log(e.getTime())
        this.setState({selectedDateInMilis: e.getTime()});
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
        
        axios.get(`http://localhost:8080/war/appointment/${this.state.id}`)
            .then(res => {
                let data = res.data;
                this.setState({
                    selectedDateInMilis : data.appointmentDate,
                    cliendId : data.client.id,
                    employeeId : data.employee.id
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
            appointmentDate : this.state.selectedDateInMilis,
            cliendId: this.state.cliendId,
            employeeId: this.state.employeeId,
        };
        console.log(params);
        axios.put("http://localhost:8080/war/appointment", params, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            }
        }).then((res) => {
            alert('Updated!');
            window.location.reload();
        }).catch((error) => {
            alert('Error! ' + error);
        })
    }

    render() {
        return (
                <Well>
                <Form onSubmit={this.put}>
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
                            <FormControl id="Client" componentClass="select" placeholder="select" 
                            value={this.state.cliendId}
                            onChange={e => this.setState({ cliendId: e.target.value })}>
                                {this.state.clients.map(it =>
                                    <option value={it.id}>{it.firstName} {it.lastName}</option>
                                )}
                            </FormControl>
                        </FormGroup>
                        <FormGroup controlId="formControlsSelect2">
                            <ControlLabel>Employee</ControlLabel>
                            <FormControl id="Employee" 
                            componentClass="select" placeholder="select" 
                            value={this.state.employeeId}
                            onChange={e => this.setState({ employeeId: e.target.value })}>
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

