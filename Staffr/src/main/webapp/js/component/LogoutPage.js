import Reflux from "reflux";
import React from "react";
import Actions from "../actions/Actions";
import UserStore from "../store/UserStore";
import {hashHistory} from "react-router";
import {Link} from "react-router";
import {MuiThemeProvider, Paper, RaisedButton} from "material-ui";

// const RaisedButtonExampleSimple = () => (
//     <div>
//         <RaisedButton label="Back to index." primary={true} name="submit" value="login"
//                       fullWidth={false} style={{display: 'block', margin: '12px'}}
//                       onClick={logout()}/>
//     </div>
// );
//



export default class LogoutPage extends Reflux.Component {

    constructor(props) {
        super(props);
        this.state = {};
        Actions.userLogout();
    };

    logout() {
        hashHistory.push({pathname: "/login"});
    }

    render() {
        console.log("Logging out");
        return (
            <MuiThemeProvider>
                <div style={{textAlign: 'center', padding: '50px', position: 'relative'}}>
                    <Paper zDepth={3} style={{width: '80%', margin: 'auto', padding: '12px'}}>
                        <img src="../../resources/img/Staffr_logo_med.png" style={{height: '40%'}}/>
                        <h1>You have successfully logged out.</h1>
                                <RaisedButton label="Back to index." primary={true} name="submit" value="login"
                                               fullWidth={false} style={{display: 'block', margin: '12px'}}
                                               onClick={()=>this.logout()}/>
                    </Paper>


                </div>
            </MuiThemeProvider>
        );
    }
}
