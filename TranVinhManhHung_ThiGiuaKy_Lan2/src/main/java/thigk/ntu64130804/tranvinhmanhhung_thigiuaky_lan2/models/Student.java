package thigk.ntu64130804.tranvinhmanhhung_thigiuaky_lan2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String id;
    private String name;
    private String groupId;

    public Student() {}

    public Student(String id, String name, String groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }
}
