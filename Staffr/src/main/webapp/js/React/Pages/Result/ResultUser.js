/**
 * Created by Aneta on 5. 2. 2017.
 */
import React from "react";
import Reflux from "reflux";
import querystring from "querystring";
import Actions from "../../Flux/Actions/Action";
import {Button, FormControl, Col, ControlLabel, FormGroup, Checkbox, Table} from 'react-bootstrap';
import UserFoundStore from "../../Flux/Stores/UserFoundStore";
import UserStore from "../../Flux/Stores/UserStore";
import MenuComponent from "../components/MenuComponent";
import axios from "axios";
import {router, hashHistory} from "react-router";
export default class ResultUser extends Reflux.Component {

    constructor() {
        super();
        this.state = {
            userFound: {
            }
        };

        this.stores = [UserFoundStore, UserStore];
    }


    deleteUser(e){

        e.preventDefault();

        var nameDelete=this.state.userResponse.username;
        var idDelete=this.state.userResponse.id;
        console.log("resultUser in deleteUser method"+this.state.userResponse);
        Actions.userDelete(this.state.userResponse.username, idDelete, this.state.userResponse.userRole);



        

        }

    render() {

        var id=this.state.userResponse.id;
        var name=this.state.userResponse.username;
        // var name=this.state.userResponse.username;
        var role=this.state.userResponse.userRole;

        return (
            <div><MenuComponent/>
                <Col md={8} xsOffset={2}>
                <form>
                <Table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Uživatelské jméno</th>
                            <th>Role</th>
                        </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th>{id}</th>
                        <th>{name}</th>
                        <th>{role}</th>
                        <th><Button onClick={this.deleteUser.bind(this)} type="submit">Vymazat uživatele</Button></th>

                    </tr>
                    </tbody>
                </Table>
                </form>
                </Col>
            </div>

        )

    }


}


