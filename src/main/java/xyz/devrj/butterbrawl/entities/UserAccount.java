package xyz.devrj.butterbrawl.entities;

import xyz.devrj.butterbrawl.temp_objects.TempUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name = "user_account")
public class UserAccount implements UserDetails {

    @Id
    @Column(name = "username")
    private String userName;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "starting_weight")
    private Integer startingWeight;

    @Column(name = "current_weight")
    private Integer currentWeight;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "height_feet")
    private Integer heightFt;

    @Column(name = "height_inches")
    private Integer heightIn;

    @Column(name = "gender")
    private String gender;

    @Column(name = "notifications")
    private String notifications;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "phone_service")
    private String phoneService;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "authority")
    private String authority;


    //Constructors
    public UserAccount() {
    }
    public UserAccount(TempUser tempUser){
        this.groupName = tempUser.getGroupName();
        this.userName = tempUser.getUserName();
        this.password = tempUser.getPassword();
        this.firstName = tempUser.getFirstName();
        this.lastName = tempUser.getLastName();
        this.startingWeight = tempUser.getStartingWeight();
        this.currentWeight = tempUser.getCurrentWeight();
        this.birthday = tempUser.getBirthday();
        this.heightFt = tempUser.getHeightFt();
        this.heightIn = tempUser.getHeightIn();
        this.gender = tempUser.getGender();
        this.notifications = tempUser.getNotifications();
        this.email = tempUser.getEmail();
        this.phoneNumber = tempUser.getPhoneNumber();
        this.phoneService = tempUser.getPhoneService();
        this.enabled = tempUser.getEnabled();
        this.authority = tempUser.getAuthority();
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


    @Override
    public String toString() {
        return "UserAccount{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startingWeight=" + startingWeight +
                ", currentWeight=" + currentWeight +
                ", birthday='" + birthday + '\'' +
                ", heightFt=" + heightFt +
                ", heightIn=" + heightIn +
                ", gender='" + gender + '\'' +
                ", notifications='" + notifications + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneService='" + phoneService + '\'' +
                ", groupName='" + groupName + '\'' +
                ", enabled='" + enabled + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}