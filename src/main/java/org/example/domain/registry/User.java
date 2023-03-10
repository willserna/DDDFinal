package org.example.domain.registry;

import org.example.domain.registry.values.UserId;
import org.example.domain.registry.values.UserInfo;
import org.example.generic.Entity;

public class User extends Entity<UserId> {

    private UserInfo userInfo;

    public User (UserId entityId, UserInfo userInfo) {
        super(entityId);
        this.userInfo = userInfo;
    }

    public void updateUserInfo(UserInfo newUserInfo) {

        userInfo = newUserInfo;
    }
}
