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
	
	public void printMapByKeySet() {
		Iterator it = this.map.keySet().iterator();
		while(it.hasNext()) {
			Object key = it.next();
			System.out.println("key is: " + key 
					+ " ; value is: " + this.map.get(key));
		}
	}
	
	/**
	 * ap.Entry是Map声明的一个内部接口，此接口为泛型，定义为Entry。
	 * 它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
	 */
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	

}
