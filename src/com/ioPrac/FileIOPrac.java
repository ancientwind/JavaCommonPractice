package com.ioPrac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.util.Util;

public class FileIOPrac {

	public static void main(String[] args) {

//		FileIOPrac.getDirs("./");
		
		FileIOPrac prac = new FileIOPrac();
		prac.copyFileByReader("./src/com/ioPrac/test.txt", "./src/com/ioPrac/output.txt");
	}

	//inputStream -> read bytes from source
	//Reader -> read char or String from source; Reader has readLine(), but stream hasn't
	//用 BufferedReader 包装所有其 read() 操作可能开销很高的 Reader（如 FileReader 和InputStreamReader）
	//使用BufferedReader可以指定缓冲区的大小，或者可使用默认的大小。大多数情况下，默认值就足够大了; 提高读写效率。
	
	public void copyFile(String input, String output) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			if(new File(input).exists())
			in = new FileInputStream(input);
			out = new FileOutputStream(output);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
		} finally {
			if( in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
	
	public void copyFileByReader(String input, String output) {
		try {
			FileReader f_reader = new FileReader(input);
			char[] buf = new char[1024];
			BufferedReader b_reader = new BufferedReader(f_reader);
			
			FileWriter f_writer = new FileWriter(output);
			BufferedWriter b_writer = new BufferedWriter(f_writer);
			
			String line;
			
			while((line = b_reader.readLine()) != null){
				b_writer.write(line);
				b_writer.newLine();
				b_writer.flush();
			}
			
			b_reader.close();
			b_writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	//mkdirs() method creates both a directory and all the parents of the directory.
	public static void createDirs(String path) {
		File d = new File(path);
		d.mkdirs();
	}
	
	public static void getDirs(String path) {
		File d = new File(path);
		if(d.isDirectory()) {
			String [] paths;
			
			paths = d.list();
			
			for (String str:paths)
				Util.print(str);
		}
	}
}
