package thigk.ntu64130804.tranvinhmanhhung_thigiuaky_lan2.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic {

    private String id;
    private String topicName;
    private String topicDescription;
    private String supervisorId;
    private String topicType;

    public Topic() {}

    public Topic(String id, String topicName, String topicDescription, String supervisorId, String topicType) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.supervisorId = supervisorId;
        this.topicType = topicType;
    }
}
