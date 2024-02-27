import java.util.Scanner; // Import the Scanner class
//import java.util.Map; // Import the Map class
public class DictionaryCommandline {
    public static void dictionaryMenu(Dictionary dictionary){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Insert from commandline");
        System.out.println("2. Insert from file");
        System.out.println("3. Lookup");
        System.out.println("4. Add");
        System.out.println("5. Edit");
        System.out.println("6. Delete");
        System.out.println("7. Export to file");
        System.out.println("8. Searcher");
        System.out.println("9. Show all words");
        System.out.println("0. Exit");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 1:
                DictionaryManagement.insertFromCommandline(dictionary);
                break;
            case 2:
                DictionaryManagement.insertFromFile(dictionary);
                break;
            case 3:
                DictionaryManagement.dictionaryLookup(dictionary);
                break;
            case 4:
                DictionaryManagement.dictionaryAdd(dictionary, null);
                break;
            case 5:
                DictionaryManagement.dictionaryEdit(dictionary);
                break;
            case 6:
                DictionaryManagement.dictionaryDelete(dictionary);
                break;
            case 7:
                DictionaryManagement.exportToFile(dictionary);
                break;
            case 8:
                DictionaryManagement.dictionarySearcher(dictionary);
                return;
            case 9:
                DictionaryManagement.showAllWords(dictionary);
            case 0:
                return;
        }
        dictionaryMenu(dictionary);
    }
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionaryMenu(dictionary);
    }
}