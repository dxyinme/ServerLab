package com.spboot.demo.Const;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class baiduAPITest {

    /**
        test the Baidu API getMapByAddress.
     */

    static baiduAPI bA = new baiduAPI();

    @Test
    void getMapByAddress() {
        System.out.println("getMapByAddress");
        try {
            String addr = "101010";
            addr = new String(addr.getBytes("GBK"), "utf-8");
            System.out.println(bA.getMapByAddress(addr));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testGetMapByAddress() {
    }

    @Test
    void getlLocationByAddress() {
    }

    @Test
    void getCircleSearch() {
        System.out.println("getCircleSearch");
        Double t = 1.0002028238;
        System.out.println(t.toString());
    }
}