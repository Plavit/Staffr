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

    componentWillMount() {
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
        console.log("render");
        console.log(this.state);
        return (
            <div>
                <h1 style={{color: '#0000FF'}}>Congratulations, you are logged in.</h1>
                <Link to={"/projects"} activeClassName="active">Projects overview</Link><br/>
                <Link to={"/users"} activeClassName="active">Users overview</Link><br/>
                <Link to={"/logout"} activeClassName="active">Logout</Link>
            </div>
        );
    }
}