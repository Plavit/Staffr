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
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        Actions.getProject(this.props.params.projectId);
    }

    render() {
        console.log("project page render");
        var info = '';
        if (this.props.location.query.edit != null){
            info = "Update was succesfull\n";
        }
        return (
            <div>
                {info}
                <h1>Every project needs a side dish...</h1>
                <h2>{this.state.currentProject.name}</h2>
                <p>{this.state.currentProject.description}</p>
                <p><Link to={`/projects/edit/${this.state.currentProject.id}`}>edit</Link></p>
                <p><Link to={`/projects`} activeClassName="active">back to projects page</Link></p>
            </div>
        );
    }


}