package com.test;

public class EnvTest {
    public static void main(String[] args) {

        String token = System.getProperty("GITHUB_TOKEN");

        System.out.println("Token = " + token);
    }
}