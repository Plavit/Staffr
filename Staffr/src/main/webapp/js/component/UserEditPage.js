import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";

import axios from "axios";
import querystring from "querystring";

import UserStore from '../store/UserStore';
import Actions from '../actions/Actions'

export default class UserEditPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentUser: {},
            firstName: null,
            lastName: null
        }
        this.store = UserStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        var id = this.props.params.userId;
        Actions.getUser(id);
    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    update(e) {
        e.preventDefault();
        console.log("Before:" + this.state.currentUser);
        console.log(this.state.currentUser);

        if (this.state.firstName != null) {
            this.state.currentUser.firstName = this.state.firstName;
        }

        if (this.state.lastName != null) {
            this.state.currentUser.lastName = this.state.lastName;
        }

        console.log("After:");
        console.log(this.state.currentUser);

        axios.post('/rest/user/update', this.state.currentUser)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
            console.log(error);
        });

        Actions.getUser(this.state.currentUser.id);

        hashHistory.push({
            pathname: "/users/" + this.state.currentUser.id,
            query: {edit: true}
        });
        return false;
    }

    deleteUser() {
        Actions.deleteUser(this.state.currentUser.id);
        // Actions.deleteUser(this.state.curr.username, this.state.currentUser.id, this.state.userResponse.userRole);
    };

    render() {
        return (
            <div>

                <h1>...A six month project full of sleepless nights—
                    We are the users of Staffr and it is nice!.
                    <br/>
                    <br/>
                    ...for latter day Enterprise Architectures.
                </h1>

                <form className='form-horizontal'>
                    <p>
                        <label for="name">First Name:
                            <input type='text' name='firstName' id='firstName'
                                   defaultValue={this.state.currentUser.firstName} onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <label for="description">Last Name:
                            <input type='text' name='lastName' id='lastName'
                                   defaultValue={this.state.currentUser.lastName} onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <input type='button' name="submit" value="update" onClick={this.update.bind(this)}/>
                    </p>
                    <p>
                        <p><input type='button' name="delete" value="delete" onClick={this.deleteUser.bind(this)}/></p>
                    </p>
                </form>

                <p>
                    return <Link to={'/users/' + this.state.currentUser.id} activeClassName="active">back</Link>
                </p>

            </div>
        );
    }
}