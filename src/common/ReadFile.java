package common;

import nesting.NestingCheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {



    public BufferedReader getFile() throws IOException {

        File file = new File("/root/IdeaProjects/NestingProject/src/com/company/test.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        return br;
    }

    public BufferedReader sendStatement() throws IOException {
        ReadFile readFile = new ReadFile();
        BufferedReader br = readFile.getFile();
        NestingCheck nestingCheck = new NestingCheck();
        String st;
        return br;
/*        while ((st = br.readLine()) != null) {
            //nestingCheck.checkBracket(st);
            nestingCheck.checkCnc(st);
            // System.out.println(st);
        }*/
    }
}
