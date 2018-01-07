'use strict';
import Reflux from "reflux";
import React from "react";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import Actions from "../actions/Actions";
import axios from "axios";

export default class UserStore extends Reflux.Store {
    constructor(props) {
        console.log("user store constructor")
        super(props);
        this.state = {
            userLogedIn: [],
            currentUser: {},
            usersProjects: []
        };
        this.listenables = Actions;
    }

    onUserInit() {
        console.log("User is trying to log in.");
        axios.get("/rest/user/current").then((response) => {
            this.setState({
                userLogedIn: response.data
            });
            console.log(this.state);
        }).catch((error) => {
            console.log(error);
            hashHistory.push("/login");
        })
    }

    onUserLogout() {
        console.log("User is trying to log out.");
        this.setState({
            userLogedIn: {}
        });
        console.log(this.state);
        axios.get('j_spring_security_logout')
            .then(function (response) {
                console.log(response)
                // window.location.reload();
                // hashHistory.push("/");
            })
            .catch(function (error) {
                console.log(error);
            })
        console.log("Something")
    };


    onGetAllUsers() {
        console.log("onGetAllUsers");
        axios.get("/rest/user").then((response) => {
            this.setState({
                allUsers: response.data
            });
            console.log("got em!")
        }).catch((error) => {
            console.log(error);
        })
    }

    onGetUser(id) {
        axios.get("/rest/user/"+id).then((response) => {
            this.setState({
                currentUser: response.data
            });
        }).catch((error) => {
            console.log(error);
        })
    }

    onDeleteUser(id) {
        console.log("Delete user " + id);
        axios.delete("rest/user/" + id)
            .then((response) => {
                console.log(response);
                hashHistory.push({
                    pathname: '/users',
                    query: {del: true}
                });
            }).catch((error) => {
            console.log(error);
        })
    }

    onGetUsersProjects(userId){
        console.log("USER STORE: getProjectsByUser");
        axios.get("/rest/project/getProjectsByUser/"+userId).then((response) => {
            this.setState({
                usersProjects: response.data
            });
        }).catch((error) => {
            console.log(error);
        })
    }

}
