//Implement trie with search insert and prefix operation
class Trie {
    TrieNode root;//The root node should be of type trienode
    //initializing trie with the root referring to a trie node
    public Trie() {
        root = new TrieNode();
    }

    class TrieNode {
        Map<Character, TrieNode> map; // This will store the current char value and next trie node ref
        boolean isTerminated; // If his value of a node is true then it is considered that the word is completed there

        //Initializing
        public TrieNode() {
            map = new HashMap<>();
            isTerminated = false;
        }
    }

    public void insert(String word) {
        TrieNode crr = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!crr.map.containsKey(letter)) {
                crr.map.put(letter, new TrieNode());
            }
            crr = crr.map.get(letter);
        }
        crr.isTerminated = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode crr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!crr.map.containsKey(word.charAt(i)))
                return false;
            crr = crr.map.get(word.charAt(i));
        }
        return crr.isTerminated;
    }

    public boolean startsWith(String prefix) {
        TrieNode crr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!crr.map.containsKey(prefix.charAt(i)))
                return false;
            crr = crr.map.get(prefix.charAt(i));
        }
        return true;
    }
}
