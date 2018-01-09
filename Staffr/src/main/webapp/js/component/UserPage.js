import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import UserStore from '../store/UserStore';
import Actions from '../actions/Actions'

export default class UserPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentUser: {},
            usersProjects: []
        }
        this.store = UserStore;
    }

    componentDidMount() {
        Actions.userInit();
        Actions.getUser(this.props.params.userId);
        Actions.getUsersProjects(this.props.params.userId);
    }

    componentWillMount() {
        super.componentWillMount();
    }

    render() {
        var info = '';
        if (this.props.location.query.edit != null){
            info = "Update was succesfull\n";
        }
        return (
            <div>
                <style>{`table td{border:1px solid black; padding: 5px}`}</style>
                {info}
                <h1>Two by two we're marching door to door! <br/>
                    'Cause God loves Users and he wants some more!</h1>
                <h2>{this.state.currentUser.firstName}</h2>
                <p>{this.state.currentUser.lastName}</p>
                <p><Link to={`/users/edit/${this.state.currentUser.id}`}>edit</Link></p>
                <p><Link to={`/users`} activeClassName="active">back to users page</Link></p>
                <h3>Users on project:</h3>
                <table>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.usersProjects.map(project => {
                            if (!(this.state.usersProjects.length > 0)) {
                                return <p>There are no users on this project.</p>
                            } else {
                                return (
                                    <tr key={project.id}>
                                        <td id="foo">{project.name}</td>
                                        <td>{project.description}</td>
                                        <td>
                                            <Link to={`/projects/${project.id}`} activeClassName="active">show project
                                                page</Link>
                                        </td>
                                    </tr>
                                );
                            }
                        })
                    }
                    </tbody>
                </table>
            </div>
        );
    }


}