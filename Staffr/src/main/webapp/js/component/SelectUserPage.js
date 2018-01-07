import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import UserStore from '../store/UserStore';
import Actions from '../actions/Actions'

export default class SelectUserPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            allUsers: [],
            projectId: {}
        }
        this.store = UserStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        this.state.projectId = this.props.params.projectId;
        Actions.getAllUsers();
    }

    addUserToProject(userId) {
        console.log("SELECT USER PAGE: adding user " + userId + " to project " + this.state.projectId);
    }


    render() {
        return (
            <div>
                <style>{`table td{border:1px solid black; padding: 5px}`}</style>
                <h1>Users</h1>
                <form>
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
                            this.state.allUsers.map(user => {
                                return (
                                    <tr key={user.id}>
                                        <td>{user.firstName}</td>
                                        <td>{user.lastName}</td>
                                        <td>{user.birthYear}</td>
                                        <td>{user.email}</td>
                                        <td>
                                            <Link
                                                to={`/projects/edit/${this.state.projectId}`}
                                                activeClassName="active"
                                                onClick={() => { this.addUserToProject(user.id)}}>
                                                add to project
                                            </Link>
                                        </td>
                                    </tr>
                                );
                            })
                        }
                        </tbody>
                    </table>
                </form>
                <p><Link to={`/projects/edit/${this.state.projectId}`} activeClassName="active">back to project
                    page</Link></p>
            </div>
        );
    }


}