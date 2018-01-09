'use strict';
import Reflux from "reflux";
import React from "react";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import Actions from "../actions/Actions";
import axios from "axios";

export default class ProjectStore extends Reflux.Store {
    constructor(props) {
        console.log("project store constructor")
        super(props);
        this.state = {
            projects: [],
            currentProject: {},
            usersOnProject: [],
            usersOnProjectSearchResult: []
        }
        this.listenables = Actions;
    }

    onGetAllProjects() {
        console.log("onGetAllProjects");
        axios.get("/rest/project").then((response) => {
            this.setState({
                projects: response.data
            });
            console.log("got em!")
        }).catch((error) => {
            console.log(error);
        })
    }

    onGetProject(id) {
        console.log("onGetProject by id: " + id);
        axios.get("/rest/project/" + id).then((response) => {
            this.setState({
                currentProject: response.data
            });
            console.log("got it!")
        }).catch((error) => {
            console.log(error);
        })
    }

    onDeleteProject(id) {
        console.log("Delete project " + id);
        axios.delete("rest/project/" + id)
            .then((response) => {
                console.log(response);
                hashHistory.push({
                    pathname: '/projects',
                    query: {del: true}
                });
            }).catch((error) => {
            console.log(error);
        })
    }

    onGetAllUsersOnProjects(projectId) {
        console.log("PROJECT STORE: onGetAllUsersOnProjects");
        axios.get("/rest/user/onProject/"+projectId).then((response) => {
            this.setState({
                usersOnProject: response.data
            });
        }).catch((error) => {
            console.log(error);
        })
    }

    onGetUsersByProjectDuration(projectId, duration){
        console.log("PROJECT STORE: getUsersByProjectDuration"+projectId+"&"+duration);
        axios.get("/rest/user/getUsersByProjectDuration/"+projectId+"&"+duration).then((response) => {
            this.setState({
                usersOnProjectSearchResult: response.data
            });
        }).catch((error) => {
            console.log(error);
        })
    }
}
