package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Basic tests for the todo application.
 */
public class AppTest {

    @Test
    public void addingTodoShouldIncreaseListSize() {
        TodoService service = new TodoService();

        assertEquals(0, service.getAllTodos().size());

        Todo todo = service.addTodo("First task");

        assertEquals(1, service.getAllTodos().size());
        assertEquals("First task", todo.getDescription());
        assertFalse(todo.isCompleted());
    }

    @Test
    public void completingTodoShouldMarkItAsCompleted() {
        TodoService service = new TodoService();
        Todo todo = service.addTodo("Complete this");

        boolean updated = service.completeTodo(todo.getId());

        assertTrue(updated);
        assertTrue(service.getAllTodos().get(0).isCompleted());
    }
}
