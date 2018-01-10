import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";

import axios from "axios";
import querystring from "querystring";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

import {
    MuiThemeProvider, Paper, Table, TableBody, TableHeader, TableHeaderColumn, TableRow,
    TableRowColumn
} from "material-ui";

export default class UserSearchCriteriaPage extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {
            currentProject: {},
            days: 0,
            serched: false,
            projectId: {},
            usersOnProjectSearchResult: [],
            currentUserProject: {},
            userProjects: []
        }
        this.store = ProjectStore;
    }

    componentDidMount() {
        Actions.userInit();
    }

    componentWillMount() {
        super.componentWillMount();
        var id = this.props.params.projectId;
        this.state.projectId = id;
        Actions.getProject(id);
    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    search(e) {
        e.preventDefault();
        console.log(
            "USER SEATCH CRITERIA PAGE: searching for projectId: "
            + this.state.projectId +
            "; with min days: "
            + this.state.days
        );
        Actions.getUsersByProjectDuration(this.state.projectId, this.state.days);
        this.state.serched = true;
        console.log(this.state);
    }

    result() {
        if (this.state.serched) {
            return (
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
                                <TableHeaderColumn>Date start</TableHeaderColumn>
                                <TableHeaderColumn>Date end</TableHeaderColumn>
                                <TableHeaderColumn>Duration</TableHeaderColumn>
                                <TableHeaderColumn></TableHeaderColumn>
                            </TableRow>
                        </TableHeader>
                        <TableBody
                            displayRowCheckbox={false}
                        >
                            {
                                this.state.usersOnProjectSearchResult.map(userProject => {
                                    return (
                                        <TableRow key={userProject.employee.id}>
                                            <TableRowColumn>{userProject.employee.firstName}</TableRowColumn>
                                            <TableRowColumn>{userProject.employee.lastName}</TableRowColumn>
                                            <TableRowColumn>{userProject.employee.birthYear}</TableRowColumn>
                                            <TableRowColumn>{userProject.employee.email}</TableRowColumn>
                                            <TableRowColumn>{userProject.from}</TableRowColumn>
                                            <TableRowColumn>{userProject.end}</TableRowColumn>
                                            <TableRowColumn>{userProject.duration}</TableRowColumn>
                                            <TableRowColumn>
                                                <Link to={`/users/${userProject.employee.id}`} activeClassName="active">show
                                                    user
                                                    page</Link>
                                            </TableRowColumn>
                                        </TableRow>
                                    );
                                })
                            }
                        </TableBody>
                    </Table>
                </form>
            );
        }
    }

    render() {
        console.log("project page render");
        console.log(this.state);
        return (
            <MuiThemeProvider>
                <div style={{textAlign: 'left', padding: '50px', position: 'relative'}}>
                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <h1>Result page</h1>
                        <h2>for project: "{this.state.currentProject.name}"</h2>
                        <form className='form-horizontal'>
                            <p>
                                <label for="name">Specify minimal number of days spent on project
                                    <input type='text' name='days' id='days'
                                           defaultValue={0} onChange={this.onChange}/>
                                </label>
                            </p>

                            <p>
                                <input type='button' name="search" value="search" onClick={this.search.bind(this)}/>
                            </p>
                        </form>

                        <p>
                            <Link to={'/userSearch'} activeClassName="active">back to project selection</Link>
                        </p>
                        {this.result()}
                    </Paper>
                </div>
            </MuiThemeProvider>
        );
    }
}