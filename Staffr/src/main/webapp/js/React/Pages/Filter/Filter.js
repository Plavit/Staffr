import React from "react";
import Reflux from "reflux";
import querystring from "querystring";
import {Button, FormControl, Col, ControlLabel, FormGroup, Checkbox, Table} from 'react-bootstrap';
import LocationStore from "../../Flux/Stores/LocationStore";
import PreferredAgeCategoryStore from "../../Flux/Stores/PreferredAgeCategoryStore";
import SchoolSubjectStore from "../../Flux/Stores/SchoolSubjectStore";
import SkillStore from "../../Flux/Stores/SkillStore";
import Result from "../../Pages/Result/Result";

import FiltrStore from "../../Flux/Stores/FilterStore";
import Actions from "../../Flux/Actions/Action";
import MenuComponent from "../components/MenuComponent";
import axios from "axios";
import {router, hashHistory} from "react-router";
export default class Filter extends Reflux.Component {
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
                // status as a filter condition can be send to the backend as many statuses
                status:[]
            }
        };
        this.stores = [LocationStore, PreferredAgeCategoryStore, SchoolSubjectStore, SkillStore, FiltrStore];
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
                locationName: e.target.dataset.locationname
            })
        } else {
            index = locations.indexOf({
                locationName: e.target.dataset.locationname
            });
            locations.splice(index, 1)
        }
        tempVolunteer.locations = locations;
        this.setState({volunteer: tempVolunteer});
        console.log(this.state);

    };

    onCheckSubject(e) {
        const subjects = this.state.volunteer.schoolSubjects;
        let index;
        let tempSubject = this.state.volunteer;
        if (e.target.checked) {
            subjects.push({
                schoolSubjectName: e.target.dataset.schoolsubjectname
            })
        } else {
            index = subjects.indexOf({
                schoolSubjectName: e.target.dataset.schoolsubjectname
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
                category: e.target.dataset.category
            })
        } else {
            index = age.indexOf({
                category: e.target.dataset.category
            });
            age.splice(index, 1)
        }
        tempAge.volunteerPreferredAgeCategories = age;
        this.setState({volunteer: tempAge});
        console.log(this.state);
    };

    onCheckSkill(e) {
        const skill = this.state.volunteer.volunteerSkills;
        let index;
        let tempSkill = this.state.volunteer;
        if (e.target.checked) {
            skill.push({
                skillName: e.target.dataset.skillname
            })
        } else {
            index = skill.indexOf({
                skillName: e.target.dataset.skillname
            });
            skill.splice(index, 1)
        }
        tempSkill.volunteerSkills = skill;
        this.setState({volunteer: tempSkill});
        console.log(this.state);
    };
    onCheckStatus(e) {
        const status = this.state.volunteer.status;
        let index;
        let tempStatus = this.state.volunteer;
        if (e.target.checked) {
            status.push({
                status: e.target.dataset.status
            })
        } else {
            index = status.indexOf({
                status: e.target.dataset.status
            });
            status.splice(index, 1)
        }
        tempStatus.status = status;
        this.setState({volunteer: tempStatus});
        console.log(this.state);
    };

    getAll(e){
        e.preventDefault();
        Actions.loadAllVolunteers();
    }

    sendFilter(e) {
        e.preventDefault();
        console.log(this.state.volunteer);
        console.log(this.state.volunteer.locations.locationName);
        let paramLoc = [];

        if (this.state.volunteer.locations.length > 0) {
            for (let i = 0; i < this.state.volunteer.locations.length; i++) {
                paramLoc.push(this.state.volunteer.locations[i].locationName)
            }
        }
        // else {
        //     for (let i = 0; i < this.state.locations.length; i++) {
        //         paramLoc.push(this.state.locations[i].locationName)
        //     }
        // }

        let paramAge = [];

        if (this.state.volunteer.volunteerPreferredAgeCategories.length > 0) {
            for (let i = 0; i < this.state.volunteer.volunteerPreferredAgeCategories.length; i++) {
                paramAge.push(this.state.volunteer.volunteerPreferredAgeCategories[i].category)
            }
        }
        // else {
        //     for (let i = 0; i < this.state.categories.length; i++) {
        //         paramAge.push(this.state.categories[i].category)
        //     }
        // }

        let paramSki = [];

        if (this.state.volunteer.volunteerSkills.length > 0) {
            for (let i = 0; i < this.state.volunteer.volunteerSkills.length; i++) {
                paramSki.push(this.state.volunteer.volunteerSkills[i].skillName)
            }
        }
        // else {
        //     for (let i = 0; i < this.state.skills.length; i++) {
        //         paramSki.push(this.state.skills[i].skillName)
        //     }
        // }

        let paramSub = [];

        if (this.state.volunteer.schoolSubjects.length > 0) {

            for (let i = 0; i < this.state.volunteer.schoolSubjects.length; i++) {
                paramSub.push(this.state.volunteer.schoolSubjects[i].schoolSubjectName)
            }


//             axios.post('rest/volunteer/filter',
//
//                 this.state.volunteer
//             ).then(function (response) {
//                 console.log(response);
//
// // TODO neco method - WTF
//                 //this.setState({ volunteerFound: response.data });
//                 Actions.neco(response);
//
//                 //console.log(this.state.volunteerFound);
//
//
//             }).catch(function (response) {
//
//                 console.log(response);
//             });

        }
        let paramStatus = [];

        if (this.state.volunteer.status.length > 0) {
            for (let i = 0; i < this.state.volunteer.status.length; i++) {
                paramStatus.push(this.state.volunteer.status[i].status)
                // console.log("param: " + this.state.volunteer.status[i]);
            }
        }
        console.log("param: " + paramStatus);
        axios.post('rest/volunteer/filter',
                querystring.stringify({
                    firstname: this.state.volunteer.firstname,
                    lastname: this.state.volunteer.lastname,
                    phoneNumber: this.state.volunteer.phoneNumber,
                    email: this.state.volunteer.email,
                    locations: paramLoc,
                    subject: paramSub,
                    skills: paramSki,
                    category: paramAge,
                    volunteerStatus: paramStatus,

                })
        )
            .then(function (response) {
            console.log(response);

// TODO neco method - WTF
            //this.setState({ volunteerFound: response.data });
            Actions.filteredVolunteers(response);

            //console.log(this.state.volunteerFound);


        }).catch(function (response) {

            console.log(response);
        });

        // else {
        //
        //     console.log("param: " + paramLoc);
        //     axios.post('rest/volunteer/filter', querystring.stringify({
        //
        //         locations: paramLoc,
        //         skills: paramSki,
        //         category: paramAge
        //
        //     })).then(function (response) {
        //         console.log(response);
        //
        //
        //         Actions.neco(response);
        //
        //
        //     }).catch(function (response) {
        //         console.log(response);
        //
        //     });
        //
        // }
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
        var subject = this.state.subjects;
        for (var i = 0; i < subject.length; i++) {
            rows3.push(<Checkbox inline key={subject[i].id} data-id={subject[i].id}
                                 data-schoolsubjectname={subject[i].schoolSubjectName}
                                 onChange={this.onCheckSubject.bind(this)}>{subject[i].schoolSubjectName}</Checkbox>);
        }
        var rows4 = [];
        var age = this.state.categories;
        for (var i = 0; i < age.length; i++) {
            rows4.push(<Checkbox inline key={age[i].id} data-id={age[i].id}
                                 data-category={age[i].category}
                                 onChange={this.onCheckAge.bind(this)}>{age[i].category}</Checkbox>);
        }
        var rows5 = [];
        var skill = this.state.skills;
        for (var i = 0; i < skill.length; i++) {
            rows5.push(<Checkbox inline key={skill[i].id} data-id={skill[i].id}
                                 data-skillname={skill[i].skillName}
                                 onChange={this.onCheckSkill.bind(this)}>{skill[i].skillName}</Checkbox>);
        }
        let rows6 = [];
        rows6.push(<Checkbox inline
                             data-status='ACTIVE_STATUS'
                             onChange={this.onCheckStatus.bind(this)}>Aktivni</Checkbox>);
        rows6.push(<Checkbox inline
                             data-status='AVAIABLE_STATUS'
                             onChange={this.onCheckStatus.bind(this)}>K dispozici</Checkbox>);
        rows6.push(<Checkbox inline
                             data-status='INACTIVE_STATUS'
                             onChange={this.onCheckStatus.bind(this)}>Neaktivni</Checkbox>);
        return (
            <div>
                <MenuComponent/>
                <Col md={8} xsOffset={2}>
                    <h2> Vyhledávání dobrovolníků dle parametrů: </h2>


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
                            <Table>
                                <thead>
                                <tr>
                                    <th>Stav</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>{rows6}</tr>
                                </tbody>
                            </Table>
                        </FormGroup>
                        <Button onClick={this.sendFilter.bind(this)} type="submit">Vyhledat dobrovolníky</Button>
                        <Button onClick={this.getAll.bind(this)} type="submit">Vyhledat všechny dobrovolníky</Button>
                    </form>
                </Col>
            </div>
        )
    }
}