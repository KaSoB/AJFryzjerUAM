import React, { Component } from 'react';
import axios from 'axios';
import { Table, Button, ButtonGroup } from 'react-bootstrap';

export class List extends Component {
    displayName = List.name
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
    }

    remove = (id) => {
        axios.delete(`/${id}`)
            .then(res => {
                alert("Usunięto produkt o id " + id)
                window.location.reload();
            })
            .catch(it => {
                console.log(it);
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
                            <td  >{item.email}</td>
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
