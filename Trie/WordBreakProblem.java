public class WordBreakProblem {

    // Trie node
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // Trie root
    public static Node root = new Node();

    // Insert word into Trie
    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true; // mark complete word
    }

    // Search complete word in Trie
    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    // Word Break using recursion
    public static boolean wordBreak(String key) {
        if (key.length() == 0) return true; // base case

        // try all prefixes
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) &&
                wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for (String word : words) {
            insert(word);
        }

        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
