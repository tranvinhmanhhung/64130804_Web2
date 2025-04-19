package models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic {

    private String id;
    private String pageName;
    private String keyword;
    private String content;
    private String parentPageId;

    public Topic() {}

    public Topic(String id, String pageName, String keyword, String content, String parentPageId) {
        this.id = id;
        this.pageName = pageName;
        this.keyword = keyword;
        this.content = content;
        this.parentPageId = parentPageId;
    }
}
