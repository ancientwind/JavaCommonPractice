package com.serializableTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.util.PrintUtil;

public class SerialTest implements Serializable{

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
