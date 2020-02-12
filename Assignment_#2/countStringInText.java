/*
    @Description: This class counts the number of times a certain string appears in a large text file. It also compares the elapsed times to completion of a LinkedList approach to an ArrayList approach.
    @Author: Kareem El Assad
    @Date: 2/11/2020
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.util.Scanner;


public class countStringInText {
    
    /*
     * Returns the lowest index at which substring pattern begins in text (or else
     * -1).
     */

    private static int findBrute(List<Character> text, List<Character> pattern) {
        int n = text.size();
        int m = pattern.size();
        for (int i = 0; i <= n - m; i++) { // try every starting index
            // within text
            int k = 0; // k is index into pattern
            while (k < m && text.get(i + k) == pattern.get(k))
                // kth character of pattern matches
                k++;
            if (k == m) // if we reach the end of the pattern,
                return i; // substring text[i..i+m-1] is a match
        }
        return -1; // search failed
    }
    /* 
        TODO:A method that makes a LinkedList
        1) The linked list can be as big as any given string (so it must itterate)
        2) It must return the string as chars in the exact given order
        space becomes s -> p -> a -> c -> e  with e being tail.
    */
    public static LinkedList<Character> makeLinkedListStr(String word){
        LinkedList<Character> inOrderedList = new LinkedList<>(); //This creates a new LinkedList that java infers type of
        //TODO: Iterate through given word and add one by one (seems like an inefficient solution but only one can think of)
        for (int index = 0; index < word.length();index++) {
            inOrderedList.add(word.charAt(index)); //simply adds whatever the char is at the given iterant value to the list
        }
        return inOrderedList; //should return correct list
        //TODO: check this thing for christs sake lol

    }

    /* 
        TODO:A method that makes an Arraylist
        Literally the same thing as the linked list
    */
    public static ArrayList<Character> makeArrayListStr(String word){
        ArrayList<Character> inOrderedArray = new ArrayList<>(); //Again, java infers the type of the created ArrayList
        for (int index = 0; index < word.length(); index++) {
            inOrderedArray.add(word.charAt(index)); //same concept,adds whatever the char is at the given iterant value to the list
        }
        return inOrderedArray;  //hopefully return list in correct order
    }
    /* 
        A method that reads a file and checks it line by line
    */
    public static int searchListSpecificWord(String filename, Object K) throws IOException {
        if(!(K instanceof LinkedList) && !(K instanceof ArrayList)){
            throw new IllegalArgumentException("Invalid type provded");
        }
        int count;
        String[] wordsFromLine;
        BufferedReader read = new BufferedReader(new FileReader(filename));

        try {
            String line = read.readLine();

            while (line != null) {
                //TODO: Create the methods for creating a linkedlist and an Array list BEFORE proceeding.
                
            }
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public static void main(String[] args) {

    }
}
