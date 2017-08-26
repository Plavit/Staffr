/**
 * Created by Aneta on 7. 2. 2017.
 */
import React from "react";
import Reflux from "reflux";
import { Breadcrumb, BreadcrumbItem, Button, Grid, PageHeader, Panel, Table } from "react-bootstrap";
import FiltrStore from "../../Flux/Stores/FilterStore";
import MenuComponent from "../components/MenuComponent";
import {router, hashHistory} from "react-router";



export default class ResultDetails extends Reflux.Component {

    constructor() {
        super();
        this.state = {
            volunteerFound: {}
        };
        this.store = FiltrStore;
    }

    returnToResult(e){
        e.preventDefault();
        hashHistory.push({
            pathname: 'result'
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
                        <th>Lokace</th>
                        <th>Předměty</th>
                        <th>Preferovaný věk</th>
                        <th>Skilly</th>
                        <th>Stav</th>
                    </tr>
                    </thead>
                    <tbody>
                    {paramLoc}
                    <Button onClick={this.returnToResult.bind(this)} type="submit">Zobrazit bez detailů</Button>
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

    render() {
        var volunteer=this.props.volunteer;
        var locations=[];
        for (var i=0; i<volunteer.locations.length; i++) {
            locations.push(<tr key={volunteer.locations[i].id}><td>{volunteer.locations[i].locationName}</td></tr>)
        }
        var subject=[];
        for (var i=0; i<volunteer.schoolSubjects.length; i++) {
            subject.push(<tr key={volunteer.schoolSubjects[i].id}><td>{volunteer.schoolSubjects[i].schoolSubjectName}</td></tr>)
        }
        var ages=[];
        for (var i=0; i<volunteer.volunteerPreferredAgeCategories.length; i++) {
            ages.push(<tr key={volunteer.volunteerPreferredAgeCategories[i].id}><td>{volunteer.volunteerPreferredAgeCategories[i].category}</td></tr>)
        }
        var skills=[];
        for (var i=0; i<volunteer.volunteerSkills.length; i++) {
            skills.push(<tr key={volunteer.volunteerSkills[i].id}><td>{volunteer.volunteerSkills[i].skillName}</td></tr>)
        }

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
                    <table>
                        <tbody>
                        {locations}
                        </tbody>
                    </table>
                </td>
                <td>
                    <table>
                        <tbody>
                        {subject}
                        </tbody>
                    </table>
                </td>
                <td>
                    <table>
                        <tbody>
                        {ages}
                        </tbody>
                    </table>
                </td>
                <td>
                    <table>
                        <tbody>
                        {skills}
                        </tbody>
                    </table>
                </td>
                <td>
                    {volunteer.volunteerStatus}
                </td>
            </tr>
        )
    }

}

