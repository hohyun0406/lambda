package com.rod.api.product;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
        Item s = new Item();
        String s3 = s.systemOut();

        System.out.println("-->"+s3);
            String s2 = "Hello";
        Assertions.assertEquals(s.systemOut(), "Hello");
    }

    @org.junit.jupiter.api.Test
    void add() {
        Item s = new Item();
        int s2 = s.add(1,2);

        System.out.println("--->"+s2);
        Assertions.assertEquals(s.add(1,2),3);
    }

}