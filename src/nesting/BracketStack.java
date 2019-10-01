package nesting;


import java.util.ArrayList;
import java.util.Collections;

public class BracketStack {
    private int maxSize;
    private int capacity;
    private ArrayList<String> stackArray;
    private int top;
    int forCount = 0;
    int whileCount = 0;

    public BracketStack(){
       // maxSize = 20;

        stackArray = new ArrayList<String>();
        capacity = maxSize;
        //top = -1;
    }
    public Boolean isFull()
    {
        return top == capacity - 1;	// or return size() == capacity;
    }

    public Boolean isEmpty()
    {
        if(stackArray.size() == 0) return true;
        else return false;
    }



    public int size()
    {
        forCount=Collections.frequency(stackArray, "for");
        whileCount=Collections.frequency(stackArray, "while");
        return forCount+whileCount;
    }

    public void push(String x){

        stackArray.add(x);
    }
    public void checkNoBracketLoops(){
        //if(stackArray.get())
            //if(stackArray.get(stackArray.size()-1).equals("}")){

                if(stackArray.get(stackArray.size()-1).equals("while") || stackArray.get(stackArray.size()-1).equals("for")){
                    pop();//stackArray.remove(stackArray.size() - 1);
                    //return 1;
                }

            //}
           // return 0;
    }

    public void  popStack(){
        if(stackArray.get(stackArray.size()-1).equals("{")){
            if(stackArray.get(stackArray.size()-2).equals("while") || stackArray.get(stackArray.size()-2).equals("for")){
                pop();
            }

        }else{
            stackArray.remove(stackArray.size() - 1);
        }

    }

    public void pop(){
        if (!isEmpty())
        {
          //  stackArray.remove(stackArray.size() - 1);
           // checkNoBracketLoops();
          //  System.out.println("11111111111111111111111111111111:"+stackArray.size());
            stackArray.remove(stackArray.size() - 1);
            stackArray.remove(stackArray.size() - 1);
          //  System.out.println("11111111111111111111111111111111:"+stackArray.size());
        }else
            throw new IllegalStateException("Stack is empty");

    }

    public void oneTimePop(){
        if (!isEmpty())
        {
            //  stackArray.remove(stackArray.size() - 1);
            // checkNoBracketLoops();
            //  System.out.println("11111111111111111111111111111111:"+stackArray.size());

            stackArray.remove(stackArray.size() - 1);
            //  System.out.println("11111111111111111111111111111111:"+stackArray.size());
        }else
            throw new IllegalStateException("Stack is empty");

    }

    public String peek()
    {
        if(!isEmpty()){
            return stackArray.get(stackArray.size() - 1);
        }else{
            return "empty";
        }
    }



}
