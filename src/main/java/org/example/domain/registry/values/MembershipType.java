package org.example.domain.registry.values;

import org.example.generic.ValueObject;

public class MembershipType implements ValueObject<String> {

    private final String value;

    public MembershipType(String value) {
        this.value = value;
        /*if (this.value != "no membership" || this.value != "silver" || this.value != "gold" || this.value != "platinum") {
            throw new IllegalArgumentException("Invalid membership type");
        }*/
    }

    @Override
    public String value() {
        return value;
    }
}
