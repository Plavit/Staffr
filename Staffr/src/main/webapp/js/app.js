'use strict';

import React from "react";
import ReactDOM from "react-dom";
import {browserHistory, hashHistory, IndexRoute, Route, Router} from "react-router";
import loginPage from "./component/Login";
import userInterface from "./component/UserInterface"
import requireAuth from "./component/RequireAuth"

const app = document.getElementById('app');

// Actions.userInit();

ReactDOM.render(
    <Router history={hashHistory}>
            <Route path="/">
                    <Route component={requireAuth}>
                            <Route component={userInterface}/>
                        {/*<Route path="userInterface" component={userInterface}/>*/}
                    </Route>
                    <Route path="login" component={loginPage}/>
            </Route>
    </Router>,
app
);