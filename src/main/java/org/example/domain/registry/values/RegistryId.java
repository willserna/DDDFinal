package org.example.domain.registry.values;

import org.example.generic.Identity;

public class RegistryId extends Identity {

    private RegistryId(String uuid){
        super(uuid);
    }

    public RegistryId(){}

    public static RegistryId of (String uuid){
        return new RegistryId(uuid);
    }
}
