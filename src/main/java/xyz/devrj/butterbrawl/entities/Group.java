package xyz.devrj.butterbrawl.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "group_tracker")
public class Group {

    //Variables
    @Id
    @Column(name = "group_name")
    @Pattern(regexp = "[a-zA-Z0-9.]{2,30}", message = "Sorry, only letters (a-z), numbers (0-9), periods (.) are allowed and must be between 2-30 characters long")
    private String groupName;

    //Constructors
    public Group() {
    }

    //Getters and Setters
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group: " + getGroupName();
    }
}



