/**
 * 
 */
package demo.proj.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * Ternary tree could be used for phone-book searching for partial match
 *  here i is used for books catalog search
 * 
 * @author divija
 * @author sam
 *
 */
@Component("ternaryTree")
public class TernaryTree <E extends Comparable>{
 
	public static class Node<E> {
		
		Node<E> left, right, equal;
		char ch;
		boolean last;
		Collection<E> priorityQueue;
		
		public Node(char ch) {
			this(ch, false, null);
		}
		
		public Node(char ch, boolean last, Collection<E> priorityQ) {
			this.ch = ch;
			this.last = last;
			priorityQueue = priorityQ;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

		public Node<E> getEqual() {
			return equal;
		}

		public void setEqual(Node<E> equal) {
			this.equal = equal;
		}

		public char getCh() {
			return ch;
		}

		public void setCh(char ch) {
			this.ch = ch;
		}

		public boolean isLast() {
			return last;
		}

		public void setLast(boolean last) {
			this.last = last;
		}

		public Collection<E> getPriorityQueue() {
			return priorityQueue;
		}

		public void setPriorityQueue(Collection<E> priorityQueue) {
			this.priorityQueue = priorityQueue;
		}
		
	}
	
	private Node<E> root;
	
	@PostConstruct
	public void init() {
		System.out.println("initializing  - TernaryTree");
		root = new Node<E>('x');
	}
	
	public void add(String key, E val ) {
		
		char [] chars = key.toCharArray();
		int index = 0;
		
		Node<E> current = root.equal;
		Node<E> prev = current;
		
		// Setting up tree if it is null
        if(current == null) {
        	current = new Node<E>(chars[index++], false, new PriorityQueue<E>());
        	current.priorityQueue.add(val);
    		root.equal = current;
    		prev = current;
    		
    		while (index < chars.length) {
    			current = new Node<E>(chars[index++],false, new PriorityQueue<E>() );
        		current.priorityQueue.add(val);
    			prev.equal = current;
    			prev = current;
    		}
    		current.setLast(true);
        }
        
        while (index < chars.length) {
        	// Traverse to find the tree node and also add the value to enable partial match search
        	prev = current;
        	if(current.ch == chars[index]) {
        		current.priorityQueue.add(val);
        		current = current.equal;
        		index++;
        	} else if(current.ch > chars[index]) {
        		current = current.left;
        	} else {
        		current = current.right;
        	}
        	
        	// tree does not have matching path so create new nodes
        	if(index < chars.length && current == null) {
        		while (index < chars.length) {
        			current = new Node<E>(chars[index], false, new PriorityQueue<E>());
            		current.priorityQueue.add(val);
            		
                	if(prev.ch == chars[index] || prev.equal == null) {
                		prev.equal = current;
                	} else if(prev.ch > chars[index]) {
                		prev.left = current;
                	} else {
                		prev.right = current;
                	}
                	prev = current;
                	index++;
        		}
        		current.setLast(true);
        	}
        }
	}
	
	public Collection<E> search(String key) {
		Node<E> node = searchInternal(key);
		return node==null ? null: node.priorityQueue;
	}
	
	public Node<E> searchInternal(String key) {
		Node<E> current = root.equal;
		char [] chars = key.toCharArray();
		int index = 0;

		 while (index < chars.length && current != null) {
	        	if(current.ch == chars[index]) {
	        		if(index == chars.length -1)
	        			return current;
	        		current = current.equal;
	        		index++;
	        	} else if(current.ch > chars[index]) {
	        		current = current.left;
	        	} else {
	        		current = current.right;
	        	}
	}
		 return null;
	}
	
}
