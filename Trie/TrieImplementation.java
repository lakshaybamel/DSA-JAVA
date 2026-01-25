
public class TrieImplementation {

    // Trie Node definition
    static class Node {

        // Each node can have 26 children (a–z)
        Node[] children = new Node[26];

        // true if this node marks the end of a word
        boolean endOfWord = false;

        // constructor initializes children with null
        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    // Root node of Trie (empty node)
    public static Node root = new Node();

    // Insert a word into Trie
    // Time Complexity: O(L), L = length of word
    public static void insert(String word) {
        Node curr = root; // start from root

        // traverse each character of the word
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a'; // map char to index (0–25)

            // if path does not exist, create new node
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            // move to next node
            curr = curr.children[idx];
        }

        // after last character, mark end of word
        curr.endOfWord = true;
    }

    // Search a word in Trie
    // Time Complexity: O(L)
    public static boolean search(String word) {
        Node curr = root; // start from root

        // traverse characters of word
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';

            // if character path not found -> word not present
            if (curr.children[idx] == null) {
                return false;
            }

            // move to next node
            curr = curr.children[idx];
        }

        // return true only if complete word exists
        return curr.endOfWord;
    }

    public static void main(String[] args) {

        String[] words = {"the", "a", "there", "their", "any", "thee"};

        // insert all words into Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // search words
        System.out.println(search("thee")); // true
        System.out.println(search("thor")); // false
    }
}
