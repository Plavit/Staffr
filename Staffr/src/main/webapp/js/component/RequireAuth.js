'use strict';

import Reflux from "reflux";
import React from "react";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import UserStore from "../store/UserStore";

export default class RequireAuth extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.store = UserStore;
    }

    render() {
        return (<div>{this.props.children}</div>)
    }
}