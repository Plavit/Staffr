import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import Actions from "../actions/Actions";
import UserStore from "../store/UserStore";
import {MuiThemeProvider, Paper} from "material-ui";

export default class UserInterface extends Reflux.Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    componentWillMount() {
    }

    componentDidMount() {

    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    render() {
        return (
            <MuiThemeProvider>
                <div style={{textAlign: 'center', padding: '50px', position: 'relative'}}>
                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <img src="../../resources/img/Staffr_logo_med.png" style={{height: '30%'}}/>
                        <h1 >Congratulations, you are logged in.</h1>
                        <h3><Link to={"/projects"} activeClassName="active">Projects overview</Link></h3><br/>
                        <h3><Link to={"/users"} activeClassName="active">Users overview</Link></h3><br/>
                        <h3><Link to={"/userSearch"} activeClassName="active">User search</Link></h3><br/>
                    </Paper>
                </div>
            </MuiThemeProvider>
        );
    }
}