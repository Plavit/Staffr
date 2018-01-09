import React from "react";
import Reflux from "reflux";
import {Alert, Button, Panel} from "react-bootstrap";
import {Link, Router, hashHistory} from "react-router";
import axios from "axios";
import querystring from "querystring";
import ReactDOM from 'react-dom';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import {Paper, TextField} from "material-ui";

export default class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: ''
        };
    }

    componentDidMount() {
    }

    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        state.alertVisible = false;
        this.setState(state);
    };

    onKeyPress = (e) => {
        if (e.key === 'Enter') {
            this.login();
        }
    };


    login(e) {
        e.preventDefault();
        console.log(this.state.username + " - " + this.state.password + "\n");
        console.log(querystring.stringify({
            username: this.state.username,
            password: this.state.password
        }));

        axios.post('j_spring_security_check', querystring.stringify({
            username: this.state.username,
            password: this.state.password
        })).then(function (response) {
            hashHistory.push({pathname: "/userInterface"});
        }).catch(function (error) {
            // console.log(error.toString());
            alert("Authentification error.");
        });
        return false;
    };

    // register = () => {
    //     Routing.transitionTo(Routes.register);
    // };


    render() {
        return (
            <MuiThemeProvider>
            <div>

                <h1 style={{color: '#FF0000'}}>Hello, my name is elder Price. And I have come to show you the most amazing book.</h1>
                <Paper zDepth={3} >
                <form className='form-horizontal'>
                    <p><label for="username">Username: </label>
                        <TextField type='text' name='username' id='username' onChange={this.onChange}/>

                    </p>
                    <p><label for="password">Password: </label>
                        <TextField type='password' name='password' id='password' onChange={this.onChange}/>
                    </p>
                    <RaisedButton label="Login" primary={true}	name="submit" value="login" onClick={this.login.bind(this)}/>
                    </form>
                </Paper>
            </div>
    </MuiThemeProvider>
        );
    }
}