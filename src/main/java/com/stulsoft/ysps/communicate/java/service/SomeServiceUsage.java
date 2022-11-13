package com.stulsoft.ysps.communicate.java.service;

import com.stulsoft.ysps.service.SomeService;
import com.stulsoft.ysps.service.SomeServiceImpl;

public class SomeServiceUsage {
    public static void main(String[] args) {
        SomeService someService = new SomeServiceImpl(300);
        System.out.printf("1 + 2 + 300 = %d%n", someService.add(1,2));
    }
}
