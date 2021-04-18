package basic.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> childNode = new HashMap<>();
    private boolean isLastChar;

    //getter/setter
    Map<Character, TrieNode> getChildNode(){
        return this.childNode;
    }
    boolean isLastChar(){
        return this.isLastChar;
    }

    void setIsLastChar(boolean isLastChar){
        this.isLastChar = isLastChar;
    }
}
