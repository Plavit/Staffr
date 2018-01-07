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
            currentUser: {}
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

    render() {
        var info = '';
        if (this.props.location.query.edit != null){
            info = "Update was succesfull\n";
        }
        return (
            <div>
                {info}
                <h1>Two by two we're marching door to door! <br/>
                    'Cause God loves Users and he wants some more!</h1>
                <h2>{this.state.currentUser.firstName}</h2>
                <p>{this.state.currentUser.lastName}</p>
                <p><Link to={`/users/edit/${this.state.currentUser.id}`}>edit</Link></p>
                <p><Link to={`/users`} activeClassName="active">back to users page</Link></p>
            </div>
        );
    }


}