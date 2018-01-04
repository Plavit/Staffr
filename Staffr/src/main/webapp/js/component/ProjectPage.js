'use strict';

import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

export default class ProjectPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            projects: []
        }
        axios.get("/rest/project").then((response) => {
            this.setState({
                projects: response.data
            });
        }).catch((error) => {
            console.log(error);
        })
    }

    render() {
        return (
            <div>
                <h1>Projects</h1>
                <table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <tbody>
                {
                    this.state.projects.map(function(project) {
                        return (
                            <tr key={project.id}>
                            <td>{project.name}</td>
                            <td>{project.description}</td>
                            </tr>
                        );
                    })
                }
                    </tbody>
                </table>
                <p><Link to={`/`} activeClassName="active">back to main page</Link></p>
            </div>
        );
    }


}