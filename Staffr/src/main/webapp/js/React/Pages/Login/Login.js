import React from "react";
import querystring from "querystring";
import {Link, router, hashHistory} from "react-router";

import axios from "axios";
import {ControlLabel,FormControl,Col,Button} from "react-bootstrap";

export default class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: ''
        };
    }
    onChange = (e) => {
        var change = {};
        change[e.target.name] = e.target.value;
        this.setState(change);
    };
    login(e) {
        e.preventDefault();
        axios.post('j_spring_security_check', querystring.stringify({
            username: this.state.username,
            password: this.state.password
        })).then(function (response) {
            console.log(response);
            hashHistory.push({
                pathname: ''
            });
        })
            .catch(function (response) {
                console.log(response);
            })
        return false;
    }

    render() {
        return (

            <Col md={2}>
                <form>
                    <ControlLabel>Login form</ControlLabel>
                    <FormControl
                        type="text"
                        placeholder="Zadejte uzivatelske jmeno"
                        name = 'username'
                        onChange={this.onChange}
                    />
                    <FormControl
                        type="password"
                        placeholder="Zadejte heslo"
                        name = "password"
                        onChange={this.onChange}
                    />
                    <Button onClick={this.login.bind(this)} type="submit">Odeslat login</Button>
                </form>
            </Col>

        )
    }
}