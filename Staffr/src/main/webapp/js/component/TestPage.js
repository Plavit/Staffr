'use strict';

import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

export default class TestPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            test: {}
        };
    }

    componentDidMount() {
        console.log("test page mount")

        axios.get("/rest/user/admin").then((response) => {
            this.setState({
                test: response.data
            });
            console.log(this.state);
        }).catch((error) => {
            console.log(error);
        })

        console.log(this.state.test.toString());

    }


    render() {
        console.log("test page render")
        return (
            <div>
                <h1>Hello...</h1>
            </div>
        );
    }
}