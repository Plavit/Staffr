'use strict';
import Reflux from "reflux";
import React from "react";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import Actions from "../actions/Actions";
import axios from "axios";

export default class UserStore extends Reflux.Store {
    constructor(props) {
        console.log("project store constructor")
        super(props);
        this.state = {
            projects: [],
            currentProject: {}
        }
        this.listenables = Actions;
    }

    onGetAllProjects(){
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

    onGetProject(id){
        console.log("onGetProject by id: " + id);
        axios.get("/rest/project/"+id).then((response) => {
            this.setState({
                currentProject: response.data
            });
            console.log("got it!")
        }).catch((error) => {
            console.log(error);
        })
    }
}
