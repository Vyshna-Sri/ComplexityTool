package nesting;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindFunction {
    final String checkMethod = "(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])";
    final String checkMethodCall = "(?!\\bif\\b|\\bfor\\b|\\bwhile\\b|\\bswitch\\b|\\btry\\b|\\bcatch\\b)(\\b[\\w]+\\b)[\\s\\n\\r]*(?=\\(.*\\))";
    private List<String> checkedMethodCallArray = new ArrayList<String>();
    public static int recursiveFunctionStatus;

    public static List<StatementArray> statementWithValue = new ArrayList<StatementArray>();
    private String functionName;



    public boolean checkingFunctions(String st,int loopValue){
        //System.out.println("recursive function value"+FindFunction.recursiveFunctionStatus);
        checkedMethodCallArray.removeAll(checkedMethodCallArray);
        Pattern pattern = Pattern.compile(checkMethod);
        Matcher matcher = pattern.matcher(st);
       // System.out.print(st);

        if(matcher.matches()) {
            String methodName = matcher.group(2);
            methodName.replaceAll("\\s+","");
            functionName = methodName+"(";
           // NestingCheck.bracketStack.push("function");
            FindFunction.recursiveFunctionStatus = 0;
            addValues(st,recursiveFunctionStatus+loopValue,"function");
            //System.out.println("Method:"+methodName);
        }else{
            addValues(st,recursiveFunctionStatus+loopValue,"non");
            try {
                if (!functionName.equals("0")) {
                    if (st.contains(functionName)) {
                        Pattern p = Pattern.compile(checkMethodCall);
                        Matcher m = p.matcher(st);
                        while (m.find()) {
                            checkedMethodCallArray.add(m.group());
                            System.out.println(m.group());
                        }
                    }
                }
            }catch (NullPointerException e){
                //System.out.print("Error");
            }
        }

        for(String list:checkedMethodCallArray){
            //System.out.println(list+"***"+functionName);
            if (functionName.equals(list+"(")) {
                System.out.println("True");
                return true;
            }else
                continue;
        }
        return false;
    }

    public boolean editCncValues(){
        int statementWithValueSize = FindFunction.statementWithValue.size();
        for(int i = (statementWithValueSize-1);i <= (statementWithValueSize-1);i--){
            if(FindFunction.statementWithValue.get(i).status.equals("function")){

                break;
            }else {

                int a = FindFunction.statementWithValue.indexOf(FindFunction.statementWithValue.get(i).sno);
                int value = FindFunction.statementWithValue.get(i).getCncValue();
                FindFunction.statementWithValue.get(i).setCncValue(Integer.valueOf(value)+1);
            }
        }
        return true;
    }


    public boolean addValues(String statement,int cncValue,String status){
        StatementArray statementArray = new StatementArray(StatementArray.sno++,statement,cncValue,status);
        FindFunction.statementWithValue.add(statementArray);
        return true;
    }
}
