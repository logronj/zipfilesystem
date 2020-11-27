package iostreams;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SortedMap<String,String> map = new TreeMap<>(System.getenv());
		for(Map.Entry<String, String> m : map.entrySet()) {
		System.out.println(m.getKey()+" - "+m.getValue());
		}
	}

}
