import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
import java.util.*;


public class countStringPatterns {

    int countArray = 0;
    int countList = 0;

    long startTimeArray = 0;
    long startTimeList = 0;
    long endTimeArray = 0;
    long endTimeList = 0;


    ArrayList<Character> ArrayList = new ArrayList<Character>();
    LinkedList<Character> LinkedList = new LinkedList<Character>();
    ArrayList<Character> blueArrayList;
    LinkedList<Character> blueLinkedList;

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
            while(reader != null) {
                StringTokenizer object = new StringTokenizer(read);

                while (object.hasMoreTokens()) {
                    time(object);
                    
                }
                read = reader.readLine();
            }
            System.out.println("Using ArrayList, found " + startTimeArray + "matches, delivered in " + endTimeArray + " milliseconds.");
			System.out.println("Using LinkedList, found " + startTimeList + "matches, delivered in " + endTimeList + " milliseconds.");
            
            // reader.close();
        } catch (IOException e) {
            //DONE: handle exception
            System.out.println("Error! File not found or invalid String");
			System.exit(1);
        }
    }
    private void time(StringTokenizer object) {
        blueArrayList = new ArrayList<Character>();
        blueLinkedList = new LinkedList<Character>();

        String token = object.nextToken();

        for (int index = 0; index < token.length(); index++) {
            blueArrayList.add(token.charAt(index));
            blueLinkedList.add(token.charAt(index));
        }

        //count time for ArrayList
		long startTimeArray = System.currentTimeMillis();
		if(findBrute(blueArrayList,ArrayList)!=-1){
			countArray++;
		}
		long endTimeArray = System.currentTimeMillis();
		startTimeArray = startTimeArray + (endTimeArray-startTimeArray);
		//end of timing block

		//count time for LinkedList
		long startTimeList = System.currentTimeMillis();
		if(findBrute( blueLinkedList,LinkedList)!=-1){
			countList++;
		}
		long endTimeList = System.currentTimeMillis();
		startTimeList = startTimeList + (endTimeList - startTimeList);
		//end of timing block

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