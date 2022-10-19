package com.aditya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.println("Enter Operation: put or get?");
        String operation = br.readLine();
        if(operation.toLowerCase(Locale.ROOT).equals("put")) {
            System.out.println("put operation");
        }
    }
}