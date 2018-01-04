import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import Actions from "../actions/Actions";
import UserStore from "../store/UserStore";

export default class UserInterface extends Reflux.Component {
    constructor(props) {
        console.log("user interface constructor");
        super(props);
        this.state = {};
    }

    componentDidMount() {
        Actions.userInit();
    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    render() {
        return (
            <div>
                <h1>Congratulations, you are logged in.</h1>
            </div>
        );
    }
}