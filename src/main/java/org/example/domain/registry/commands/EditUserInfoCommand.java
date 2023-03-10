package org.example.domain.registry.commands;

import org.example.generic.Command;

public class EditUserInfoCommand extends Command {

    private String registryId;
    private String userName;
    private String userEmail;
    private String phoneNumber;
    private Boolean status;

    public EditUserInfoCommand(){}
    public EditUserInfoCommand(String registryId,
                               String userName,
                               String userEmail,
                               String phoneNumber,
                               Boolean status){

        this.registryId = registryId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String getRegistryId() {
        return registryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
