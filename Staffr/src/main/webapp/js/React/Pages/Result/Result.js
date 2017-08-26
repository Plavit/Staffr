import React from "react";
import Reflux from "reflux";
import { Breadcrumb, BreadcrumbItem, Button, Grid, PageHeader, Panel, Table } from "react-bootstrap";
import FilterStore from "../../Flux/Stores/FilterStore";
import MenuComponent from "../components/MenuComponent";
import {router, hashHistory} from "react-router";



export default class Result extends Reflux.Component {

    constructor() {
        super();
        this.state = {
            volunteerFound: {}
        };
        this.store = FilterStore;
    }

    showDetails(e){
        e.preventDefault();
        hashHistory.push({
            pathname: 'resultDetails'
        });
    }

    render() {

        let paramLoc =[];
        var volunteer=this.state.volunteerFound;

        for(let i = 0; i < volunteer.length; i++){
            paramLoc.push(<Row key={volunteer[i].id}volunteer={volunteer[i]}></Row>)
            }

        return (
            <div>
                <MenuComponent/>
                <Table>
                    <thead>
                    <tr>
                        <th>Jméno</th>
                        <th>Příjmení</th>
                        <th>Telefonní číslo</th>
                        <th>Email</th>
                        <th>Rok narození</th>
                        <th>Stav</th>
                        <th>edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    {paramLoc}
                    <Button onClick={this.showDetails.bind(this)} type="submit">Zobrazit s detaily</Button>
                    </tbody>
                </Table>

            </div>
        );
    }

}

class Row extends React.Component{

    static propTypes={
        volunteer: React.PropTypes.object.isRequired
    };

    constructor(props) {
        super(props);
    }

    // viewProfile(id, e){
    setProfile(e){
        // e.preventDefault();
        // console.log(id);
        console.log(e.target.dataset.id);
        console.log("asjfhaskfhkjzsfhjkdsk");
        console.log(this.state);
    };


    render() {
        var volunteer=this.props.volunteer;
        console.log(volunteer.firstname);
        return (
            <tr>
                <td>
                    {volunteer.firstname}
                </td>
                <td>
                    {volunteer.lastname}
                </td>
                <td>
                    {volunteer.phoneNumber}
                </td>
                <td>
                    {volunteer.email}
                </td>
                <td>
                    {volunteer.birthYear}
                </td>
                <td>
                    {volunteer.volunteerStatus}
                </td>
                <td>
                    <Button onClick={this.setProfile} data-id={volunteer.id} type="submit">Zobrazit profil</Button>
                </td>
            </tr>
        )
    }

}

