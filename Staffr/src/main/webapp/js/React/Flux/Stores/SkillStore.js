/**
 * Created by Aneta on 19. 1. 2017.
 */
import Reflux from 'reflux';
import Actions from '../Actions/Action';
import axios from "axios";
import { hashHistory } from "react-router";
export default class SkillStore extends Reflux.Store{
    constructor(){
        super();
        this.state = {
            skills: []
        };
        this.listenables = Actions;
    };
    onAllSkillLoad(){
        console.log('Hledani vsech skillu...');
        axios.get("rest/skill").then((response) => { // neni implementovano
            this.setState({ skills: response.data });

        }).catch((error) => {
            console.log(error);
        });
    }

    onOneSkillLoad(){
        console.log('Hledani jednoho skillu...');
        axios.get("rest/skill/{name}").then((response) => { // zavorka nebo ne
            this.setState({ skills: response.data }); // jeden string do pole

        }).catch((error) => {
            console.log(error);
        });
    }


};