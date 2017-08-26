import React from "react";
import Reflux from "reflux"
import axios from 'axios';
import VolunteerStore from "../Flux/Stores/VolunteerStore";
import Actions from "../Flux/Actions/Action"
import LocationStore from "../Flux/Stores/LocationStore";


export default class Test extends Reflux.Component {

    constructor(props) {
        super(props);
        this.store = LocationStore;

        // Actions.loadAllVolunteers();
    }

    componentDidMount() {
        Actions.allLocationLoad();
    };


    render() {

        return (
            <form>

                <input type="submit" value="Submit"/>
            </form>
        )
    }
}