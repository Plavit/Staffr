import Reflux from 'reflux';
import Actions from '../Actions/Action';
import axios from "axios";
import { hashHistory } from "react-router";
export default class LocationStore extends Reflux.Store{
    constructor(){
        super();
        this.state = {
            locations: {}
        };
        this.listenables = Actions;
    };
    onAllLocationLoad(){
        console.log('Hledani vsech location...');
        axios.get("rest/locations/getall").then((response) => {
            this.setState({ locations: response.data });
            // console.log(this.state);
        }).catch((error) => {
            console.log(error);
        });
    }

    onOneLocationLoad(){
        console.log('Hledani jedne location...');
        axios.get("rest/locations/{location}").then((response) => { // zavorka nebo ne
            this.setState({ locations: response.data }); // jeden string do pole

        }).catch((error) => {
            console.log(error);
        });
    }


};