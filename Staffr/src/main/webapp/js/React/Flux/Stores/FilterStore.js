/**
 * Created by Aneta on 3. 2. 2017.
 */
import Reflux from 'reflux';
import Actions from '../Actions/Action';
import axios from "axios";
import { hashHistory } from "react-router";
export default class FilterStore extends Reflux.Store{
    constructor(){
        super();
        this.state = {
            volunteerFound: {
                id: 0,
                firstname: '',
                lastname: '',
                phoneNumber: '',
                email: '',
                birthYear: '',
                volunteerSkills: [],
                volunteerPreferredAgeCategories: [],
                locations: [],
                schoolSubjects: [],
                volunteerStatus: '',
            }
        };
        this.listenables = Actions;
    };
    onFilteredVolunteers(a){

        console.log("volunteer found");
        this.setState({volunteerFound: a.data});
        hashHistory.push({
            pathname: 'result'
        });
        console.log(this.state);
    }

    onLoadAllVolunteers(){
        console.log('load all vol Function was fired');
        axios.get("rest/volunteer/getall").then((response) => {

            this.setState({
                volunteerFound: response.data,
            }) ;

            hashHistory.push({
                pathname: 'result'
            });
        }).catch((error) => {
            console.log(error);
        });
    }


}

