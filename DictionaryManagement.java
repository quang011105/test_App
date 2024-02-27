import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

class DictionaryManagement{
    public static void insertFromCommandline(Dictionary dictionary){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n; i++){
            String word_target = scanner.nextLine();
            String word_explain = scanner.nextLine();
            Word word = new Word(word_target, word_explain);
            dictionaryAdd(dictionary, word);
        }
    }
    public static void insertFromFile(Dictionary dictionary){
        try{
            Scanner scanner = new Scanner(new File("dictionaries.txt"));
            while(scanner.hasNextLine()){
                String word_target = scanner.nextLine();
                String word_explain = scanner.nextLine();
                Word word = new Word(word_target, word_explain);
                dictionaryAdd(dictionary, word);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void dictionaryLookup(Dictionary dictionary){
        Scanner scanner = new Scanner(System.in);
        String word_target = scanner.nextLine();
        System.out.println(dictionary.words.get(word_target));
    }

    public static void dictionaryAdd(Dictionary dictionary, Word word){
        dictionary.words.put(word.word_target, word.word_explain);
    }
    public static void exportToFile(Dictionary dictionary){
        try{
            File file = new File("dictionaries.txt");
            java.io.PrintWriter output = new java.io.PrintWriter(file);
            for(Map.Entry<String, String> entry : dictionary.words.entrySet()){
                output.println(entry.getKey());
                output.println(entry.getValue());
            }
            output.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void dictionaryEdit(Dictionary dictionary){
        Scanner scanner = new Scanner(System.in);
        String word_target = scanner.nextLine();
        String word_explain = scanner.nextLine();
        Word word = new Word(word_target, word_explain);
        dictionary.words.put(word_target, word_explain);
    }
    public static void dictionaryDelete(Dictionary dictionary){
        Scanner scanner = new Scanner(System.in);
        String word_target = scanner.nextLine();
        dictionary.words.remove(word_target);
    }
    public static void dictionarySearcher(Dictionary dictionary){
        Scanner scanner = new Scanner(System.in);
        String word_target = scanner.nextLine();
        for(Map.Entry<String, String> entry : dictionary.words.entrySet()){
            if(entry.getKey().startsWith(word_target)){
                System.out.println(entry.getKey());
            }
        }
    }
    public static void showAllWords(Dictionary dictionary){
        for(Map.Entry<String, String> entry : dictionary.words.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
