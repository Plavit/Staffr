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
                <div style={{textAlign: 'center', padding: '50px', position: 'relative'}}>


                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <img src="../../resources/img/Staffr_logo_med.png" style={{height: '40%'}}/>
                        <h1>Login</h1>
                        <form className='form-horizontal'>

                            <br/>
                            <TextField type='text' floatingLabelText="Username" name='username' id='username' style={{padding: '4px'}} onChange={this.onChange}/>


                            <br/>
                            <TextField type='password' floatingLabelText="Password" name='password' id='password' style={{padding: '4px'}} onChange={this.onChange}/>
                            <br/>
                            <RaisedButton label="Login" primary={true} name="submit" value="login" fullWidth={false} style={{display: 'block', margin: '12px'}}
                                          onClick={this.login.bind(this)}/>
                        </form>
                    </Paper>
                </div>

            </MuiThemeProvider>

        );
    }
}

// <h1 style={{color: '#FF0000'}}>Hello, my name is elder Price. And I have come to show you the most
//     amazing book.</h1>