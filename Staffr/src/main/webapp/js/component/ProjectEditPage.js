import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

export default class ProjectEditPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentProject: {}
        }
        this.store = ProjectStore;
    }

    componentDidMount() {
        var id = this.props.params.projectId
        console.log("id of this project is:" + id);
        Actions.getProject(id);
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        console.log("cwm");
    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    onKeyPress = (e) => {
        if (e.key === 'Enter') {
            this.login();
        }
    };

    update(e) {
        e.preventDefault();
        console.log("Update trigger: " + this.state.currentProject);
        // axios.post('/rest/project', querystring.stringify({
        //     username: this.state.username,
        //     password: this.state.password
        // })).then(function (response) {
        //     hashHistory.push({pathname: ""});
        // }).catch(function (error) {
        //     // console.log(error.toString());
        //     alert("Authentification error.");
        // });
        return false;
    }

    render() {
        console.log("project page render");
        return (
            <div>
                
                <h1>...on a slightly smaller page.</h1>

                <form className='form-horizontal'>
                    <p>
                        <label for="projectName">Project name:
                            <input type='text' name='projectName' id='projectName'
                                   defaultValue={this.state.currentProject.name} onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <label for="projectDescription">Project description:
                            <input type='textarea' name='projectDescription' id='projectDescription'
                                   defaultValue={this.state.currentProject.description} onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <input type='button' name="submit" value="update" onClick={this.update.bind(this)}/>
                    </p>
                </form>

                <p>
                    <Link to={'/projects/' + this.state.currentProject.id} activeClassName="active">back</Link>
                </p>

            </div>
        );
    }
}