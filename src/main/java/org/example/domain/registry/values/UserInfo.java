package org.example.domain.registry.values;

import org.example.generic.ValueObject;

public class UserInfo implements ValueObject<UserInfo.Props> {

    private final String userName;
    private final String userEmail;
    private final String phoneNumber;
    private final Boolean status;

    public UserInfo(String userName,
                    String userEmail,
                    String phoneNumber,
                    Boolean status) {

        this.userName = userName;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String userName() {
                return userName;
            }

            @Override
            public String userEmail() {
                return userEmail;
            }

            @Override
            public String phoneNumber() {
                return phoneNumber;
            }

            @Override
            public Boolean status() {
                return status;
            }
        };
    }


    interface Props{
        String userName();
        String userEmail();
        String phoneNumber();
        Boolean status();
    }
}
