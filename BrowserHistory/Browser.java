package Practice.Browser;
import java.util.ArrayList;
import java.util.List;

class Browser {
    
    private static class BrowserHistory {
        //
        // Using an ordered List to maintain url strings history order
        //
        List<String> history = new ArrayList<String>();
        //
        // Current Url in history
        //
        int currentUrl = -1;

        //
        // History
        //
        void history() {
            System.out.print("Index= " + currentUrl + " - History: ");
            for (String s : history) {
                System.out.print(s + " ");
            }
            System.out.println("");
        }
        
        //
        // Visit
        //
        void visit(String url) {
            if (currentUrl != history.size() - 1) {
                for (int i = currentUrl +1 ; i < history.size() ; i++) {
                    history.remove(i);
                }
            }
            history.add(url);
            currentUrl++;
        }
        
        //
        // Back
        //
        String back(int steps) {       
            currentUrl = currentUrl - steps;
            if (currentUrl < 0) {
                currentUrl = 0;
            }
            return history.get(currentUrl); 
        }
        
        //
        // Forward
        //
        String forward(int steps) {
            currentUrl += steps;
            if (currentUrl >= history.size()) {
                currentUrl = history.size() -1;
            }
            return history.get(currentUrl); 
        }
    }
    
    //
    // Use cases
    //
    // visit("google.com"); 1 <== index 
    // visit("apple.com"); 2 
    // visit("yahoo.com") 3
    // back
    // back
    // visit("facebook.com")
    // forward
    //
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        //
        // Test Insertion
        //
        history.visit("google.com");
        history.visit("apple.com");
        history.visit("yahoo.com");
        history.history();
        //
        // Test Back and Forward
        //
        String url = history.back(1);
        System.out.println("URL after back = " + url);
        history.history();
        url = history.forward(1);
        System.out.println("URL after forward = " + url);
        history.history();
        //
        // Test History Trimming
        //
        url = history.back(1);
        history.visit("facebook.com");
        history.history();
    }
}
