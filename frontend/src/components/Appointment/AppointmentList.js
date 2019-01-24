import React, { Component } from 'react';
import axios from 'axios';
import { Table, Button, ButtonGroup } from 'react-bootstrap';
import Moment from 'react-moment';

class AppointmentList extends Component {
    displayName = AppointmentList.name
    constructor(props) {
        super(props);
        this.remove = this.remove.bind(this);
        this.state = { 
            items: []
        };
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/war/appointment`)
            .then(res => {
                this.setState({ items: res.data });
            })
            .catch(it => {
                alert("Błąd serwera " + it)
            })
    }

    remove = (id) => {
        axios.delete(`http://localhost:8080/war/appointment/${id}`)
            .then(res => {
                alert("Usunięto item o id " + id)
                window.location.reload();
            })
            .catch(it => {
                alert("Błąd serwera " + it)
            })
    }
    render() {
      
        return (
            
            <Table striped bordered condensed hover responsive>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Time</th>
                        <th>Date</th>
                        <th>Client</th>
                        <th>Employee</th>
                        <th>Actions</th>
                    </tr>
                </thead>

                <tbody>
                    {this.state.items.map(item =>
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td><Moment format="HH:mm" unix>{item.appointmentDate/1000}</Moment></td>
                            <td><Moment format="DD/MM/YYYY" unix>{item.appointmentDate/1000}</Moment></td>
                            <td>{item.client.firstName} {item.client.lastName} ({item.client.email})</td>
                            <td>{item.employee.firstName} {item.employee.lastName}</td>
                            <td>
                                <ButtonGroup vertical block>
                                    <Button  bsSize="xsmall" bsStyle="warning" href={"/Appointment/Update/" + item.id}>
                                        Update
                                    </Button>

                                    <Button  bsSize="xsmall" bsStyle="danger" onClick={() => this.remove(item.id)} >
                                        Remove
                                    </Button> 
                                </ButtonGroup>
                            </td>
                        </tr>
                    )}
                </tbody>
            </Table>
        );
    }
}

export default AppointmentList;