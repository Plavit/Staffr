/**
 * Created by HMT on 14.01.2017.
 */
'use strict';
import Reflux from 'reflux';
import Actions from '../Actions/Action';
import axios from "axios";

export default class VolunteerStore extends Reflux.Store{

    constructor(){
        super();
        this.state = {
            volunteers: [],
            isLoaded: false,
            someVal: 5
        };
        this.listenables = Actions;
    };

    // onLoadAllVolunteers(){
    //     console.log('load all vol Function was fired');
    //     axios.get("rest/volunteer/getall").then((response) => {
    //
    //         this.setState({
    //             volunteers: response.data,
    //             isLoaded: true,
    //             someVal: 1
    //         }) ;
    //
    //     }).catch((error) => {
    //         console.log(error);
    //     });
    // }

};

