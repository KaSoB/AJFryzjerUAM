import React, { Component } from 'react';
import axios from 'axios';
import { Table, Button, ButtonGroup } from 'react-bootstrap';

class ClientList extends Component {
    displayName = ClientList.name
    constructor(props) {
        super(props);
        this.remove = this.remove.bind(this);
        this.state = { 
            items: []
        };
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/war/client`)
            .then(res => {
                this.setState({ items: res.data });
            })
            .catch(it => {
                alert("Błąd serwera " + it)
            })
    }

    remove = (id) => {
        axios.delete(`http://localhost:8080/war/client/${id}`)
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
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Phone Number</th>
                        <th>Actions</th>
                    </tr>
                </thead>

                <tbody>
                    {this.state.items.map(item =>
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.firstName}</td>
                            <td>{item.lastName}</td>
                            <td>{item.email}</td>
                            <td>{item.phoneNumber}</td>
                            <td>
                                <ButtonGroup vertical block>

                                    <Button  bsSize="xsmall" bsStyle="warning" href={"Product/Update/" + item.id}>
                                        Modyfikuj
                                    </Button>

                                    <Button  bsSize="xsmall" bsStyle="danger" onClick={() => this.remove(item.id)} >
                                        Usuń
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

export default ClientList;