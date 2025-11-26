package com.example;

/**
 * Entry point demonstrating the simple todo application.
 */
public class App {

    public static void main(String[] args) {
        TodoService service = new TodoService();

        // Add a couple of todos
        service.addTodo("Learn CI/CD");
        service.addTodo("Write simple todo app");

        // Complete the first todo
        service.completeTodo(1);

        // Print all todos to the console
        System.out.println("Current todos:");
        for (Todo todo : service.getAllTodos()) {
            System.out.println(todo);
        }
    }
}
