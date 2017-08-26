/**
 * Created by Aneta on 5. 2. 2017.
 */
import React from "react";
import Reflux from "reflux";
import {Button, Nav, NavItem, Navbar, MenuItem, NavDropdown} from 'react-bootstrap';
import FiltrStore from "../../Flux/Stores/FilterStore";
import axios from "axios";
import Actions from "./../../Flux/Actions/Action";
import { hashHistory } from "react-router";
export default class VolunteerTable extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.store = FiltrStore;
    }


    render() {
        var name = this.state.volunteerFound.firstname;
        <span>
        {this.state.volunteerFound.firstname}
      </span>;
        return (
            <tr>
                <td>{name}</td>
                <td>{this.state.volunteerFound.lastname}</td>
            </tr>
        );
    }
}