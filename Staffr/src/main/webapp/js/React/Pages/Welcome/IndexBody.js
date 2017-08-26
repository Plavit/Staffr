import React from "react";
import Reflux from "reflux";
import {Button,Jumbotron, Col, Well} from 'react-bootstrap';

export default class IndexBody extends Reflux.Component {
    render() {
        return (
            <div>

                    <Col md={8} xsOffset={2}><Well bsSize="large">
                    <Jumbotron>
                        <h1>Hello, world!</h1>
                        <p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
                        <p><Button bsStyle="primary">Learn more</Button></p>

                    </Jumbotron></Well>
                    </Col>

            </div>
        )
    }
}