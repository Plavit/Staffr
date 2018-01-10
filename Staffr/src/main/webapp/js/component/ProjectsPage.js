import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

import {
    Table,
    TableBody,
    TableHeader,
    TableHeaderColumn,
    TableRow,
    TableRowColumn,
} from 'material-ui/Table';
import {MuiThemeProvider, Paper} from "material-ui";

export default class ProjectsPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            projects: []
        }
        this.store = ProjectStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        console.log("componentWillMount");
        super.componentWillMount();
        Actions.getAllProjects();
    }

    render() {
        console.log("projects page overview render");
        var info = '';
        if (this.props.location.query.del != null) {
            info = "Project deleted\n";
        }
        return (
            <MuiThemeProvider>
                <div style={{textAlign: 'center', padding: '50px', position: 'relative'}}>
                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <h1>Projects</h1>
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
                                                <TableRowColumn id="foo">{project.name}</TableRowColumn>
                                                <TableRowColumn>{project.description}</TableRowColumn>
                                                <TableRowColumn>
                                                    <Link to={`/projects/${project.id}`} activeClassName="active">show
                                                        project
                                                        page</Link>
                                                </TableRowColumn>
                                            </TableRow>
                                        );
                                    })
                                }
                                </TableBody>
                            </Table>
                        </form>
                        <p><Link to={`/projects/create`} activeClassName="active">create new project</Link></p>
                        <p><Link to={`/`} activeClassName="active">back to main page</Link></p>
                    </Paper>
                </div>
            </MuiThemeProvider>
        );
    }


}