import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";

import axios from "axios";
import querystring from "querystring";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

export default class ProjectEditPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {}
    }

    componentDidMount() {

    }

    componentWillMount() {
        super.componentWillMount();
    }

    render() {
        console.log("project page render");
        return (
            <div>
                <p>You operation was a success.</p>
                <p><Link to={`/projects`} activeClassName="active">back to projects page</Link></p>
            </div>
        );
    }
}