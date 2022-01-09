package t0109.implement_trie_prefix_tree;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * 208. 实现 Trie (前缀树)
 * 中等
 *
 *
 *  前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 *  这一数据结构有相当多的应用情景，例如自动补完和拼写检查
 *
 * @author liulin
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));;   // 返回 True
        System.out.println(trie.search("app"));;     // 返回 False
        System.out.println(trie.startsWith("app"));; // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));;     // 返回 True
    }
}
