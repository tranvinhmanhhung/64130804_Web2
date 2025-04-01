package model;

public class Topic {
    private int id;
    private String name;
    private String description;
    private int courseId;
    private String type;

    // Constructor
    public Topic(int id, String name, String description, int courseId, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courseId = courseId;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}