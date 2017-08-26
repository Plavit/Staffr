/**
 * Created by HMT on 14.01.2017.
 */
import Reflux from 'reflux';
var Actions = Reflux.createActions([
    'userInit', 'userLogOut', 'allLocationLoad', 'oneLocationLoad',
    'allSkillLoad', 'oneSkillLoad', 'allSubjectLoad', 'oneSubjectLoad',
    'allCategoryLoad', 'oneCategoryLoad', 'oneVolunteerLoad', 'makeFilter',
    'loadAllVolunteers', 'logout', 'filteredVolunteers', 'userFound', 'changePasswd',
    'userDelete',
]);
export default Actions;