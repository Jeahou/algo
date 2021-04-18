package basic.trie;

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("frodo");
        trie.insert("fdoso");
        trie.insert("aronl");
        trie.insert("frozen");
        System.out.println(trie.rootNode);
            System.out.println(trie.rootNode.getChildNode().get('f').getChildNode());

    }

    private TrieNode rootNode;
    Trie(){
        rootNode = new TrieNode();
    }
    void insert(String word){
        TrieNode thisNode = this.rootNode;
        for(int i=0; i<word.length(); i++){
            thisNode = thisNode.getChildNode().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        thisNode.setIsLastChar(true);
    }

    boolean contains(String word){
        TrieNode thisNode = this.rootNode;
        for(int i=0; i<word.length(); i++){
            char character = word.charAt(i);
            TrieNode node = thisNode.getChildNode().get(character);

            if(node == null) return false;

            thisNode = node;
        }
        return thisNode.isLastChar();
    }
    void chkContains(String word){
        TrieNode thisNode = this.rootNode;
        for(int i=0; i<word.length(); i++){
            char character = word.charAt(i);
            if(character == '?'){
                TrieNode node = thisNode.getChildNode().get(character);
            }else{

            }
        }
    }
    void delete(String word){
        delete(this.rootNode, word, 0);
    }

    private void delete(TrieNode thisNode, String word, int index){
        char character = word.charAt(index);

        if(!thisNode.getChildNode().containsKey(character))
            throw new Error("no");

        TrieNode childNode = thisNode.getChildNode().get(character);
        index++;
        if(index == word.length()){
            if(!childNode.isLastChar())
                throw new Error("nono");
            childNode.setIsLastChar(false);

            if(childNode.getChildNode().isEmpty())
                thisNode.getChildNode().remove(character);
        }else{
            delete(childNode, word, index);
            if(!childNode.isLastChar() && childNode.getChildNode().isEmpty())
                thisNode.getChildNode().remove(character);
        }
    }
}
