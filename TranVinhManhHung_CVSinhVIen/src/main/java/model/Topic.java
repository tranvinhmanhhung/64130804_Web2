package model;

public class Topic {
    private int id;
    private String topicName;
    private String topicDescription;
    private int supervisorId;
    private String topicType;

    public Topic(int id, String topicName, String topicDescription, int supervisorId, String topicType) {
        this.id = id;
        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.supervisorId = supervisorId;
        this.topicType = topicType;
    }

    public int getId() {
        return id;
    }

    public String getTopicName() {
        return topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public String getTopicType() {
        return topicType;
    }
}
