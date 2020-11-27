package trywithresource;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Helper {
	
	public static void readFile(String filePath) {
		
		try{
			File file = new File(filePath);
			Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			String data = scanner.nextLine();
			System.out.println(data);
			}
		scanner.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
