/**
 * Created by Aneta on 4. 2. 2017.
 */
import React from "react";
import Reflux from "reflux"
import {Button, FormControl, Col, ControlLabel, FormGroup, Checkbox, Table} from 'react-bootstrap';
import LocationStore from "../../Flux/Stores/LocationStore";
import PreferredAgeCategoryStore from "../../Flux/Stores/PreferredAgeCategoryStore";
import SchoolSubjectStore from "../../Flux/Stores/SchoolSubjectStore";
import SkillStore from "../../Flux/Stores/SkillStore";
import Actions from "../../Flux/Actions/Action";
import axios from "axios";
import { hashHistory } from "react-router";
export default class VolunteerRegister extends Reflux.Component {
    constructor() {
        super();
        this.state = {
            volunteer: {
                firstname: '',
                lastname: '',
                phoneNumber: '',
                email: '',
                birthYear: '',
                volunteerSkills: [],
                volunteerPreferredAgeCategories: [],
                locations: [],
                schoolSubjects: [],
                clients: []
            }
        };
        this.stores = [LocationStore, PreferredAgeCategoryStore, SchoolSubjectStore, SkillStore];
    }
    componentDidMount() {
        Actions.allLocationLoad();
        Actions.allSkillLoad();
        Actions.allSubjectLoad();
        Actions.allCategoryLoad();
    }
    onChange = (e) => {
        var change = this.state.volunteer;
        change[e.target.name] = e.target.value;
        this.setState({volunteer: change});
        console.log(this.state);
    };
    onCheckLocation(e) {
        const locations = this.state.volunteer.locations;
        let index;
        let tempVolunteer = this.state.volunteer;
        if (e.target.checked) {
            locations.push({
                id: e.target.dataset.id,
                locationName: e.target.dataset.locationname
            })
        } else {
            index = locations.indexOf({
                id: e.target.dataset.id,
                locationName: e.target.dataset.locationname
            });
            locations.splice(index, 1)
        }
        tempVolunteer.locations = locations;
        this.setState({volunteer: tempVolunteer});
        console.log(this.state);
        // this.setState({volunteer:{locations:[{location}]}})
    };

    onCheckSubject(e) {
        const subjects = this.state.volunteer.schoolSubjects;
        let index;
        let tempSubject = this.state.volunteer;
        if (e.target.checked) {
            subjects.push({
                id: e.target.dataset.id,
                schoolSubjectName: e.target.dataset.schoolSubjectName
            })
        } else {
            index = subjects.indexOf({
                id: e.target.dataset.id,
                schoolSubjectName: e.target.dataset.schoolSubjectName
            });
            subjects.splice(index, 1)
        }
        tempSubject.schoolSubjects = subjects;
        this.setState({volunteer: tempSubject});
        console.log(this.state);
    };

    onCheckAge(e) {
        const age = this.state.volunteer.volunteerPreferredAgeCategories;
        let index;
        let tempAge = this.state.volunteer;
        if (e.target.checked) {
            age.push({
                id: e.target.dataset.id,
                category: e.target.dataset.category
            })
        } else {
            index = age.indexOf({
                id: e.target.dataset.id,
                category: e.target.dataset.category
            });
            age.splice(index, 1)
        }
        tempAge.volunteerPreferredAgeCategories = age;
        this.setState({volunteer: tempAge});
        console.log(this.state);

    };
// bez id, jen location.name
    onCheckSkill(e) {
        const skill = this.state.volunteer.volunteerSkills;
        let index;
        let tempSkill = this.state.volunteer;
        if (e.target.checked) {
            skill.push({
                id: e.target.dataset.id,
                skillName: e.target.dataset.skillName
            })
        } else {
            index = skill.indexOf({
                id: e.target.dataset.id,
                skillName: e.target.dataset.skillName
            });
            skill.splice(index, 1)
        }
        tempSkill.volunteerSkills = skill;
        this.setState({volunteer: tempSkill});
        console.log(this.state);

    };


    sendRegistratioon(e) {
        e.preventDefault();
        console.log(this.state.volunteer);
        axios.post('rest/volunteer', this.state.volunteer).then(function (response) {
            console.log(response);
            hashHistory.push({
                pathname: 'success'
            });
            
        }).catch(function (response) {
            console.log(response);
        });
    }
    render() {
        var rows2 = [];
        var locations = this.state.locations;
        for (var i = 0; i < locations.length; i++) {
            rows2.push(<Checkbox inline key={locations[i].id} data-id={locations[i].id}
                                 data-locationname={locations[i].locationName}
                                 onChange={this.onCheckLocation.bind(this)}>{locations[i].locationName}</Checkbox>);
        }

        var rows3 = [];
        var subject=this.state.subjects;
        for(var i=0; i<subject.length; i++) {
            rows3.push(<Checkbox inline key={subject[i].id} data-id={subject[i].id}
                                 data-locationname={subject[i].schoolSubjectName}
                                 onChange={this.onCheckSubject.bind(this)}>{subject[i].schoolSubjectName}</Checkbox>);
        }

        var rows4=[];
        var age=this.state.categories;
        for(var i=0; i<age.length; i++) {
            rows4.push(<Checkbox inline key={age[i].id} data-id={age[i].id}
                                 data-locationname={age[i].category}
                                 onChange={this.onCheckAge.bind(this)}>{age[i].category}</Checkbox>);
        }

        var rows5=[];
        var skill=this.state.skills;
        for(var i=0; i<skill.length; i++) {
            rows5.push(<Checkbox inline key={skill[i].id} data-id={skill[i].id}
                                 data-locationname={skill[i].skillName}
                                 onChange={this.onCheckSkill.bind(this)}>{skill[i].skillName}</Checkbox>);
        }



        return (
            <div>
                <Col md={8} xsOffset={2}>
                    <form>
                        <ControlLabel>First name</ControlLabel>
                        <FormControl
                            type="text"
                            value={this.state.value}
                            placeholder="Enter firstname"
                            name="firstname"
                            onChange={this.onChange}
                        />
                        <ControlLabel>last name</ControlLabel>
                        <FormControl
                            type="text"
                            value={this.state.value}
                            placeholder="Enter lastname"
                            name="lastname"
                            onChange={this.onChange}
                        />
                        <ControlLabel>Phone Number</ControlLabel>
                        <FormControl
                            type="text"
                            value={this.state.value}
                            placeholder="Enter phone number"
                            name="phoneNumber"
                            onChange={this.onChange}
                        />
                        <ControlLabel>Email</ControlLabel>
                        <FormControl
                            type="text"
                            value={this.state.value}
                            placeholder="Enter email"
                            name="email"
                            onChange={this.onChange}
                        />
                        <FormGroup>
                            <Table>
                                <thead>
                                <tr>
                                    <th>Lokace</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>{rows2}</tr>
                                </tbody>
                            </Table>
                            <Table>
                                <thead>
                                <tr>
                                    <th>Předměty</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>{rows3}</tr>
                                </tbody>
                            </Table>
                            <Table>
                                <thead>
                                <tr>
                                    <th>Preferovaná věková kategorie</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>{rows4}</tr>
                                </tbody>
                            </Table>
                            <Table>
                                <thead>
                                <tr>
                                    <th>Skilly</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>{rows5}</tr>
                                </tbody>
                            </Table>
                        </FormGroup>
                        <Button onClick={this.sendRegistratioon.bind(this)} type="submit">Odeslat registraci</Button>
                    </form>
                </Col>
            </div>
        )
    }
}