package d2014_3.q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		List<String> list = new ArrayList<String>();
//		list.add("a123");
//		list.add("d0");
//		list.add("b-1");
//        Collections.sort(list);
//        //list.get(index);
//        for(String a: list) {
//        	System.out.println(a);
//        }
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		map.put('c', 1);
		map.put('a', 2);
		map.put('b', 3);
		
		for(Character c: map.keySet()){
			System.out.println(c);
		}
		
		System.out.print(map.size());
	}

}
