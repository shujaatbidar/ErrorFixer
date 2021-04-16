import java.util.*;
import java.io.*;

public class ErrorFixer {
    private static String wordsFileName = "Dictionary.txt"; 
    private static Scanner scanner = new Scanner(System.in);
    private static String[] words; 
    private static String userWord = ""; 
    private static SearchforWord search = new SearchforWord(); 
    private static Stack<String> suggestions = new Stack<String>(50);
    public static void main(String[] args) {
        System.out.println("\nErrorFixer: \n");
        loadWords();
        sort(words);
        startSimulation();
    }

    public static void loadWords() {
        String line = null; 
        ArrayList<String> temp = new ArrayList<String>();

        try {
            FileReader fileReader = new FileReader(wordsFileName);
            BufferedReader buffReader = new BufferedReader(fileReader);

            while ((line = buffReader.readLine()) != null) {
                temp.add(line.trim());
            }

            buffReader.close();
            words = new String[temp.size()];
            temp.toArray(words);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <E extends Comparable<E>> void sort(E[] array) {
        int n = array.length; 
        for (int i = 1; i < n; i++) {
            E temp = array[i]; 
            int j = i - 1; 

            while (j > -1 && (array[j].compareTo(temp) > 0)) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = temp;
        }
    }


    public static void startSimulation() {
        System.out.println("Type \"DONE\" when finished.\n");

        while (true) {
            System.out.print("Enter a word: ");
            userWord = scanner.next().trim().toLowerCase();
            if (userWord.equals("done")) {
                System.out.println("Had Fun Learning and Fixing your Errors!.\n");
                break;
            }
            autoCorrect();
        }
    }

    public static void autoCorrect() {
        int result = SearchforWord.binarySearch(words, userWord);


        if (result != -1) {
            System.out.println("No Errors!"
                + "\n");
        }
     
        else {
            for (String word : words) {
                char wordStart; 
                char userWordStart; 
                if (!word.isEmpty()) { 
                    wordStart = word.charAt(0);
                    userWordStart = userWord.charAt(0);
                        if (userWord.length() == word.length()) 
                            if (containsAllChars(userWord, word)) 
                                suggestions.push(word);
                }
            }

            if (suggestions.isEmpty()) {
                System.out.println("No suggestions.\n");
            }
            else {
                System.out.print("Suggestions: ");
                while (!suggestions.isEmpty()) {
                    System.out.print(suggestions.pop() + " ");
                }
                System.out.println("\n");
            }
        }
    }

    public static int toInt(String str) {
        int asciiValue = 0;
        for (int i = 0; i < str.length(); i++) {
            asciiValue += str.charAt(i);
        }

        return asciiValue;
    }
    public static boolean containsAllChars(String strOne, String strTwo) {
        Character[] one = strToCharArray(strOne);
        Character[] two = strToCharArray(strTwo);

        sort(one);
        sort(two);

        for (int i = 0; i < one.length; i++) {
            if (SearchforWord.binarySearch(two, one[i]) == -1)
                return false;
            two[i] = '0';
        }

        two = strToCharArray(strTwo);
        sort(two);

        for (int i = 0; i < two.length; i++) {
            if (SearchforWord.binarySearch(one, two[i]) == -1)
                return false;
            one[i] = '0';
        }

        return true;
    }

    public static Character[] strToCharArray(String str) {
        Character[] charArray = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = new Character(str.charAt(i));
        }

        return charArray;
    }
}