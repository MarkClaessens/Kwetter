package domain;

import javax.persistence.*;

/**
 * Created by Slashy on 12-3-2017.
 */
@Entity
@Table(name = "group")
@NamedQuery(name = "group.all", query = "SELECT g FROM Group g")
public class Group {

    @Id
    private String groupName;

    /**
     * Constructor for group, groupName is automatically "User"
     */
    public Group() {
        this.groupName = "User";
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
