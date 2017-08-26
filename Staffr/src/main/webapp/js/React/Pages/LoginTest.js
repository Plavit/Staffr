// import React from "react";
// import Reflux from "reflux";
// import axios from "axios";
// import querystring from "querystring";
// import UserStore from "../Flux/Stores/UserStore";
//
// import {Button, Navbar, FormGroup, FormControl, ControlLabel,Col} from "react-bootstrap";
// export default class LoginTest extends Reflux.Component {
//
//     constructor(props){
//         super(props);
//         // this.state = {
//         //     value: ''
//         // };
//         this.store = UserStore;
//     }
//     //
//     // render() {
//     //     console.log(this.state);
//     //     if(this.state.isLoaded){
//     //         return (<div>show me stuff</div>)
//     //     }
//     //     else{
//     //         return (<div>dont show me anything</div>)}
//     // }
//     // getValidationState() {
//     //     const length = this.state.value.length;
//     //     if (length > 5) return 'success';
//     //     else if (length >0) return 'error';
//     // }
//     // handleChange(e) {
//     //     this.setState({ value: e.target.value });
//     // }
//     // login(e) {
//     //     e.preventDefault();
//     //     axios.post('j_spring_security_check', querystring.stringify({
//     //         username: this.usernamefield.value,
//     //         password: this.passwordfield.value
//     //     })).then(function (response) {
//     //         console.log(response);
//     //     })
//     //         .catch(function (response) {
//     //             console.log(response);
//     //         })
//     //     return false;
//     // }
//     render() {
//         return (
//         0
//         )
//     }
//
//     //         return (
// // <div>
// //             <form>
// //                 <FieldGroup
// //                     id="formControlsUsername"
// //                     type="text"
// //                     label="Username"
// //                     placeholder="Enter Username"
// //                 />
// //                 <FieldGroup
// //                     id="formControlsPassword"
// //                     label="Password"
// //                     type="password"
// //                 />
// //                 <Button type="submit">
// //                     Submit
// //                 </Button>
// //             </form>
// // </div>
// //         )
// }

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
                pathname: 'test'
            });
        })
            .catch(function (response) {
                console.log(response);
            })
        return false;
    }

    render() {
        return (

            <Col xs={6} md={4}>
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