import Reflux from "reflux";
import React from "react";
import Actions from "../actions/Actions";
import UserStore from "../store/UserStore";
import FontIcon from 'material-ui/FontIcon';
import {hashHistory} from "react-router";


import {
    AppBar, Drawer, FlatButton, IconButton, MenuItem, MuiThemeProvider
} from "material-ui";
import {NavigationMenu} from "material-ui/svg-icons/index";
import {white} from "material-ui/styles/colors";

const footerStyle = {
    backgroundColor: "black",
    fontSize: "10px",
    color: "#333333",
    borderTop: "1px solid #CCCCCC",
    textAlign: "center",
    padding: "5px",
    position: "fixed",
    left: "0",
    bottom: "0",
    height: "20px",
    width: "100%"
};

const phantomStyle = {
    display: "block",
    padding: "20px",
    height: "60px",
    width: "100%"
};

function Footer({ children }) {
    return (
        <div>
            <div style={phantomStyle} />
            <div style={footerStyle}>{children}</div>
        </div>
    );
}

export default class requireAuth extends Reflux.Component {

    constructor(props) {
        super(props);
        this.state = {open: false};
        this.sidebar={};
        this.store = UserStore;
    };

    logout() {
        hashHistory.push({pathname: "/logout"});
    }

    gotoUsers() {
        hashHistory.push({pathname: "/users"});
        this.handleClose();
    }

    gotoProjects() {
        hashHistory.push({pathname: "/projects"});
        this.handleClose();
    }

    gotoSearch() {
        hashHistory.push({pathname: "/userSearch"});
        this.handleClose();
    }

    gotoHome() {
        hashHistory.push({pathname: "/"});
        this.handleClose();
    }

    handleToggle = () => this.setState({open: !this.state.open});

    handleClose = () => this.setState({open: false});

    handleOpen = () => this.setState({open: true});

    render() {
        return (
            <MuiThemeProvider>
                <div>
                    <Drawer
                        docked={false}
                        width={200}
                        open={this.state.open}
                        onRequestChange={(open) => this.handleToggle()}
                    >
                        <MenuItem onClick={()=>this.gotoHome()}>Home</MenuItem>
                        <MenuItem onClick={()=>this.gotoProjects()}>Project overview</MenuItem>
                        <MenuItem onClick={()=>this.gotoUsers()}>User overview</MenuItem>
                        <MenuItem onClick={()=>this.gotoSearch()}>Search users</MenuItem>
                        <MenuItem onClick={this.handleClose}>Close</MenuItem>
                    </Drawer>
                    <AppBar
                         title={<span onClick={()=>this.handleToggle()}>Staffr 1.0</span>}
                         // onTitleClick={this.handleOpen}
                         // onLeftIconButtonClick={this.handleOpen}
                         // showMenuIconButton={false}
                         iconElementLeft={<IconButton onClick={()=>this.handleToggle()} color={white}> <NavigationMenu onClick={()=>this.handleToggle()} color={white}/></IconButton>}
                         iconElementRight={<FlatButton label="Logout" onClick={()=>this.logout()}/>}
                    />

                    {this.props.children}
                    <Footer>
                        <span>Copyright (c) 2017-2018 Kryštof Sýkora, Marek Szeles</span>
                    </Footer>
                </div>
            </MuiThemeProvider>
        )
    }

    componentDidMount() {
        Actions.userInit();
    }
}
