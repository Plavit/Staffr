import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";

import axios from "axios";
import querystring from "querystring";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

export default class UserSearchCriteriaPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentProject: {},
            days: 0,
            serched: false,
            projectId: {},
            usersOnProjectSearchResult: [],
            currentUserProject: {},
            userProjects: []
        }
        this.store = ProjectStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        var id = this.props.params.projectId;
        this.state.projectId = id;
        Actions.getProject(id);
    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    search(e) {
        e.preventDefault();
        console.log(
            "USER SEATCH CRITERIA PAGE: searching for projectId: "
            + this.state.projectId +
            "; with min days: "
            + this.state.days
        );
        Actions.getUsersByProjectDuration(this.state.projectId, this.state.days);
        this.state.serched = true;

        // Actions.getUserServiceForUserOnProject(
        //     this.state.currentProject.id,
        //     8
        // );
        // console.log("HERE");
        // console.log(this.state);

        // this.state.usersOnProjectSearchResult.map(user => {
        //     Actions.getUserServiceForUserOnProject(
        //         this.state.currentProject.id,
        //         user.id
        //     );
        //     this.state.userProjects[user.id] = this.state.currentProject;
        // });
    }

    result() {
        if (this.state.serched) {
            return (
                <form>
                    <table>
                        <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Birth Year</th>
                            <th>Email</th>
                            <th>Date start</th>
                            <th>Date end</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.usersOnProjectSearchResult.map(userProject => {
                                return (
                                    <tr key={userProject.employee.id}>
                                        <td>{userProject.employee.firstName}</td>
                                        <td>{userProject.employee.lastName}</td>
                                        <td>{userProject.employee.birthYear}</td>
                                        <td>{userProject.employee.email}</td>
                                        <td>{userProject.from}</td>
                                        <td>{userProject.end}</td>
                                        <td>
                                            <Link to={`/users/${userProject.employee.id}`} activeClassName="active">show user
                                                page</Link>
                                        </td>
                                    </tr>
                                );
                            })
                        }
                        </tbody>
                    </table>
                </form>
            );
        }
    }

    render() {
        console.log("project page render");
        console.log(this.state);
        return (
            <div>

                <h1>Result page</h1>
                <p>for project {this.state.currentProject.name}</p>
                <form className='form-horizontal'>
                    <p>
                        <label for="name">Specify minimal number of days spent on project
                            <input type='text' name='days' id='days'
                                   defaultValue={0} onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <input type='button' name="search" value="search" onClick={this.search.bind(this)}/>
                    </p>
                </form>

                <p>
                    <Link to={'/userSearch'} activeClassName="active">back to project selection</Link>
                </p>
                {this.result()}
            </div>
        );
    }
}