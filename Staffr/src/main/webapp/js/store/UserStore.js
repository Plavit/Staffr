'use strict';
import Reflux from "reflux";
import React from "react";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import Actions from "../actions/Actions";
import axios from "axios";

export default class UserStore extends Reflux.Store {
    constructor(props) {
        console.log("user store constructor")
        super(props);
        this.state = {
            users: {}
        };
        this.listenables = Actions;
    }

    onUserInit() {
        console.log("User is trying to log in.");
        axios.get("/rest/user/current").then((response) => {
            this.setState({
                users: response.data
            });
            console.log(this.state);
        }).catch((error) => {
            console.log(error);
            hashHistory.push("/login");
        })
    }

    onUserLogout() {
        console.log("User is trying to log out.");
        this.setState({
            users: {}
        });
        console.log(this.state);
        axios.get('j_spring_security_logout')
            .then(function (response) {
                console.log(response)
                // window.location.reload();
                // hashHistory.push("/");
            })
            .catch(function (error) {
                console.log(error);
            })
        console.log("Something")
    };
}
