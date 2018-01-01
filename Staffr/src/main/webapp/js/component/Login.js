'use strict';

import React from "react";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

export default class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: ''
        };
    }

    componentDidMount() {
    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    onKeyPress = (e) => {
        if (e.key === 'Enter') {
            this.login();
        }
    };


    login = () => {
        // Authentication.login(this.state.username, this.state.password, this.onLoginError);
        // this.setState({mask: true});
    };

    // register = () => {
    //     Routing.transitionTo(Routes.register);
    // };


    render() {
        return (
            <h1>Hello, my name is elder Price. And I have come to show you the most amazing book.</h1>
        );
    }
}