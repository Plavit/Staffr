/**
 * Created by Aneta on 5. 2. 2017.
 */
import React from "react";
import Reflux from "reflux";
import Actions from "../Flux/Actions/Action";
import {Button, FormControl, Col, ControlLabel, FormGroup, Checkbox, Table} from 'react-bootstrap';
import UserStore from "../Flux/Stores/UserStore";
import UserFoundStore from "../Flux/Stores/UserFoundStore";
import MenuComponent from "./components/MenuComponent";

import axios from "axios";
import {router, hashHistory} from "react-router";
export default class AdminPage extends Reflux.Component {
    constructor() {
        super();
        this.state = {
            user: {
                username: ''
            },

            userResponse: {

                id: '',
                username: '',
                userRole: ''
            }

        };
        this.stores = [UserStore, UserFoundStore];
    }

    onChange = (e) => {
        var change = this.state.user;
        change[e.target.name] = e.target.value;
        this.setState({user: change});
        console.log(this.state);
    };

    findUser(e) {
        e.preventDefault();
        var login=this.state.user.username;

        axios.get("rest/users/"+login).then((response) => {


            console.log(response);

            Actions.userFound(response);

        }).catch((error) => {
            console.log(error);

        })}

    returnBack(e) {
        e.preventDefault();

        hashHistory.push({
            pathname: '/'
            });


        }



    render() {

        if(this.state.users.userRole=='ADMIN_ROLE'){
            return (
                <div>
                    <MenuComponent/>
                    <Col md={8} xsOffset={2}>

                        <h2> Vyhledání uživatele dle uživatelského jména: </h2>
                        <form>

                            
                            <FormControl
                            type="text"
                            value={this.state.value}
                            placeholder="Zadejte uživatelské jméno"
                            name="username"
                            onChange={this.onChange}
                            />
                            <p>
                            <Button onClick={this.findUser.bind(this)} type="submit">Vyhledat uživatele</Button>
                            </p>

                        </form>
                    </Col>
                </div>

                    )

    }

    else {
            return (
                <div>
                    <Col md={8} xsOffset={2}>

                        <h3> Nemáte oprávnění k přístupu do administrátorské sekce! </h3>
                        <p><Button onClick={this.returnBack.bind(this)} type="submit">Vrátit se zpět</Button></p>
                    </Col>
                </div>

            )

        }

    }


}