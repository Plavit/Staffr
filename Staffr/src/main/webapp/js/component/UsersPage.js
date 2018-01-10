import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import UserStore from '../store/UserStore';
import Actions from '../actions/Actions'
import {
    MuiThemeProvider, Paper, Table, TableBody, TableHeader, TableHeaderColumn, TableRow,
    TableRowColumn
} from "material-ui";

export default class UsersPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            allUsers: []
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
        console.log("Users in state" + this.state.allUsers);
    }

    render() {
        console.log("users overview page render");
        var info = '';
        if (this.props.location.query.del != null) {
            info = "User deleted\n";
        }
        return (
            <MuiThemeProvider>
                <div style={{textAlign: 'center', padding: '50px', position: 'relative'}}>
                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <h1>Users</h1>
                        <h3>{info}</h3>
                        <form>
                            <Table>
                                <TableHeader
                                    displaySelectAll={false}
                                >
                                    <TableRow>
                                    <TableHeaderColumn>First Name</TableHeaderColumn>
                                    <TableHeaderColumn>Last Name</TableHeaderColumn>
                                    <TableHeaderColumn>Birth Year</TableHeaderColumn>
                                    <TableHeaderColumn>Email</TableHeaderColumn>
                                    <th></th>
                                    </TableRow>
                                </TableHeader>
                                <TableBody
                                    displayRowCheckbox={false}
                                >

                                {
                                    this.state.allUsers.map(user => {
                                        return (
                                            <TableRow key={user.id}>
                                                <TableRowColumn>{user.firstName}</TableRowColumn>
                                                <TableRowColumn>{user.lastName}</TableRowColumn>
                                                <TableRowColumn>{user.birthYear}</TableRowColumn>
                                                <TableRowColumn>{user.email}</TableRowColumn>
                                                <TableRowColumn>
                                                    <Link to={`/users/${user.id}`} activeClassName="active">User
                                                        page</Link>
                                                </TableRowColumn>
                                            </TableRow>
                                        );
                                    })
                                }
                                </TableBody>
                            </Table>
                        </form>
                        <p><Link to={`/`} activeClassName="active">Back to main page</Link></p>
                    </Paper>
                </div>
            </MuiThemeProvider>
        );
    }


}