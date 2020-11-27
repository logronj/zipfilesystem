package bufferedreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BMain {
	public static void main(String[] args) {
//		doReadLineBR();
		doReadAllLinesBR();
	}

	private static void doReadLineBR() {
		// TODO Auto-generated method stub
		try(BufferedReader br = Files.newBufferedReader(Paths.get("filename.txt"))){
			String inValue;
			while((inValue = br.readLine())!=null) {
				System.out.println(inValue);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getClass().getSimpleName()+"-"+e.getMessage());
		}
	}
	
	private static void doReadAllLinesBR() {
		// TODO Auto-generated method stub
		try{
			List<String> lines = Files.readAllLines(Paths.get("filename.txt"));
			for (String string : lines) System.out.println(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
