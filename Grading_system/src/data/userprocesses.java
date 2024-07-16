package data;

import java.io.File;
import java.io.FileWriter;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class userprocesses {
	
	public static boolean saveData(String name, String rollno, String section, double eng, double math, double sci, double ss, double hindi, double total, 
			double average, double percentage, char grade)
	{
		File f = new File("folder2");
		if(!f.exists())
		{
			f.mkdir();
		}
		
		File file = new File("folder2/"+ name+ rollno + ".txt");
		
		
		
		try{
			String data = "Name:" + name+"\n" +"Roll no."+rollno+"\n" +"Section:"+section + "\n" + "English:" + eng+ "\n" + "Mathematics:" + math 
					+"\n" + "Science:" + sci + "\n" + "Social Science:" + ss + "\n" + "Hindi:" + hindi + "\n" + "Total:" + total + "\n" + "Average:" + average 
					+ "\n" + "Percentage: " + percentage+ "%"+ "\n" + "Grade:" + grade;
			FileWriter fw = new FileWriter(file);
			fw.write(data);
			fw.close();
			return true;
			
			
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	
		
	}
	

}
