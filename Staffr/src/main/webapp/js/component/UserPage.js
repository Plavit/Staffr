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

export default class UserPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentUser: {},
            usersProjects: []
        }
        this.store = UserStore;
    }

    componentDidMount() {
        Actions.userInit();
        Actions.getUser(this.props.params.userId);
        Actions.getUsersProjects(this.props.params.userId);
    }

    componentWillMount() {
        super.componentWillMount();
    }

    render() {
        var info = '';
        if (this.props.location.query.edit != null){
            info = "Update was succesfull\n";
        }
        return (
            <MuiThemeProvider>
                <div style={{textAlign: 'center', padding: '50px', position: 'relative'}}>
                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <h1>{this.state.currentUser.firstName} {this.state.currentUser.lastName}</h1>
                {info}
                {/*<h1>Two by two we're marching door to door! <br/>*/}
                    {/*'Cause God loves Users and he wants some more!</h1>*/}
                <h2><Link to={`/users/edit/${this.state.currentUser.id}`}>edit</Link></h2>
                <h2><Link to={`/users`} activeClassName="active">back to users page</Link></h2>
                <h3>Users on project:</h3>
                <Table>
                    <TableHeader
                        displaySelectAll={false}
                    >
                    <TableRow>
                        <TableHeaderColumn>Name</TableHeaderColumn>
                        <TableHeaderColumn>Description</TableHeaderColumn>
                        <TableHeaderColumn></TableHeaderColumn>
                    </TableRow>
                    </TableHeader>
                    <TableBody
                        displayRowCheckbox={false}
                    >
                    {
                        this.state.usersProjects.map(project => {
                            if (!(this.state.usersProjects.length > 0)) {
                                return <p>There are no users on this project.</p>
                            } else {
                                return (
                                    <TableRow key={project.id}>
                                        <TableRowColumn id="foo">{project.name}</TableRowColumn>
                                        <TableRowColumn>{project.description}</TableRowColumn>
                                        <TableRowColumn>
                                            <Link to={`/projects/${project.id}`} activeClassName="active">Show project
                                                page</Link>
                                        </TableRowColumn>
                                    </TableRow>
                                );
                            }
                        })
                    }
                    </TableBody>
                </Table>
                    </Paper>
            </div>
            </MuiThemeProvider>
        );
    }


}