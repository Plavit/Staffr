import React from "react";
import Reflux from "reflux";

export default class VolunteerProfile extends Reflux.Component {
    constructor() {
        super();
    }
    render() {
        console.log("in volunteers component " + this.props.volunteers.id)
        return (<div>sd</div>);
    }
}