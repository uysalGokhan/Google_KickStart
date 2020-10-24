import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int caseNumber = reader.nextInt();

		for (int i = 0; i < caseNumber; i++) {
			caseSolver(reader, i);
		}

	}

	public static void caseSolver(Scanner reader, int caseNumber) {

		System.out.print("case #" + (caseNumber + 1) + ": ");
		int n = reader.nextInt();
		int k = reader.nextInt();
		Trie tree = new Trie();
		
		for(int i = 0 ; i < n ; i++) {
			tree.add(reader.next());
		}
		
		tree.dfs(k);
		TrieNode.result = 0;
	}

}

class TrieNode{
	public static long result = 0;
	
	public HashMap<Character, TrieNode> children;
	public int noOfStrings;
	public char character;
	
	public TrieNode(char character) {
		this.noOfStrings = 0;
		this.children = new HashMap<Character, TrieNode>();
		this.character = character;
	}

}

class Trie{
	private TrieNode root;
	
	public Trie() {
		this.root = new TrieNode('1');
	}
	
	public void add(String word) {
		TrieNode current = root;
		
		for(char c : word.toCharArray()) {
			if(current.children.containsKey(c)) {
				current = current.children.get(c);
			} else {
				TrieNode tmp = new TrieNode(c);
				current.children.put(c, tmp);
				current = current.children.get(c);
			}
		}
		current.noOfStrings++;
	}
	
	public void dfs(int k) {
		dfs(this.root, k, 0);
		System.out.println(TrieNode.result);
	}
	
	public int dfs(TrieNode node, int k, int height) {
		if(node.children.isEmpty()) {
			TrieNode.result += ((int)(node.noOfStrings / k)) * height;
			return (node.noOfStrings % k);
		}
		
		int tmpSum = 0;
		for(char c : node.children.keySet()) {
			tmpSum += dfs(node.children.get(c), k, height + 1);
		}
		tmpSum += node.noOfStrings;
		TrieNode.result += ((int)(tmpSum / k)) * height;
		return (tmpSum % k);
	}
}
