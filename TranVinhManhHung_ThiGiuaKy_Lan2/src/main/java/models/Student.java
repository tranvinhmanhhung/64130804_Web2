package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String id;
    private String title;
    private String content;
    private String categoryId;

    public Student() {}

    public Student(String id, String title, String content, String categoryId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
    }
}
