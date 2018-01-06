import Reflux from "reflux";

const Actions = Reflux.createActions([
    'userInit',  'userLogout',
    'getAllProjects', 'getProject'
]);

export default Actions;