class Todo {
    constructor() {
        this.todos = ['first'];
    }

    add(value) {
        this.todos.push(value);
    }

    get list() {
        return this.todos;
    }
}

class TodoSpecial extends Todo {
    constructor() {
        super();
    }

    addSpecial(value = 'default') {
        this.todos.push(value);
    }
}

const todo = new TodoSpecial();
todo.add('manual');
todo.addSpecial();
//console.log(todo.list);