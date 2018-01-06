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
                <h1>...on a slightly smaller page.</h1>

                <form onSubmit={this.handleSubmit}>
                    <label>
                        Project Name:
                        <input type="text" value={this.state.currentProject.name} onChange={this.handleChange} />
                    </label><br/>
                    <label>
                        Project description:
                        <input type="textarea" value={this.state.currentProject.description} onChange={this.handleChange} />
                    </label><br/>
                    <input type="submit" value="Submit changes" />
                </form>
                <p><Link to={'/projects/'+this.state.currentProject.id} activeClassName="active">back</Link></p>
            </div>
        );
    }


}