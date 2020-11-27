package trywithresource;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		doTryWithResource();
		doCloseThing();
	}
	

	public static void doTryWithResource() {
		char[] buff = new char[8];
		int length;
		try (FileReader reader = new FileReader("filename.txt");
			 FileWriter writer = new FileWriter("filename2.txt")){
			while((length = reader.read(buff)) >= 0) {
				System.out.println(length);
				System.out.print(buff);
				writer.write(buff, 0, length);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void doCloseThing() {
		try(MyAutoCloseable mine = new MyAutoCloseable();){
			mine.saySomething();
		}catch (Exception e) {
			System.out.println(e.getClass().getSimpleName()+"-"+e.getMessage());
			for(Throwable t : e.getSuppressed())
				System.out.println(t.getMessage());
		}
	}

}
