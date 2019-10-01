package nesting;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class BracketCheck {
    final String str1 = "for";
    final String str2 = "while";
    static int oneLineLoop;
    public static int noBracketStatus;
    public static HashMap<Integer, String> loopWordMap = new HashMap<Integer, String>();
    public static HashMap<Integer, String> bracketMap = new HashMap<Integer, String>();
    public static List<Line> lineList = new ArrayList<Line>();
    public static int addValue = 0;

    int forCount = 0;
    int whileCount = 0;
    int count = 0;

    public void addValues(Map.Entry<Integer, String> firstLoopValue){
        System.out.println("Loop Value:"+firstLoopValue);
        if (firstLoopValue.getValue().equalsIgnoreCase("for") || firstLoopValue.getValue().equalsIgnoreCase("while")){
            if(NestingCheck.bracketStack.isEmpty()==false){
                NestingCheck.bracketStack.checkNoBracketLoops();
            }
            NestingCheck.bracketStack.push(firstLoopValue.getValue());
        }else if(firstLoopValue.getValue().equalsIgnoreCase("{")){
            NestingCheck.bracketStack.push(firstLoopValue.getValue());
        }else if(firstLoopValue.getValue().equalsIgnoreCase("}")){
            NestingCheck.bracketStack.popStack();
            //NestingCheck.bracketStack.pop();
        }
    }


    public void checkBrackets(String text) {
        loopWordMap.clear();
        //System.out.print(text);
        forCount = StringUtils.countMatches(text, str1);
        whileCount = StringUtils.countMatches(text, str2);
        count = forCount + whileCount;
            for (int i = -1; (i = text.indexOf(str1, i + 1)) != -1; i++) {
                loopWordMap.put(i,"for");
            }
            for (int i = -1; (i = text.indexOf(str2, i + 1)) != -1; i++) {
                loopWordMap.put(i,"while");
            }
            for (int i = -1; (i = text.indexOf("{", i + 1)) != -1; i++) {
                //NestingCheck.bracketStack.push(1);
                loopWordMap.put(i,"{");
            }
            for (int i = -1; (i = text.indexOf("}", i + 1)) != -1; i++) {
                //NestingCheck.bracketStack.pop();
                loopWordMap.put(i,"}");
            }

        Map<Integer, String> sortedLoopWordMap = new TreeMap<Integer, String>(loopWordMap);
        if(sortedLoopWordMap.size()>0) {
            Set set2 = sortedLoopWordMap.entrySet();
            Iterator iterator2 = set2.iterator();
            while (iterator2.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator2.next();
            }

            Iterator it = sortedLoopWordMap.entrySet().iterator();
            it.hasNext();
            Map.Entry<Integer, String> firstLoopValue = (Map.Entry)it.next();
            if(BracketCheck.noBracketStatus == 1){
                addValue = 1;
                BracketCheck.noBracketStatus = 0;
            }
            //System.out.println("Loop1 Value:"+firstLoopValue);
            addValues(firstLoopValue);
            for( int a = 1; a<sortedLoopWordMap.size();a++){

                Map.Entry<Integer, String> secondLoopValue = (Map.Entry)it.next();

                if(firstLoopValue.getValue().equals("while")||firstLoopValue.getValue().equals("for")){
                    if(secondLoopValue.getValue().contains("while") || secondLoopValue.getValue().contains("for")){

                    }else  if(secondLoopValue.getValue().contains("{")){
                       // System.out.println("Loop Value2:"+secondLoopValue);
                        addValues(secondLoopValue);
                    }
                }else{
                    addValues(secondLoopValue);
                }
                firstLoopValue = secondLoopValue;
            }
        }
        if(NestingCheck.bracketStack.peek().equals("while") || NestingCheck.bracketStack.peek().equals("for")){
            BracketCheck.noBracketStatus = 1;
        }else{
            BracketCheck.noBracketStatus = 0;
        }
        lineList.add(new Line(text,NestingCheck.bracketStack.size()+addValue));
        BracketCheck.addValue = 0;

    }
}
