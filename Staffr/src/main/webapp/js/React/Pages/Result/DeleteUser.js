/**
 * Created by Aneta on 5. 2. 2017.
 */
import React from "react";
import MenuComponent from "../components/MenuComponent";

export default class DeleteUser extends React.Component {
    render() {
        return (
            <div>
                <MenuComponent/>
                <h2>Uživatel byl úspěšně vymazán.</h2>
            </div>

        )
    }
}