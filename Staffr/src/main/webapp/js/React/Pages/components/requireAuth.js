import Reflux from "reflux";
import React from "react";
import Actions from "../../Flux/Actions/Action";
import UserStore from "../../Flux/Stores/UserStore";
import {hashHistory} from "react-router";

export default class requireAuth extends Reflux.Component {

    constructor(props) {
        super(props);
        this.state = {};
        this.store = UserStore;
    };



    render() {
        return (<div>{this.props.children}</div>)
    }
}
