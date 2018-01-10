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

export default class UserSearchPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            projects: [],
            userId: {}
        }
        this.store = ProjectStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        this.state.userId = this.props.params.userId;
        Actions.getAllProjects();
    }

    render() {
        return (
            <MuiThemeProvider>
                <div style={{textAlign: 'center', padding: '50px', position: 'relative'}}>
                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <h1>Search users on project</h1>
                        <h2>Select project:</h2>
                        <form>
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
                                        this.state.projects.map(project => {
                                            return (
                                                <TableRow key={project.id}>
                                                    <TableRowColumn>{project.name}</TableRowColumn>
                                                    <TableRowColumn>{project.description}</TableRowColumn>
                                                    <TableRowColumn>
                                                        <Link
                                                            to={`/userSearchPage/searchCriteria/${project.id}`}
                                                            activeClassName="active">
                                                            select project
                                                        </Link>
                                                    </TableRowColumn>
                                                </TableRow>
                                            );
                                        })
                                    }
                                </TableBody>
                            </Table>
                        </form>
                        <p><Link to={`/`} activeClassName="active">Back to main menu</Link></p>
                    </Paper>
                </div>
            </MuiThemeProvider>
        );
    }
}