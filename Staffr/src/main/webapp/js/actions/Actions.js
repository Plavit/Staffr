import Reflux from "reflux";

const Actions = Reflux.createActions([
    'userInit',  'userLogout',
    'getAllProjects', 'getProject', 'deleteProject','getAllUsersOnProjects',
    'getAllUsers', 'getUser', 'deleteUser', 'getUsersProjects'
]);

export default Actions;