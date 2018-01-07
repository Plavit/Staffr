import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import Actions from "../actions/Actions";
import UserStore from "../store/UserStore";

export default class UserInterface extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    componentWillMount() {
    }

    componentDidMount() {

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
                <h1 style={{color: '#0000FF'}}>Congratulations, you are logged in.</h1>
                <Link to={"/projects"} activeClassName="active">Projects overview</Link><br/>
                <Link to={"/users"} activeClassName="active">Users overview</Link><br/>
                <Link to={"/userSearch"} activeClassName="active">User search</Link><br/>
                <Link to={"/logout"} activeClassName="active">Logout</Link>
            </div>
        );
    }
}