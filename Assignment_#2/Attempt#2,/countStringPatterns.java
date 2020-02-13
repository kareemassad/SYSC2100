import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.util.*;


public class countStringPatterns {

    long startTimeArray = 0;
    long startTimeList = 0;
    long endTimeArray = 0;
    long endTimeList = 0;


    ArrayList<Character> ArrayList = new ArrayList<Character>();
    LinkedList<Character> LinkedList = new LinkedList<Character>();
    ArrayList<Character> countArrayList;
    LinkedList<Character> countLinkedList;

    public countStringPatterns() {
        // blank
    }

    public static void main(String[] args) throws IOException {
        try {
            countStringPatterns blue = new countStringPatterns();

            Scanner input = new Scanner(System.in);

            System.out.print("Please enter the file you want to search: " + "\n");
            String filename = input.nextLine();

            System.out.print("Please enter the word you want to search for: " + "\n");
            String word = input.nextLine();

            input.close();

            blue.compare(word, filename);

            if (findBrute(countArrayList, ArrayList) != -1) {
                countArrayList++;
            }
            if(findBrute(countLinkedList,LinkedList)!=-1){
                countLinkedList++;
            }

            long originalTime = System.currentTimeMillis(); //current time, thanks for the hint prof haha
        
            int countLinkedList = searchListSpecificWord(filename, patternForLinkedList);
            long elapsedTimeLinkedList = System.currentTimeMillis() - originalTime; //elapsed time for linked list
    
            int countArrayList = searchListSpecificWord(filename, patternForArrayList);
            long elapsedTimeArrayList = System.currentTimeMillis() - originalTime;
    
            System.out.println("Using the LinkedList approach: " + countLinkedList + " matches, done in " + elapsedTimeLinkedList + " milliseconds");
            
            System.out.println("Using the ArrayList approach: " + countArrayList + " matches, done in " + elapsedTimeArrayList + " milliseconds");



        } catch (IOException e) {
            System.out.println("file could not be found");
        }
    }

    public void compare(String word, String filename) throws IOException{
        try {
            System.out.println("The String <" + word + "> will be searched in file " + filename + "\n");

            BufferedReader reader = new BufferedReader(new FileReader(filename));

            String read = reader.readLine();

            for (int index = 0; index < word.length(); index++) {
                ArrayList.add(word.charAt(index));

                LinkedList.add(word.charAt(index));
            }
            while(reading != null) {
                StringTokenizer object = new StringTokenizer(read);

                while (object.hasMoreTokens()) {
                    time(object);
                    
                }
                read = reader.readLine();
            }
            System.out.println("Using ArrayList, found " + startTimeArray + "matches, delivered in " + endTimeArray + " milliseconds.");
			System.out.println("Using LinkedList, found " + startTimeList + "matches, delivered in " + endTimeList + " milliseconds.");
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Error! File not found or invalid String");
			System.exit(1);
        }
    }
    private void time(StringTokenizer object) {
        countArrayList = new ArrayList<Character>();
        countLinkedList = new LinkedList<Character>();

        String token = object.nextToken();

        for (int index = 0; index < token.length(); index++) {
            countArrayList.add(token.charAt(index));
            countLinkedList.add(token.charAt(index));
        }

        // //count time array
        // long originalTimeArray = System.currentTimeMillis();
        // if(findBrute(countArrayList, ArrayList) != -1){
        //     count++;
        // }
        // long endTimeArray = System.currentTimeMillis();
        // startTimeArray = startTimeArray + (endTimeArray - startTimeArray)

    }
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
}