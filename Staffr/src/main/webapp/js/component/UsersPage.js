import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import UserStore from '../store/UserStore';
import Actions from '../actions/Actions'

export default class UsersPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        }
        this.store = UserStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        console.log("componentWillMount");
        super.componentWillMount();
        Actions.getAllUsers();
        console.log(this.state.users);
    }

    render() {
        console.log("users overview page render");
        var info = '';
        if (this.props.location.query.del != null) {
            info = "User deleted\n";
        }
        return (
            <div>
                <style>{`table td{border:1px solid black; padding: 5px}`}</style>
                {info}
                <h1>Users</h1>
                <form>
                    <table>
                        <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>

                        {/*TODO add table content*/}

                        </tbody>
                    </table>
                </form>
                <p><Link to={`/`} activeClassName="active">back to main page</Link></p>
            </div>
        );
    }


}