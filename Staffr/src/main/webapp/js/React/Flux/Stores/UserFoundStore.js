/**
 * Created by Aneta on 6. 2. 2017.
 */
import Reflux from 'reflux';
import Actions from '../Actions/Action';
import axios from "axios";
import { hashHistory } from "react-router";

export default class UserFoundStore extends Reflux.Store {

    constructor() {
        super();
        this.state = {
            userResponse: {}
        };
        this.listenables = Actions;
    };

    onUserFound(e){

        console.log("user found");
        this.setState({userResponse: e.data});

        hashHistory.push({
            pathname: 'resultUser'

        });


        console.log(this.state);
    }
}