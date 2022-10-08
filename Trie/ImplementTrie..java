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
    //implement delete function in trie
    public boolean deleteWord(String word) {
        TrieNode crr = root;
        if (word.length() == 0) return false;

        TrieNode toDeleteNode = null;
        char toDeleteChar = '\0';

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!crr.map.containsKey(letter))
                return false;
            //This condition is for, if the crr map contains more than 1 element or if this node is temination node of some other
            //Word then we mark this node with todeleteNode var and the matching char with todelete char
            if (crr.map.size() > 1 || crr.isTerminated) {
                toDeleteNode = crr;
                toDeleteChar = letter;
            }
            crr = crr.map.get(letter);
        }
        //If the node crr refers to is not a terminated then it is a case that the prefix is presented
        //but it is for another word so in this case we return false.
        if (!crr.isTerminated) return false;

        //This condition is, if the crr node map is empty then it is a case that we can delete entire node tree starting from
        //todeletenode to the crr node
        if (crr.map.isEmpty())
            toDeleteNode.map.remove(toDeleteChar);
        else crr.isTerminated = false; // If the delete word is a prefix of some other word then simply we can mark the crr node 
        //isTerminated to false.
        return true;
    }
}
