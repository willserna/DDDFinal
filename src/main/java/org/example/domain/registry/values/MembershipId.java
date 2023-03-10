package org.example.domain.registry.values;

import org.example.generic.Identity;
import org.springframework.expression.spel.ast.Identifier;

public class MembershipId extends Identity {

    private MembershipId(String uuid){
        super(uuid);
    }

    public MembershipId(){}

    public static MembershipId of (String uuid){
        return new MembershipId(uuid);
    }


}
