import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

export default class SelectProjectPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            projects: [],
            userId: {}
        }
        this.store = ProjectStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        this.state.userId = this.props.params.userId;
        Actions.getAllProjects();
    }

    addUserToProject(projectId) {
        console.log("SELECT PROJECT PAGE: adding user " + this.state.userId + " to project " + projectId);
    }

    render() {
        return (
            <div>
                <style>{`table td{border:1px solid black; padding: 5px}`}</style>
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
                                            <Link
                                                to={`/users/edit/${this.state.userId}`}
                                                activeClassName="active"
                                                onClick={() => { this.addUserToProject(project.id)}}>
                                                add to project
                                            </Link>
                                        </td>
                                    </tr>
                                );
                            })
                        }
                        </tbody>
                    </table>
                </form>
                <p><Link to={`/users/edit/${this.state.userId}`} activeClassName="active">back to user page</Link></p>
            </div>
        );
    }


}