'use strict';

exports.__esModule = true;
exports.default = moveDate;

var _constants = require('./constants');

function moveDate(action, date, View) {
  switch (action) {
    case _constants.navigate.TODAY:
      date = new Date();
      break;
    case _constants.navigate.DATE:
      break;
    default:
      date = View.navigate(date, action);
  }

  return date;
}
module.exports = exports['default'];