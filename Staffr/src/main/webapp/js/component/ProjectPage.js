import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

import {
    MuiThemeProvider, Paper, Table, TableBody, TableHeader, TableHeaderColumn, TableRow,
    TableRowColumn
} from "material-ui";

export default class ProjectPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentProject: {},
            usersOnProject: []
        }
        this.store = ProjectStore;

    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        Actions.getProject(this.props.params.projectId);
        Actions.getAllUsersOnProjects(this.props.params.projectId);
    }

    render() {
        console.log("project page render");
        var info = '';
        if (this.props.location.query.edit != null) {
            info = "Update was succesfull\n";
        }
        return (
            <MuiThemeProvider>
                <div style={{textAlign: 'center', padding: '50px', position: 'relative'}}>
                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <h1>{this.state.currentProject.name}</h1><br/>
                        <h3>{this.state.currentProject.description}</h3>
                        {info}
                        <p><Link to={`/projects/edit/${this.state.currentProject.id}`}>edit</Link></p>
                        <p><Link to={`/projects`} activeClassName="active">back to projects page</Link></p>
                        <h3>Users on project:</h3>
                        <Table>
                            <TableHeader
                                displaySelectAll={false}
                            >
                            <TableRow>
                                <TableHeaderColumn>First Name</TableHeaderColumn>
                                <TableHeaderColumn>Last Name</TableHeaderColumn>
                                <TableHeaderColumn>Birth Year</TableHeaderColumn>
                                <TableHeaderColumn>Email</TableHeaderColumn>
                                <TableHeaderColumn></TableHeaderColumn>
                            </TableRow>
                            </TableHeader>
                            <TableBody
                                displayRowCheckbox={false}
                            >
                            {
                                this.state.usersOnProject.map(user => {
                                    if (!(this.state.usersOnProject.length > 0)) {
                                        return <p>There are no users on this project.</p>
                                    } else {
                                        return (
                                            <TableRow key={user.id}>
                                                <TableRowColumn>{user.firstName}</TableRowColumn>
                                                <TableRowColumn>{user.lastName}</TableRowColumn>
                                                <TableRowColumn>{user.birthYear}</TableRowColumn>
                                                <TableRowColumn>{user.email}</TableRowColumn>
                                                <TableRowColumn>
                                                    <Link to={`/users/${user.id}`} activeClassName="active">Show user
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