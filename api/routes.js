'use strict';

module.exports = function(app) {
    var todoList = require('./controller');

    app.route('/')
        .get(todoList.index)
        
    app.route('/users')
        .get(todoList.users)
        .post(todoList.createUsers)
        .put(todoList.updateUsers)
        .delete(todoList.deleteUsers)

    app.route('/users/:user_id')
        .get(todoList.findUsers)


};