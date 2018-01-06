import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

export default class ProjectPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentProject: {}
        }
        this.store = ProjectStore;

    }

    componentDidMount() {
        var id = this.props.params.projectId
        console.log("id of this project is:" + id);
        Actions.getProject(id);
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        console.log("cwm");
    }

    render() {
        console.log("project page render");
        return (
            <div>
                <h1>Every project needs a side dish...</h1>
                <h2>{this.state.currentProject.name}</h2>
                <p>{this.state.currentProject.description}</p>
                <p><Link to={'/projects/edit/:'+this.state.currentProject.id}>edit</Link></p>
                <p><Link to={`/projects`} activeClassName="active">back to projects page</Link></p>
            </div>
        );
    }


}