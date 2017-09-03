import java.util.*;

public class RandomNote {
    Map<String, Integer> magazineMap = new HashMap<String, Integer>();
    Map<String, Integer> noteMap = new HashMap<String, Integer>();
    String[] notes;
    
    public RandomNote(String magazine, String note) {
        this.notes = note.split(" ");
        
        for(String str: magazine.split(" ")) {
            if(!magazineMap.containsKey(str)) {
                magazineMap.put(str, 1);
            } else {
                magazineMap.put(str, magazineMap.get(str) + 1);
            }
        }
        
        for(String str: notes) {
            if(!noteMap.containsKey(str)) {
                noteMap.put(str, 1);
            } else {
                noteMap.put(str, noteMap.get(str) + 1);
            }
        }
    }
    
    public boolean solve() {
        boolean result = false;

        for(String note: notes) {
            if(magazineMap.containsKey(note) && noteMap.get(note) <= magazineMap.get(note)) {
                result = true;
            } else {
                return false;
            }
        }
         return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        RandomNote s = new RandomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
