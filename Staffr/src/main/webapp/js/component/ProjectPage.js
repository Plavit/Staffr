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
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
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
                </table>
            </div>
        );
    }


}