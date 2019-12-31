package com.baizhi.test;

import org.junit.Test;

import java.util.Date;

/**
 * @ClassName Testasd
 * @Discription
 * @Author
 * @Date2019/11/15 17:46
 */
public class Testasd {
    @Test
    public void test(){
        long l = new Date().getTime();
        String s = String.valueOf(l);
        System.out.println(s);

//1573819146152
        String s1 = getDate();
        System.out.println(s1);
    }
    public String getDate(){
        long l = new Date().getTime();
        String s = String.valueOf(l);
        return s;
    }
}
