import React, { Component } from 'react';
import { Grid, Row, Image, Col, PageHeader, Button, Thumbnail } from 'react-bootstrap';
class Home extends Component {
    displayName = Home.name

    render() {
        return (
            <div>
                <PageHeader>Home</PageHeader>
                <Grid>
                    <Row>
                        <Col xs={6} md={4}>
                            <Thumbnail src="/noimage.png">
                                <h3>Appointments</h3>
                                <p>Description</p>
                                <p>

                                    <Button bsStyle="default" href="/appointment">More</Button>
                                </p>
                            </Thumbnail>
                        </Col>
                        <Col xs={6} md={4}>
                            <Thumbnail src="/noimage.png" >
                                <h3>Cients</h3>
                                <p>Description</p>
                                <p>

                                    <Button bsStyle="default" href="/client">More</Button>
                                </p>
                            </Thumbnail>
                        </Col>
                        <Col xs={6} md={4}>
                            <Thumbnail src="/noimage.png">
                                <h3>Employees</h3>
                                <p>Description</p>
                                <p>

                                    <Button bsStyle="default" href="/employee">More</Button>
                                </p>
                            </Thumbnail>
                        </Col>
                    </Row>
                </Grid>
            </div>

        );
    }
}

export default Home;