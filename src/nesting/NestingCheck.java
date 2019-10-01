package nesting;

import common.ReadFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NestingCheck {
    Statement statement;
    BracketCheck bracketCheck;
    FindFunction findFunction;
    ReadFile readFile;
    private boolean findFunctionStatus;
    public static BracketStack bracketStack;
    int lineAdd = 0;
    public NestingCheck(){
        readFile = new ReadFile();
        statement = new Statement();
        bracketCheck = new BracketCheck();
        bracketStack = new BracketStack();
        findFunction = new FindFunction();
    }


    public boolean checkCnc() throws IOException {
        findFunctions();

        return true;
    }

    public boolean findFunctions() throws IOException {
        BufferedReader br = readFile.sendStatement();
        String st;
        while ((st = br.readLine()) != null) {
            int loopValue = checkBracket(st);
            //System.out.println("CheckBracket Value:"+loopValue);
            if(findFunction.checkingFunctions(st,loopValue)){
                FindFunction.recursiveFunctionStatus = 1;
                //System.out.println("After calling"+FindFunction.recursiveFunctionStatus);
                findFunction.editCncValues();

            }



        }
        display();
        return true;
    }

    public void display(){

            List<StatementArray> list= FindFunction.statementWithValue;
            for (int i = 0; i < list.size()-1; i++)
            {
                StatementArray data = list.get(i);

                System.out.println(data.setSno()+" :"+data.statement+" :"
                        +data.cncValue+" :"+data.status);
            }

    }

    public int checkBracket(String st){
           // findFunctionStatus = findFunctions(st);
           // System.out.println(NestingCheck.bracketStack.peek());
            if(BracketCheck.oneLineLoop == 1){
                BracketCheck.oneLineLoop = 0;
                lineAdd = 1;
            }
            if(st.contains("for") || st.contains("while") || st.contains("{") || st.contains("}")){
                bracketCheck.checkBrackets(st);
            }else{
                if(BracketCheck.noBracketStatus == 1){
                    BracketCheck.addValue = 1;
                    BracketCheck.noBracketStatus = 0;
                    BracketCheck.lineList.add(new Line(st,NestingCheck.bracketStack.size()));
                    NestingCheck.bracketStack.oneTimePop();
                }else{
                    BracketCheck.lineList.add(new Line(st,NestingCheck.bracketStack.size()+BracketCheck.addValue));
                }
                BracketCheck.addValue = 0;
            }
                //System.out.println("Values**"+BracketCheck.lineList.get(BracketCheck.lineList.size()-1).toString());
            return BracketCheck.lineList.get(BracketCheck.lineList.size()-1).getValue();
    }

}
