package assignment3;

import java.util.Stack;

public class InfixCalculator {
    String expression = null;

    public InfixCalculator(String input) {
        expression = input;
    }

    private int opPrecedence(String given) {
        if(given.equals("+") | given.equals("-")){
            return 0;
        }
        if (given.equals("*") | given.equals("/")) {
            return 1;
        }
        if (given.equals("(") | given.equals(")")) {
            return 2;
        }
        else{
            return -1;
        }
    }
    private boolean checkNumber(String given) { 
        if(given.equals("0") | given.equals("1") | given.equals("2") | given.equals("3") | given.equals("4") | given.equals("5") | given.equals("6") | given.equals("7") | given.equals("8") | given.equals("9")){
            return true;
        }
        return false;
    }
    private boolean checkOperator(String given) {
        if (given.equals("+") | given.equals("-") | given.equals("*") | given.equals("/")) {
            return true;            
        }
        return false;
    }

    private StackListBased convertPostFix() { 
        //stack to temp hold operators
        StackListBased temporaryStack = new StackListBased();
        //hold finished post fix stack
        StackListBased postFixStack = new StackListBased();
        String[] expressionArray = new String [expression.length()];
        int index = 0;
        for (Character given : expression.toCharArray()) {
            expressionArray[index] = given.toString();
            index++;
        }
        for (int i = 0; i < expressionArray.length; i++) {
            String given = expressionArray[i];
            //ignore white space
            if (given.equals(" ")) {
                continue;
            }
            if(checkNumber(given)) {
                int k = 1;
                String number = "" + given;
                while (i + k < expressionArray.length && checkNumber(expressionArray[i + k])) {
                    number = number + expressionArray[i + k];
                    k++;
                }
                if (k > 1) {
                    postFixStack.push(number);
                    i = i + k - 1;
                }else{
                    postFixStack.push(given);
                    continue;
                }
            }
            if (given.equals("(")) {
                temporaryStack.push(given);
            }
            if (given.equals(")")) {
                while (!((String) postFixStack.peek()).equals("(")) {
                    postFixStack.push(temporaryStack.pop());
                }
                Object removeParanthasis = temporaryStack.pop();        
            }
            if(checkOperator(given)){
                while (!temporaryStack.isEmpty() && !((String) temporaryStack.peek()).equals("(") && opPrecedence(given) <= opPrecedence((String) temporaryStack.peek())) {
                    postFixStack.push(temporaryStack.pop());
                }
                temporaryStack.push(given);
            }
        }
        while (!temporaryStack.isEmpty()) {
            postFixStack.push(temporaryStack.pop());            
        }
        return postFixStack;
    }
    private String postFixString(StackListBased postFixStack) {
        String s = "";
    }
}