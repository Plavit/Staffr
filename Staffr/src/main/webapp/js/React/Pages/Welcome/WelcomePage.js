import React from "react";
import { Link } from "react-router";
import MenuComponent from "../components/MenuComponent";
import IndexBody from "./IndexBody";
export default class WelcomePage extends React.Component {
    render() {
        return (
            <div>
                <MenuComponent/>

                <IndexBody/>
            </div>

        )
    }
}