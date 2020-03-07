package assignment3;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ListIterator;

import org.graalvm.compiler.word.Word;

public class LanguageRecognizerG {
    
    String InputWord = "";
    ArrayList<Character> CharacterList = new ArrayList<Character>();
    int initialSize;

    LanguageRecognizerG(String input){
        InputWord = input;
        for (char c : input.toCharArray()) {
            CharacterList.add(c);
        }
        initialSize = CharacterList.size();
        ListIterator WordIterating = CharacterList.listIterator(0);
    }

    private boolean recursiveRecogR(ArrayList<Character> WordList) {
        //empty string
        if (WordList.size() == 0) {
            return true;
        }
        // & or # case
        if (WordList.size() == 1) {
            if (WordList.get(0) == '&' | WordList.get(0) == '#') {
                return true;
            }
        }
        //W|A and &|#
        if (WordList.size() == 2) {
            if ((WordList.get(0) == 'W' | WordList.get(0) == 'A') && (WordList.get(1) == '&' | WordList.get(1) == '#')) {
                return true;
            }
        }
    }
}