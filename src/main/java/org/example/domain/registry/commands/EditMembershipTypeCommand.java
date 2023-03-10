package org.example.domain.registry.commands;

import org.example.generic.Command;

public class EditMembershipTypeCommand extends Command {

    private String registryId;
    private String membershipType;

    public EditMembershipTypeCommand(){}

    public EditMembershipTypeCommand(String registryId,
                                     String membershipType){
        this.registryId = registryId;
        this.membershipType = membershipType;
    }

    public String getRegistryId() {
        return registryId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
