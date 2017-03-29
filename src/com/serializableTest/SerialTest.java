package com.serializableTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.util.PrintUtil;

public class SerialTest implements Serializable{

	/**
	 * 将需要序列化的类实现Serializable接口就可以了，
	 * Serializable接口中没有任何方法，可以理解为一个标记，即表明这个类可以序列化。
	 * 
	 * 序列化 ID 在 Eclipse 下提供了两种生成策略，一个是固定的 1L，一个是随机生成一个不重复的 long 类型数据（实际上是使用 JDK 工具生成），
	 * 在这里有一个建议，如果没有特殊需求，就是用默认的 1L 就可以，这样可以确保代码一致时反序列化成功。
	 */
	private static final long serialVersionUID = 1L;

	private String name = "SERIALIZABLE";
	static int age = 30;
	public String company;
	static String nation;
	transient  String address;
	static transient String companyCEO;
	
	public SerialTest(){}
	
	public SerialTest(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString(){
		return "SerialTest : name = " + this.name + " & age = " + this.age
				+ " company = " + this.company
				+ " nation = " + this.nation
				+ " address = " + this.address
				+ " companyCEO = " + this.companyCEO;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	/**
	 * this method will generate a my.out file under project folder
	 */
	public static void toSerial(){

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("my.out"));
			SerialTest test = new SerialTest();
			test.company = "GE";
			test.nation = "USA";
			test.address = "MKE";
			test.companyCEO = "Jeff";
			oos.writeObject(test);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deSerial(){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("my.out"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SerialTest test = null;
		try {
			test = (SerialTest) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintUtil.print(test.nation);
		PrintUtil.print(test.toString());
	}
	
	public static void main(String[] args) {

		SerialTest.toSerial();
		SerialTest.deSerial();
	}
	
	

}
