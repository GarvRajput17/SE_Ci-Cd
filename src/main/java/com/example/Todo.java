package com.example;

/**
 * A simple todo item with an id, description and completion flag.
 */
public class Todo {

    private final int id;
    private final String description;
    private boolean completed;

    public Todo(int id, String description) {
        this.id = id;
        this.description = description;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}


