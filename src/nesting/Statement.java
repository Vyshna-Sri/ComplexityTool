package nesting;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Arrays;

public class Statement {

    private Pattern pattern = Pattern.compile(";");
    private Matcher matcher;
    private int indexOfFirstSemicolenInFor;
    private int lastOfFirstSemicolenInFor;
    private int arrSize;

    ArrayList<Integer> semicolenIndexArr = new ArrayList<Integer>();
    ArrayList<Integer> forCountArr = new ArrayList<Integer>();


    public void checkStatement(String st){
        matcher = pattern.matcher(st);

        int semicolenCount = 0;
        int forCount = 0;
        semicolenIndexArr.clear();

        int index = st.indexOf(";");
        while (index >= 0) {
            //System.out.println("**********"+index);
            semicolenIndexArr.add(index);
            semicolenCount++;
            index = st.indexOf(";", index + 1);
        }


        if(st.contains("for")){
            int index2 = st.indexOf("for");
            while (index2 >= 0) {
                //System.out.println("**********"+index2);
                index2 = st.indexOf("for", index2);
                forCountArr.add(index2);
                index2 = st.indexOf(")", index2);
                forCountArr.add(index2);
                forCount++;

            }
            int a = 0;
            arrSize = forCountArr.size();
            for(Integer ar:semicolenIndexArr){
                if(ar >= arrSize || ar <= arrSize){

                }
            }
            indexOfFirstSemicolenInFor = st.indexOf("for");
            lastOfFirstSemicolenInFor = st.indexOf(")");
            System.out.println(indexOfFirstSemicolenInFor+"**"+lastOfFirstSemicolenInFor);
        }

        System.out.print(semicolenIndexArr.size());

        System.out.print("++++++++"+semicolenIndexArr);

    }
}
