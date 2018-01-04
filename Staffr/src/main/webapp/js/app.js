import React from "react";
import ReactDOM from "react-dom";
import {browserHistory, hashHistory, IndexRoute, Route, Router, Redirect} from "react-router";

import loginPage from "./component/LoginPage";
import userInterface from "./component/UserInterface";
import testPage from "./component/TestPage";
import projectPage from "./component/ProjectPage";

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
            <Route path="login" component={loginPage}/>
            <Route path="test" component={testPage}/>
            <Route path="projects" component={projectPage}/>
        </Route>
    </Router>,
    app
);