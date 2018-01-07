import React from "react";
import ReactDOM from "react-dom";
import {browserHistory, hashHistory, IndexRoute, Route, Router, Redirect} from "react-router";

import loginPage from "./component/LoginPage";
import logoutPage from "./component/LogoutPage";

import userInterface from "./component/UserInterface";
import testPage from "./component/TestPage";

import projectsPage from "./component/ProjectsPage";
import projectPage from "./component/ProjectPage"
import projectEditPage from "./component/ProjectEditPage";

import usersPage from "./component/UsersPage";
import userPage from "./component/UserPage";
import userEditPage from "./component/UserEditPage";


import requireAuth from "./component/RequireAuth";
import Actions from "./actions/Actions";

const app = document.getElementById('app');

Actions.userInit();
console.log("Hello");

ReactDOM.render(
    <Router history={hashHistory}>
        <Route path="/">
            <Route component={requireAuth}>
                {/*<Route component={userInterface}/>*/}
                <IndexRoute component={userInterface}/>
                <Route path="userInterface" component={userInterface}/>
            </Route>
            <Route path="logout" component={logoutPage}/>
            <Route path="login" component={loginPage}/>
            <Route path="test" component={testPage}/>
            <Route path="projects" component={projectsPage}/>
            <Route path="projects/:projectId" component={projectPage}/>
            <Route path="projects/edit/:projectId" component={projectEditPage}/>
            <Route path="users" component={usersPage}/>
            <Route path="users/:userId" component={userPage}/>
            <Route path="users/edit/:userId" component={userEditPage}/>
        </Route>
    </Router>,
    app
);