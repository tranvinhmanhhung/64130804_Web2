package model;

public class Student {
    private int id;
    private String name;
    private int topicId;

    // Constructor
    public Student(int id, String name, int topicId) {
        this.id = id;
        this.name = name;
        this.topicId = topicId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
}