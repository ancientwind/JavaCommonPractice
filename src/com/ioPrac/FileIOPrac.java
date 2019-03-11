package com.ioPrac;

import java.io.*;
import java.nio.Buffer;

import com.util.PrintUtil;

public class FileIOPrac {

	public static void main(String[] args) {

//		FileIOPrac.getDirs("./");
		
		FileIOPrac prac = new FileIOPrac();
		prac.copyFileByReader("./src/com/ioPrac/test.txt", "./src/com/ioPrac/output.txt");
	}

	//inputStream -> read bytes from source
	//Reader -> read char or String from source; Reader has readLine(), but stream hasn't
	//�� BufferedReader ��װ������ read() �������ܿ����ܸߵ� Reader���� FileReader ��InputStreamReader��
	//ʹ��BufferedReader����ָ���������Ĵ�С�����߿�ʹ��Ĭ�ϵĴ�С�����������£�Ĭ��ֵ���㹻����; ��߶�дЧ�ʡ�
	
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

	public String readFileFromClasspath(String fileName) {

		StringBuilder text = new StringBuilder();
		try(BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(fileName)))
		) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				text.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text.toString();
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
				PrintUtil.print(str);
		}
	}
}
