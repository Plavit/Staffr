import Reflux from "reflux";

const Actions = Reflux.createActions([
    'userInit',  'userLogout',
    'getAllProjects', 'getProject', 'deleteProject',
    'getAllUsers', 'getUser', 'deleteUser'
]);

export default Actions;