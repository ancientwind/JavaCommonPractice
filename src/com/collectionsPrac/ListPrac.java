package com.collectionsPrac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

import com.util.PrintUtil;


public class ListPrac<T> {

	public ArrayList<T> getHashList() {
		
		return new ArrayList<T>();
		
	}
	
	/**
	 * 
	 * Vector is also an array list, the diff is that it's thread-safe which means it's synchronous
	 */
	public Vector<T> getVector() {
		return new Vector<T>();
	}
	
	public LinkedList<T> getLinkedList() {
		return new LinkedList<T>();
	}
	
	public void printList(List list) {
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public void pracListBasic() {
		List<String> list = (List<String>) this.getHashList();
		
		list.add("app");
		list.add("boy");
		list.add("cat");
		
		this.printList(list);
		
		List<String> listB = (List<String>) this.getHashList();
		listB.add("appB");
		listB.add("boyB");
		listB.add("catB");
		
		this.printList(listB);
		
        //ListIterator在Iterator基础上添加了add(),previous()和hasPrevious()方法
		ListIterator<String> listIter = list.listIterator();
		
		Iterator<String> listBIter = listB.iterator();
		
        //b归并入a当中，间隔交叉的插入b中的元素
		while(listBIter.hasNext()){
			
			if(listIter.hasNext()) {
				listIter.next();
			}
			
			listIter.add(listBIter.next());
			
		}
		
		this.printList(list);
	}
	
	public void pracLinkedListBasic() {
		LinkedList linked = this.getLinkedList();
		linked.add("apple");
		linked.add("banana");
		linked.add("cc");
		PrintUtil.print(linked.getFirst());
		PrintUtil.print(linked.get(1));
		PrintUtil.print(linked.indexOf("cc"));
	}
	
	/**
	 * use LinkedList to implement Stack and Queue
	 * 
	 */

	public void createStackAndQueue() {
		ListPrac<String> prac = new ListPrac<String>();

		StackLL stack = new StackLL();
		stack.push('a');
		stack.push('b');
		stack.push('c');
		
		QueueLL queue = new QueueLL();
		queue.put('a');
		queue.put('b');
		queue.put('c');
		
		PrintUtil.print(stack.pop());
		PrintUtil.print(queue.get());
	}
	
	/**
	 * use stack to transport 十进制10 number to D number
	 * 
	 * @param n
	 * @param D
	 * @return
	 */
	public void transport10ToD(int n, int D) {
		PrintUtil.print( n + " -> " + D + " = ");

		StackLL stack = new StackLL();
		
		while(n != 0) {
			stack.push(n % D);
			n = n / D;
		}
		
		
		this.printStackLL(stack);
		
	}
	
	public List printStackLL(StackLL stack) {
		
		List list = new ArrayList();
		
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		
		PrintUtil.print(list);
		
		return list;
	}
	
	public void pracTransport10ToD() {
		
		this.transport10ToD(2001, 8);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListPrac prac = new ListPrac();
		prac.pracTransport10ToD();
	}

}

class StackLL<T> {
	
	private LinkedList linked = new LinkedList();
	
	public StackLL(){};
	
	public void push(Object v) {
		linked.addFirst(v);
	}
	
	public Object pop() {
		return this.linked.removeFirst();
	}
	
	public boolean isEmpty() {
		return this.linked.isEmpty();
	}
	
	public Object top() {
		return this.linked.getFirst();
	}
}

class QueueLL {
	
	private LinkedList linked = new LinkedList();

	public void put(Object v) {
		this.linked.addLast(v);
	}
	
	public Object get() {
		return this.linked.getFirst();
	}
}
