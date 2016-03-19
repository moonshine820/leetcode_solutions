package medium;
import java.util.*;
public class LRUCache146 {
	private HashMap<Integer, Node> map;
	private Node head;
	private Node tail;
	private int cap;
	private int count; // counts of key
	public LRUCache146(int capacity) {
		map = new HashMap<Integer, Node>(capacity);
		cap = capacity;
		count = 0;
		
		head = new Node(-1, -1);
		head.pre = null;
		
		tail = new Node(-1, -1);
		tail.next = null;
		
		head.next = tail;
		tail.pre = head;
	}
	
	/**
	 * Get the value (will always be positive) of the key if the key exists in the cache, 
	 * otherwise return -1.
	 * @param key
	 * @return value
	 */
	public int get(int key) {
		Node node = map.get(key);
		if(node == null) {
			return -1;
		} 
		this.moveToHead(node);
		return node.value;
	}
	
	/**
	 * Set or insert the value if the key is not already present. 
	 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
	 * @param key
	 * @param value
	 */
	public void set(int key, int value) {
		Node node = map.get(key);
		
		//if the value doesn't exist in the cache, two cases : cache full or not full
		if(node == null) {
			 if(count == cap) {
				 Node tmp = popTail();
				 map.remove(tmp.key);
				 count--;
			 } 
			 
			 Node newNode = new Node(key, value);
			 addNode(newNode);
			 map.put(key, newNode);
			 count++;
		} else {
			//if exists, just move this node to the head;
			moveToHead(node);
			node.value = value;
		}
	}
	
	/**
	 * Move any node of the list to the head;
	 * @param node
	 */
	private void moveToHead(Node node) {
		removeNode(node);
		addNode(node);
	}
	
	/**
	 * Always add a node to the head;
	 * @param node
	 */
	private void addNode(Node node) {
		head.next.pre = node;
		node.next = head.next;
		node.pre = head;
		head.next = node;
	}
	
	/**
	 * remove Node at any position 
	 * @param node
	 */
	private void removeNode(Node node) {
		Node pre = node.pre;
		Node next = node.next;
		pre.next = next;
		next.pre= pre;
	}
	
	/**
	 * Return last node of the list.
	 * @return
	 */
	private Node popTail() {
		Node node = tail.pre;
		this.removeNode(node);
		return node;
	}
	
	public static void main(String[] args) {
		LRUCache146 lru = new LRUCache146(1);
		lru.set(2, 1);
		lru.set(2, 2);
		lru.get(2);
		lru.set(1,1);
		lru.set(4,1);
		lru.get(2);		
	}

	class Node{
		int value;
		Node next;
		Node pre;
		int key;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
