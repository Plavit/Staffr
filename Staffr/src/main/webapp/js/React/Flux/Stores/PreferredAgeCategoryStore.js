/**
 * Created by Aneta on 19. 1. 2017.
 */
import Reflux from 'reflux';
import Actions from '../Actions/Action';
import axios from "axios";
import { hashHistory } from "react-router";
export default class PreferredAgeCategoryStore extends Reflux.Store{
    constructor(){
        super();
        this.state = {
            categories: []
        };
        this.listenables = Actions;
    };
    onAllCategoryLoad(){
        console.log('Hledani vsech kategorii...');
        axios.get("rest/category").then((response) => {
            this.setState({ categories: response.data });

        }).catch((error) => {
            console.log(error);
        });
    }

    onOneCategoryLoad(){
        console.log('Hledani jedne kategorie...');
        axios.get("rest/category/{name}").then((response) => { // zavorka nebo ne
            this.setState({ categories: response.data }); // jeden string do pole

        }).catch((error) => {
            console.log(error);
        });
    }


};