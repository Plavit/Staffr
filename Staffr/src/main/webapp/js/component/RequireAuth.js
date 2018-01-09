import Reflux from "reflux";
import React from "react";
import Actions from "../actions/Actions";
import UserStore from "../store/UserStore";
import {hashHistory} from "react-router";

export default class requireAuth extends Reflux.Component {

    constructor(props) {
        super(props);
        this.state = {};
        this.store = UserStore;
    };

    render() {
        return (
            <div>
WRAPPER
                {this.props.children}
                WRAPPERIO
            </div>
        )
    }

    componentDidMount() {
        Actions.userInit();
    }
}
