import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Task {
	static private final String comment = "[COMMENT]\n";
	static private final String header = "[HEADER]\nEXT=MAX\nTYPE=STANDARD\n"; 
	static private final String variables = "[VARIABLES]\n";
	static private final String INT = ":INT";
	static private final String constraints = "[CONSTRAINTS]\n";
	static private final String goal = "[GOAL]\n";
	
	 String enterFileName(){
		 String fileName = "";
		 BufferedReader name = new BufferedReader(new InputStreamReader(System.in));
		 try {
			fileName = name.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 if (fileName.equals("")){
			 System.out.println("Invalid input");
			 System.exit(-1);
		 }
		 return fileName;
	}
	 
	 String enterFileOriginName(){
		 System.out.println("Enter file name\n(your file must been in 'files' directory):");
		 return enterFileName();
	 }
	 
	 String enterFileFinallName(){
		 System.out.println("Enter finall file name\n(your file will been in 'files' directory):");
		 return enterFileName();
	 }
	 
	 Path pathToFile(String fileName){
		 String[] filename = {"files", fileName};
		 Path pathtoFile = Paths.get(System.getProperty("user.dir"), filename); 
		 return pathtoFile;
	 }
	 
	 String customFileReader(Path pathToFile){
		 String text = "";
		 String tmp = "";
		 BufferedReader file = null;
		 try {
			file = Files.newBufferedReader(pathToFile, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 try {
			while ((tmp = file.readLine()) != null){
				text += tmp + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return text;
	 }
	 
	 void customFileWriter(String text, String fileName){
		 String[] filename = {"files", fileName};
		 OpenOption[] options = new OpenOption[] {StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE};

		 try(BufferedWriter file = Files.newBufferedWriter(Paths.get(System.getProperty("user.dir"), filename), Charset.defaultCharset(), options)){
			 String[] listStr = text.split("\n");
			 file.write(comment);
			 file.write("LinalProgrammingTask\n");
			 file.write(header);
			 file.write(variables);
			 for (int i = 1; i <= Integer.valueOf(listStr[0]).intValue(); i++){//variables
				 file.write("X"+i+INT+"\n");
			 }
			 file.write(constraints);
			 for (int y = 1; y <= Integer.valueOf(listStr[1]).intValue(); y++){//constraints
				 for (int i = 1; i <= Integer.valueOf(listStr[0]).intValue(); i++){//variables
					 int k = Integer.valueOf(listStr[2+y].split(" ")[i-1]).intValue();
					 String lastSymbol = "";
					 if (i != Integer.valueOf(listStr[0]).intValue()){
						 lastSymbol = "+";
					 } else {
						 lastSymbol = "=";
					 }
					 if (k != 1){
						 file.write(k+"*X"+i+lastSymbol);
					 } else if (k == 1){
						 file.write("X"+i+lastSymbol);
					 }
				 }
				 file.write(listStr[2+y].split(" ")[listStr[2+y].split(" ").length-1]);
				 file.write("\n");
			 }
			 file.write(goal);
			 for (int i = 1; i <= Integer.valueOf(listStr[0]).intValue(); i++){//variables
				 int k = Integer.valueOf(listStr[2].split(" ")[i-1]).intValue();
				 String lastSymbol = "";
				 if (i != Integer.valueOf(listStr[0]).intValue()){
					 lastSymbol = "+";
				 }
				 if (k != 1){
					 file.write(k+"*X"+i+lastSymbol);
				 } else if (k == 1){
					 file.write("X"+i+lastSymbol);
				 }
			 }
		 } catch (IOException e){
			 e.printStackTrace();
		 }
	 }
}
