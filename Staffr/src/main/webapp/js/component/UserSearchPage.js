import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";

import axios from "axios";
import querystring from "querystring";

import UserStore from '../store/UserStore';
import Actions from '../actions/Actions'
import ProjectStore from "../store/ProjectStore";

export default class UserSearchPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentUser: {},
            time: {},
            project: {}
        }
        this.store = UserStore;
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

    search(e) {
        e.preventDefault();
        return false;
    }

    render() {
        return (
            <div>
                <h1>Search users on project</h1>
                <form className='form-horizontal'>
                    <p>
                        Selector...
                    </p>
                    <p>
                        <label for="description">Minimal time spent on project:
                            <input type='date' name='time' id='time' onChange={this.onChange}/>
                        </label>
                    </p>
                    <p>
                        <input type='button' name="search" value="addProject" onClick={this.search.bind(this)}/>
                    </p>
                </form>
                <p>
                    <Link to={'/'} activeClassName="active">back to main menu</Link>
                </p>
            </div>
        );
    }
}