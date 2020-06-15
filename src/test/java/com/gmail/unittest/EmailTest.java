package com.gmail.unittest;

import com.gmail.entity.Email;
import org.junit.Assert;
import org.junit.Test;

public class EmailTest {

    @Test
    public void userCompareTest() {
        Email email1 = new Email("test", "", "");
        Email email2 = new Email("test2", "", "");

        Assert.assertEquals(-1, email1.compareTo(email2));
    }

    @Test
    public void cloneTest() {
        Email email1 = new Email("test", "email", "");
        Email email2 = email1.clone();

        Assert.assertEquals(email1.getTo(), email2.getTo());
        Assert.assertEquals(email1.getSubject(), email2.getSubject());
        Assert.assertEquals(email1.getBody(), email2.getBody());
    }
}
