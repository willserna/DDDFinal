package org.example.domain.registry.events;

import org.example.generic.DomainEvent;

public class UserInfoEdited extends DomainEvent {

    private String userName;
    private String userEmail;
    private String phoneNumber;
    private Boolean status;


    public UserInfoEdited(){super("serna.william.UserInfoEdited");}
    public UserInfoEdited(String userName,
                          String userEmail,
                          String phoneNumber,
                          Boolean status){
        super("serna.william.UserInfoEdited");
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.status = status;
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
