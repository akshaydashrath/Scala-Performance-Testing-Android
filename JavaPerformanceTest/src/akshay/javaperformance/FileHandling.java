package akshay.javaperformance;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class FileHandling {

	public static void writeList(ArrayList<RandomString> list){
		try{
			File file = new File("/sdcard/jlist.txt");
			file.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			for ( int i = 0; i < list.size()-1; i++)
				out.write(list.get(i).getNum() + "," + list.get(i).getS() + "\n");
			out.close();
		}catch (IOException e){
		System.err.println("error writing to file");	   }  
	}

	public static void writeLog(String log){
		try  
		{  
			File file = new File("/sdcard/Java.log");
			file.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(log);
			out.close();
		}  
		catch (IOException e) { System.err.println("error writing to file");	   }  
	}
}
