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
            name: null,
            description: null
        }
        this.store = UserStore;
    }

    componentDidMount() {userId;
        console.log("id of this user is:" + id);

        Actions.getUser(id);

        this.state.name = this.state.currentUser.name;
        this.state.description = this.state.currentUser.description;

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

    update(e) {
        e.preventDefault();
        console.log("Before:" + this.state.currentUser);
        console.log("Update trigger: " + this.state.name);
        console.log("Update trigger: " + this.state.description);

        this.state.currentUser.name = this.state.name;
        this.state.currentUser.description = this.state.description;
        console.log("After:" + this.state.currentUser);


        axios.post('/rest/user/update', this.state.currentUser).then(function (response) {
        }).catch(function (error) {
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
        console.log("user page render");
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
                        <label for="name">User name:
                            <input type='text' name='name' id='name'
                                   defaultValue={this.state.currentUser.name} onChange={this.onChange}/>
                        </label>
                    </p>

                    <p>
                        <label for="description">User description:
                            <input type='textarea' name='description' id='description'
                                   defaultValue={this.state.currentUser.description} onChange={this.onChange}/>
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