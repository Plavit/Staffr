'use strict';

import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";

export default class TestPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    componentDidMount() {
        console.log("did mount");
    }


    render() {
        return (
            <div>
                <h1>Hello...</h1>
            </div>
        );
    }
}