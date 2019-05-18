package xyz.devrj.butterbrawl.temp_objects;

import xyz.devrj.butterbrawl.entities.UserAccount;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TempUser {

    @NotNull(message = "Please enter your groups name")
    @Pattern(regexp = "[a-zA-Z0-9_]{2,30}", message = "Sorry, only letters (a-z), numbers (0-9), and underscores (_) are allowed and must be between 2-30 characters long")
    private String groupName;

    @NotNull(message = "Please enter a username")
    @Pattern(regexp = "[a-zA-Z0-9_]{2,30}", message = "Sorry, only letters (a-z), numbers (0-9), and underscores (_) are allowed and must be between 2-30 characters long")
    private String userName;

    @NotNull(message = "Please enter a password")
    @Pattern(regexp = "^[a-zA-Z0-9!@#$%&*|.<>]{8,30}$", message = "Sorry, password must be between 8 - 30 characters long.")
    private String password;

    @NotNull(message = "Please enter your first name ")
    @Pattern(regexp = "[a-zA-Z ']{2,30}", message = "Please enter a valid first name")
    private String firstName;

    @NotNull(message = "Please enter your last name")
    @Pattern(regexp = "^[a-zA-Z']{2,30}$", message = "Please enter a valid last name")
    private String lastName;

    @NotNull(message = "Please enter your weight ")
    private Integer startingWeight;

    private Integer currentWeight;  //Current weight will be assigned via starting weight on user creation

    @NotNull(message = "Please enter you birthday")
    private String birthday;

    @NotNull(message = "Please enter your height ")
    private Integer heightFt;

    @NotNull(message = "Please enter your height")
    private Integer heightIn;

    @NotNull(message = "Please enter your gender")
    private String gender;

    private String notifications;

    @NotNull(message = "Please enter your email address ")
    @Pattern(regexp = "^[a-zA-Z\\.\\d-_+]+@[a-zA-Z\\d\\.-_]+$", message = "Please enter a valid email address")
    private String email;

    private String phoneNumber;

    private String phoneService;

    private boolean enabled;

    private String authority;


    //Constructors
    public TempUser() {
    }
    public TempUser(UserAccount usrAct){
        this.groupName = usrAct.getGroupName();
        this.userName = usrAct.getUserName();
        this.password = usrAct.getPassword();
        this.firstName = usrAct.getFirstName();
        this.lastName = usrAct.getLastName();
        this.startingWeight = usrAct.getStartingWeight();
        this.currentWeight = usrAct.getCurrentWeight();
        this.birthday = usrAct.getBirthday();
        this.heightFt = usrAct.getHeightFt();
        this.heightIn = usrAct.getHeightIn();
        this.gender = usrAct.getGender();
        this.notifications = usrAct.getNotifications();
        this.email = usrAct.getEmail();
        this.phoneNumber = usrAct.getPhoneNumber();
        this.phoneService = usrAct.getPhoneService();
        this.enabled = usrAct.getEnabled();
        this.authority = usrAct.getAuthority();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(Integer startingWeight) {
        this.startingWeight = startingWeight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getHeightFt() {
        return heightFt;
    }

    public void setHeightFt(Integer heightFt) {
        this.heightFt = heightFt;
    }

    public Integer getHeightIn() {
        return heightIn;
    }

    public void setHeightIn(Integer heightIn) {
        this.heightIn = heightIn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneService() {
        return phoneService;
    }

    public void setPhoneService(String phoneService) {
        this.phoneService = phoneService;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPassword() {
        return password;
    }

    //Override


    @Override
    public String toString() {
        return super.toString();
    }
}


