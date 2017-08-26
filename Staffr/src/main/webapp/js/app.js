import React from "react";
import ReactDOM from "react-dom";
import loginPage from "./React/Pages/Login/Login";
import testPage from "./React/Pages/Test";
import filterPage from "./React/Pages/Filter/Filter";
import loginTestPage from "./React/Pages/LoginTest";
import adminPage from "./React/Pages/AdminPage";
import requireAuth from "./React/Pages/components/requireAuth";
import Actions from "./React/Flux/Actions/Action";
import welcomePage from "./React/Pages/Welcome/WelcomePage";
import resultPage from "./React/Pages/Result/Result";
import successPage from "./React/Pages/Result/SuccessPage";
import volunteerRegisterPage from "./React/Pages/Register/VolunteerRegister";
import resultUser from "./React/Pages/Result/ResultUser";
import deleteUser from "./React/Pages/Result/DeleteUser";
import resultDetails from "./React/Pages/Result/ResultDetails";
import { browserHistory, hashHistory, IndexRoute, Route, Router } from "react-router";
const app = document.getElementById('app');
Actions.userInit();
ReactDOM.render(
    <Router history={hashHistory}>
        <Route path="/">
            <Route component={requireAuth}>
                <IndexRoute component={welcomePage}/>
                <Route path="filter" component={filterPage}/>
                <Route path="test" component={testPage}/>
                <Route path="result" component={resultPage}/>
                <Route path="logintest" components={loginTestPage}/>
                <Route path="administrace" components={adminPage}/>
                <Route path="resultUser" components={resultUser}/>
                <Route path="deleted" components={deleteUser}/>
                <Route path="resultDetails" components={resultDetails}/>

            </Route>
            <Route path="login" component={loginPage}/>
            <Route path="register" component={volunteerRegisterPage}/>
            <Route path="success" component={successPage}/>
        </Route>
    </Router>,
    app);