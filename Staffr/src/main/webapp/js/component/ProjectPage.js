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
            currentProject: {},
            usersOnProject: []
        }
        this.store = ProjectStore;

    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        Actions.getProject(this.props.params.projectId);
        Actions.getAllUsersOnProjects(this.props.params.projectId);
    }

    render() {
        console.log("project page render");
        var info = '';
        if (this.props.location.query.edit != null) {
            info = "Update was succesfull\n";
        }
        return (
            <div>
                <style>{`table td{border:1px solid black; padding: 5px}`}</style>
                {info}
                <h1>Every project needs a side dish...</h1>
                <h2>{this.state.currentProject.name}</h2>
                <p>{this.state.currentProject.description}</p>
                <p><Link to={`/projects/edit/${this.state.currentProject.id}`}>edit</Link></p>
                <p><Link to={`/projects`} activeClassName="active">back to projects page</Link></p>
                <h3>Users on project:</h3>
                <table>
                    <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Birth Year</th>
                        <th>Email</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.usersOnProject.map(user => {
                            if (!(this.state.usersOnProject.length > 0)) {
                                return <p>There are no users on this project.</p>
                            } else {
                                return (
                                    <tr key={user.id}>
                                        <td>{user.firstName}</td>
                                        <td>{user.lastName}</td>
                                        <td>{user.birthYear}</td>
                                        <td>{user.email}</td>
                                        <td>
                                            <Link to={`/users/${user.id}`} activeClassName="active">show user page</Link>
                                        </td>
                                    </tr>
                                );
                            }
                        })
                    }
                    </tbody>
                </table>
            </div>
        );
    }


}