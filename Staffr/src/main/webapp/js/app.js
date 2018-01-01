import React from "react";
import ReactDOM from "react-dom";
import {browserHistory, hashHistory, IndexRoute, Route, Router} from "react-router";
import loginPage from "./component/Login";

const app = document.getElementById('app');

// Actions.userInit();

ReactDOM.render(
    <Router history={hashHistory}>
        {/*<Route path="/">*/}
            {/*<Route component={requireAuth}>*/}
                {/*<IndexRoute component={welcomePage}/>*/}
                {/*<Route path="filter" component={filterPage}/>*/}
                {/*<Route path="test" component={testPage}/>*/}
                {/*<Route path="result" component={resultPage}/>*/}
                {/*<Route path="logintest" components={loginTestPage}/>*/}
                {/*<Route path="administrace" components={adminPage}/>*/}
                {/*<Route path="resultUser" components={resultUser}/>*/}
                {/*<Route path="deleted" components={deleteUser}/>*/}
                {/*<Route path="resultDetails" components={resultDetails}/>*/}
            {/*</Route>*/}

            <Route path="login" component={loginPage}/>
            {/*<Route path="register" component={volunteerRegisterPage}/>*/}
            {/*<Route path="success" component={successPage}/>*/}
        {/*</Route>*/}
    </Router>,
    app
);