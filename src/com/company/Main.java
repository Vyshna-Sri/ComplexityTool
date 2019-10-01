package com.company;

import common.ReadFile;
import nesting.NestingCheck;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        NestingCheck nestingCheck = new NestingCheck();
        nestingCheck.checkCnc();
    }
}
