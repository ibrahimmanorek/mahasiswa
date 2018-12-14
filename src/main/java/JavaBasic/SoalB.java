package JavaBasic;

import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.ibrahim.mahasiswa.model.Data;
import com.ibrahim.mahasiswa.model.Mahasiswa;

public class SoalB {
	
	final static String data = "Since 1995, Java has changed our world . . . and our expectations.. Today, with technology such a part of our daily lives, we take it for granted that we can be connected and access applications and content anywhere, anytime. Because of Java, we expect digital devices to be smarter, more functional, and way more entertaining. In the early 90s, extending the power of network computing to the activities of everyday life was a radical vision. In 1991, a small group of Sun engineers called the \"Green Team\" believed that the next wave in computing was the union of digital consumer devices and computers. Led by James\n" + 
			"Gosling, the team worked around the clock and created the programming language that would revolutionize our world – Java. The Green Team demonstrated their new language with an interactive, handheld home-entertainment controller that was originally targeted at the digital cable television industry. Unfortunately, the concept was much too advanced for the them at the time. But it was just right for the Internet, which was just starting to take off. In 1995, the team announced that the Netscape Navigator Internet browser would incorporate Java technology. Today, Java not only permeates the Internet, but also is the invisible force behind many of the applications and devices that power our day-to-day lives. From mobile phones to handheld devices, games and navigation systems to e-business solutions, Java is everywhere!";
	
	public void logic1() {
		String data = "Saya sedang Belajar Bahasa PemOgraman JAVA";
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
			String str = "";
	        if (Character.isUpperCase(ch)){
	        	str += ch;
	        	result += str.toLowerCase();
	        }else {
	        	str += ch;
	        	result += str.toUpperCase();
	        }
		}
		System.out.println(result);
	}
	
	public void logic2() {
		String data = "Saya sedang Belajar Bahasa PemOgraman JAVA";
		String result = "";
		for (int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);
	        if (ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o' ||
	        	ch == 'A' || ch == 'I' || ch == 'U' || ch == 'E' || ch == 'O'){
	        	
	        }else {
	        	result += ch;
	        }
		}
		
		System.out.println(result);
	}
	
	public void logic3() {
		String str = "Developer PT. Global Tiket Network";
		 // Create an array of size 256 and count of 
        // every character in it 
		int NO_OF_CHARS = 256; 
        int[] count = new int[NO_OF_CHARS]; 
       
        /* Count array with frequency of characters */
        int i; 
        for (i = 0; i < str.length(); i++) 
            if(str.charAt(i)!=' ') 
                count[(int)str.charAt(i)]++; 
        int n = i; 
        
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        HashMap<Integer, String> map2 = new HashMap<Integer, String>();
        int x = 0;
        for (i = 0; i < n; i++) {
        	
            if (count[(int)str.charAt(i)] == 1) {
            	System.out.print(str.charAt(i));
            }else {
            	if(str.charAt(i)!=' ') {
            		if(map.get(String.valueOf(str.charAt(i))) != null) {
            			map2.put(x, String.valueOf(str.charAt(i)));
            			x++;
            		}
	            	if(map.get(String.valueOf(str.charAt(i))) == null) {
	            			map.put(String.valueOf(str.charAt(i)), true);
	            			System.out.print(str.charAt(i) + ""+ count[(int)str.charAt(i)]);
	            	} 
            	}
        		
            }
        }
        System.out.println(map2.get(x-2));
       
	}
	
	interface Logic4Service{
		void eksekusiLogic4();
	}
	
	public void logic4() {
		
		Logic4Service logic4Service = () -> {
			List<String> al = new ArrayList<String>();
			
			StringTokenizer st = new StringTokenizer(data);
			while (st.hasMoreElements()) {
				String dt = (String) st.nextElement();
				String res = dt.replaceAll("[a-zA-Z0-9 ]*", "");
				if(!res.matches("[^a-zA-Z0-9]")) {
					al.add(dt.toLowerCase().trim());
				}
		    }
			
			Collections.sort(al);
			
			List<String> listUnique = al.stream().distinct().collect(Collectors.toList());
			System.out.println("Jumlah kata dari teks : "+al.size());
			System.out.println("");
			System.out.println("============================================");
			System.out.println("No Kata Total");
			for (int i = 0; i < listUnique.size(); i++) {
				int x = 0;
				for (int j = 0; j < al.size(); j++) {
					if(listUnique.get(i).matches(al.get(j))) {
						x++;
					}
				}
				System.out.println(i+" "+listUnique.get(i) + " " + x);
			}
			System.out.println("============================================");
			
			System.out.println("");
			System.out.println("============================================");
			System.out.println("No Kata Total");
			for (int i = 0; i < listUnique.size(); i++) {
				int x = 0;
				for (int j = 0; j < al.size(); j++) {
					if(listUnique.get(i).matches(al.get(j))) {
						x++;
					}
				}
				if(x == 1) {
					System.out.println(i + " " +listUnique.get(i) + " " + x);
				}
			}
			System.out.println("============================================");
			
			List<Data> list = new ArrayList<Data>();
			for (int i = 0; i < listUnique.size(); i++) {
				int x = 0;
				for (int j = 0; j < al.size(); j++) {
					if(listUnique.get(i).matches(al.get(j))) {
						x++;
					}
				}
				Data dt = new Data();
				dt.setKata(listUnique.get(i));
				dt.setTotal(x);
				list.add(dt);
			}
			
			int i = 0;
			System.out.println("");
			System.out.println("============================================");
			System.out.println("Kata Total");
			String kataTerbanyak = "";
			int totalTerbanyak = 0; 
			for (Data data : list) {
				if(data.getTotal() > i) {
					kataTerbanyak = data.getKata();
					totalTerbanyak = data.getTotal();
				}
				i++;
				
			}
			System.out.println(kataTerbanyak + " " + totalTerbanyak);
			System.out.println("============================================");
			
		};
		
		logic4Service.eksekusiLogic4();
		
	}
	
	public static void main(String args[]) {
		new SoalB().logic3();
	}

}
