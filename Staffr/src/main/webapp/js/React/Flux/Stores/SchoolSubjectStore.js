/**
 * Created by Aneta on 19. 1. 2017.
 */
import Reflux from 'reflux';
import Actions from '../Actions/Action';
import axios from "axios";
import { hashHistory } from "react-router";
export default class SchoolSubjectStore extends Reflux.Store{
    constructor(){
        super();
        this.state = {
            subjects: []
        };
        this.listenables = Actions;
    };
    onAllSubjectLoad(){
        console.log('Hledani vsech predmetu...');
        axios.get("rest/subject").then((response) => {
            this.setState({ subjects: response.data });

        }).catch((error) => {
            console.log(error);
        });
    }

    onOneSubjectLoad(){
        console.log('Hledani jednoho predmetu...');
        axios.get("rest/subject/{subject}").then((response) => { // zavorka nebo ne
            this.setState({ subjects: response.data }); // jeden string do pole

        }).catch((error) => {
            console.log(error);
        });
    }


};