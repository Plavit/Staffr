import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";

import axios from "axios";
import querystring from "querystring";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

export default class ProjectCreatePage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentProject: {},
            name: null,
            description: null
        }
        this.store = ProjectStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    create(e) {
        e.preventDefault();
        if (this.state.name != null && this.state.description != null) {
            this.state.currentProject.name = this.state.name;
            this.state.currentProject.description = this.state.description;
        } else {
            alert("Some fields are missing!");
            return false;
        }
        console.log("Creating: " + this.state.currentProject);
        axios.post('/rest/project/create', this.state.currentProject).then(function (response) {
        }).catch(function (error) {
            console.log(error);
        });
        hashHistory.push({
            pathname: "/projects/",
            query: {edit: true}
        });
        return false;
    }

    deleteProject() {
        Actions.deleteProject(this.state.currentProject.id);
        // Actions.deleteProject(this.state.curr.username, this.state.currentProject.id, this.state.userResponse.userRole);
    };

    render() {
        console.log("project page render");
        return (
            <div>

                <h1>...on a slightly smaller page.</h1>

                <form className='form-horizontal'>
                    <p>
                        <label for="name">Project name:
                            <input type='text' name='name' id='name'
                                   defaultValue={this.state.currentProject.name} onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <label for="description">Project description:
                            <input type='textarea' name='description' id='description'
                                   defaultValue={this.state.currentProject.description} onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <input type='button' name="submit" value="update" onClick={this.update.bind(this)}/>
                    </p>
                    <p>
                        <p><input type='button' name="delete" value="delete" onClick={this.deleteProject.bind(this)}/>
                        </p>
                    </p>
                </form>

                <p>
                    return <Link to={'/projects/' + this.state.currentProject.id} activeClassName="active">back</Link>
                </p>

            </div>
        );
    }
}