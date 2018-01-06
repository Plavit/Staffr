import Reflux from "reflux";
import React from "react";
import Actions from "../actions/Actions";
import UserStore from "../store/UserStore";
import {hashHistory} from "react-router";
import {Link} from "react-router";

export default class LogoutPage extends Reflux.Component {

    constructor(props) {
        super(props);
        this.state = {};
        Actions.userLogout();
    };

    render() {
        console.log("Loging out");
        return (
            <div>
                <p>You have succesfuly loged out.</p>
                <Link to={"/"} activeClassName="active">Back to index.</Link><br/>
            </div>
        );
    }
}
