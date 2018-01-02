'use strict';

import React from "react";
// import Reflux from "reflux"
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";
import querystring from "querystring";

export default class Login extends Reflux.Component {
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


    login(e) {
        e.preventDefault();
        axios.post("j_spring_security_check"
            , querystring.stringify({username: this.state.username, password: this.state.password})
        ).then(function (response) {
            hashHistory.push({patchname: ""});
        }).catch(function (error) {
            alert("Authentification error.");
        });
    };

    // register = () => {
    //     Routing.transitionTo(Routes.register);
    // };


    render() {
        return (
            <div>
                <h1>Hello, my name is elder Price. And I have come to show you the most amazing book.</h1>
                <form className='form-horizontal'>
                    <p><label for="username">Username: </label><input type='text' name='username' id='username'
                                                                      onChange={this.onChange}/></p>
                    <p><label for="password">Password: </label><input type='password' name='password' id='password'
                                                                      onChange={this.onChange}/></p>
                    <p><input type='button' name="submit" onClick={this.login.bind(this)}/></p>
                </form>
            </div>
        );
    }
}