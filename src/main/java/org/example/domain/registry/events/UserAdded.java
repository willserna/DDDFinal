package org.example.domain.registry.events;

import org.example.generic.DomainEvent;

public class UserAdded extends DomainEvent {

    private String userId;
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private Boolean status;

    public UserAdded(){super("serna.william.usercreated");}

    public UserAdded(String userId,
                     String userName,
                     String userEmail,
                     String phoneNumber){
        super("serna.william.usercreated");
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.status = true;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getStatus() {
        return status;
    }
}
