package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A very small in-memory service to manage todos.
 */
public class TodoService {

    private final List<Todo> todos = new ArrayList<Todo>();
    private int nextId = 1;

    /**
     * Add a new todo with the given description.
     *
     * @param description the text of the todo
     * @return the created Todo
     */
    public Todo addTodo(String description) {
        Todo todo = new Todo(nextId++, description);
        todos.add(todo);
        return todo;
    }

    /**
     * Mark the todo with the given id as completed.
     *
     * @param id todo id
     * @return true if a todo was found and updated, false otherwise
     */
    public boolean completeTodo(int id) {
        for (int i = 0; i < todos.size(); i++) {
            Todo todo = todos.get(i);
            if (todo.getId() == id) {
                todo.setCompleted(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Return an unmodifiable view of all todos.
     */
    public List<Todo> getAllTodos() {
        return Collections.unmodifiableList(todos);
    }
}


