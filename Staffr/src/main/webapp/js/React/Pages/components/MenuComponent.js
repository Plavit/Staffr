/**
 * Created by Aneta on 4. 2. 2017.
 */
import React from "react";
import Reflux from "reflux";
import {Button, Nav, NavItem, Navbar, MenuItem, NavDropdown} from 'react-bootstrap';
import UserStore from "../../Flux/Stores/UserStore";
import axios from "axios";
import Actions from "./../../Flux/Actions/Action";
import { hashHistory } from "react-router";
export default class MenuComponent extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {};
        this.store = UserStore;
    }
    componentDidMount(){
        Actions.userInit()
    }
    redirectToFilter(){
        hashHistory.push({
            pathname: 'filter'
        });
    }

    redirectToAdminPage(){
        hashHistory.push({
            pathname: 'administrace'
        });
    }

    changePasswd() {
        hashHistory.push({
            pathname: 'passwd'
        });

    }

    render() {
        console.log(this.state)
        // if (this.state.isLoaded) {
        return (
            <Navbar collapseOnSelect>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#">CDBD</a>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav>
                        <NavItem onSelect={this.redirectToFilter.bind(this)}>Filter</NavItem>
                        <NavItem onSelect={this.redirectToAdminPage.bind(this)}>Administrace</NavItem>
                    </Nav>
                    <Nav pullRight>
                        <NavDropdown eventKey={3} title={this.state.users.username} id="basic-nav-dropdown">
                            
                            <MenuItem eventKey={3.1} onSelect={Actions.changePasswd.bind(this)}>Změnit heslo</MenuItem>
                            <MenuItem eventKey={3.2}>Another action</MenuItem>
                            <MenuItem eventKey={3.3}>Something else here</MenuItem>
                            <MenuItem divider/>
                            <MenuItem eventKey={3.3} onSelect={Actions.logout.bind(this)}>Odhlásit se</MenuItem>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )

    }
}