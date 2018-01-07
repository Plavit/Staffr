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
        console.log("PROJECT CREATE PAGE: create()");
        if (this.state.name != null && this.state.description != null) {
            this.state.currentProject.name = this.state.name;
            this.state.currentProject.description = this.state.description;
        } else {
            alert("Some fields are missing!");
            return false;
        }

        axios.post('/rest/project/create', this.state.currentProject).then(function (response) {
        }).catch(function (error) {
            console.log(error);
        });

        Actions.getAllProjects();

        hashHistory.push({
            pathname: "/projects/",
            query: {edit: true}
        });
        return false;
    }

    render() {
        return (
            <div>

                <h1>Create new project</h1>

                <form className='form-horizontal'>
                    <p>
                        <label for="name">Project name:
                            <input type='text' name='name' id='name' onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <label for="description">Project description:
                            <input type='textarea' name='description' id='description' onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <input type='button' name="submit" value="create" onClick={this.create.bind(this)}/>
                    </p>
                </form>

                <p>
                    return <Link to={'/projects/' + this.state.currentProject.id} activeClassName="active">back</Link>
                </p>

            </div>
        );
    }
}