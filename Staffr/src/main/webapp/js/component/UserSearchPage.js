import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";

import ProjectStore from '../store/ProjectStore';
import Actions from '../actions/Actions'

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
            <div>
                <style>{`table td{border:1px solid black; padding: 5px}`}</style>
                <h1>Search users on project</h1>
                <p>select project:</p>
                <form>
                    <table>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.projects.map(project => {
                                return (
                                    <tr key={project.id}>
                                        <td>{project.name}</td>
                                        <td>{project.description}</td>
                                        <td>
                                            <Link
                                                to={`/userSearchPage/searchCriteria/${project.id}`}
                                                activeClassName="active">
                                                select project
                                            </Link>
                                        </td>
                                    </tr>
                                );
                            })
                        }
                        </tbody>
                    </table>
                </form>
                <p><Link to={`/`} activeClassName="active">back to main menu</Link></p>
            </div>
        );
    }
}