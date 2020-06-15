package com.gmail.unittest;

import com.gmail.entity.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void userCompareTest() {
        User user1 = new User("test", "");
        User user2 = new User("test2", "");

        Assert.assertEquals(-1, user1.compareTo(user2));
    }

    @Test
    public void cloneTest() {
        User user1 = new User("test", "email");
        User user2 = user1.clone();

        Assert.assertEquals(user1.getEmail(), user2.getEmail());
        Assert.assertEquals(user1.getPass(), user2.getPass());
    }
}
