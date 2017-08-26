/**
 * Created by Aneta on 23. 1. 2017.
 */
'use strict';
import Reflux from 'reflux';
import Actions from '../Actions/Action';
import axios from "axios";
import { hashHistory } from "react-router";
export default class UserStore extends Reflux.Store{
    constructor(){
        super();
        this.state = {
            users: {},
            isLoaded: false,
        };
        this.listenables = Actions;
    };
    onUserInit(){
        console.log('User Init Function was fired');
        axios.get("rest/users/current").then((response) => {
            this.setState({
                users: response.data,
                isLoaded: true
            }) ;
            console.log(this.state);
        }).catch((error) => {
            console.log(error);
            hashHistory.push("/login");
        });
    };
    onLogout() {
        this.setState({
            isLoaded: false,
            users: {}
        });
        console.log(this.state);
        axios.get('j_spring_security_logout')
            .then(function (response) {
                console.log(response);
                window.location.reload();
            })
            .catch(function (response) {
                console.log("err" + response);
            })
    };

    onUserDelete(username, id, role) {




        console.log("Delete "+username);

        axios.delete("rest/users/"+id)

            .then((response) => {


            console.log(response);

            hashHistory.push({
                pathname: 'deleted'

            });


        }).catch((error) => {
        console.log(error);

})}


};