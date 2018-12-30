import React, { Component } from 'react';
import axios from 'axios';
import { Table, Button, ButtonGroup } from 'react-bootstrap';

class EmployeeList extends Component {
    displayName = EmployeeList.name
    constructor(props) {
        super(props);
        this.remove = this.remove.bind(this);
        this.state = { 
            items: []
        };
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/war/employee`)
            .then(res => {
                this.setState({ items: res.data });
            })
            .catch(it => {
                alert("Błąd serwera " + it)
            })
    }

    remove = (id) => {
        axios.delete(`http://localhost:8080/war/employee/${id}`)
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
                        <th>Actions</th>
                    </tr>
                </thead>

                <tbody>
                    {this.state.items.map(item =>
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.firstName}</td>
                            <td>{item.lastName}</td>
                            <td>
                                <ButtonGroup vertical block>
                                    <Button  bsSize="xsmall" bsStyle="warning" href={"/Employee/Update/" + item.id}>
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

export default EmployeeList;