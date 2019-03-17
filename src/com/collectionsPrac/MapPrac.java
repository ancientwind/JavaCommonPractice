package com.collectionsPrac;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPrac<K,V> {

	private Map<K,V> map = new HashMap<K,V>();
	
	public Map getMap() {
		return this.map;
	}
	
	public void printMapByKeySet(Map<K,V> map ) {
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			Object key = it.next();
			System.out.println("key is: " + key 
					+ " ; value is: " + map.get(key));
		}
	}

	public void printMapByEntrySet() {
		Set<Map.Entry<K,V>> entrySet = this.map.entrySet();
		Iterator it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<K, V> entry = (Map.Entry<K, V>) it.next();
			System.out.println("key is: " + entry.getKey() 
					+ " ; value is: " + entry.getValue());
		}
	}
	
	public void printValuesOfMap() {
		Collection coll = this.map.values();
		Iterator it = coll.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
	}

	public void mapOperation() {
		Map<Integer, String> map = new HashMap<>();
		map.put(100, "hello");
		map.put(101, "hello1");
		map.put(102, "hello3");
		map.replace(101, "hello 101");
		map.putIfAbsent(102, "hello 102");
		this.printMapByKeySet((Map<K, V>) map);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MapPrac<>().mapOperation();
	}
	
	

}
