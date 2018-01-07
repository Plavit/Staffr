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
            projects: []
        }
        this.store = ProjectStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        console.log("componentWillMount");
        super.componentWillMount();
        Actions.getAllProjects();
    }

    render() {
        console.log("projects page overview render");
        var info = '';
        if (this.props.location.query.del != null){
            info = "Project deleted\n";
        }
        return (
            <div>
                <style>{`table td{border:1px solid black; padding: 5px}`}</style>
                {info}
                <h1>Projects</h1>
                <form>
                <table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.projects.map(project => {
                            return (
                                <tr key={project.id}>
                                    <td id="foo">{project.name}</td>
                                    <td>{project.description}</td>
                                    <td>
                                        <Link to={`/projects/${project.id}`} activeClassName="active">show project
                                            page</Link>
                                    </td>
                                </tr>
                            );
                        })
                    }
                    </tbody>
                </table>
                </form>
                <p><Link to={`/projects/create/`} activeClassName="active">create new project</Link></p>
                <p><Link to={`/`} activeClassName="active">back to main page</Link></p>
            </div>
        );
    }


}