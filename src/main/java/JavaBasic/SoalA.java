package JavaBasic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.ibrahim.mahasiswa.model.Mahasiswa;

public class SoalA {
	
	public void mahasiswa() {
		try {
			String home = System.getProperty("user.home");
			File path = new File(home + File.separator + "Desktop" + File.separator + 
					"mahasiswa.nilai.txt");
			
            FileWriter fileWriter = new FileWriter(path, true);
            PrintWriter writer = new PrintWriter(fileWriter);
            
			BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
			
			System.out.println("Masukkan Jumlah Mahasiswa : ");
			int jmlMhs = Integer.parseInt(inp.readLine());
			
			String nim="", nama="", grade="";
			double nilaiMid=0 , nilaiUas=0, nilaiHadir=0;
			int mhsLulus=0,mhsTdkLulus=0;
			List<Mahasiswa> list = new ArrayList<Mahasiswa>();
			
			for (int i = 0; i < jmlMhs; i++) {
				System.out.println("Masukkan NIM : ");
				nim = inp.readLine();
				
				System.out.println("Masukkan NAMA : ");
				nama = inp.readLine();
				
				System.out.println("Masukkan NILAI_KEHADIRAN : ");
				nilaiHadir = Integer.parseInt(inp.readLine());
				
				System.out.println("Masukkan NILAI_MID : ");
				nilaiMid = Integer.parseInt(inp.readLine());
				
				System.out.println("Masukkan NILAI_UAS : ");
				nilaiUas = Integer.parseInt(inp.readLine());
				
				double nilaiAkhir = (0.2d*nilaiHadir)+(0.4d*nilaiMid)+(0.4d*nilaiUas);
				if(nilaiAkhir >= 0 && nilaiAkhir <= 45) {
					grade = "E";
					mhsTdkLulus++;
				}else if(nilaiAkhir >= 46 && nilaiAkhir <= 60) {
					grade = "D";
					mhsTdkLulus++;
				}else if(nilaiAkhir >= 61 && nilaiAkhir <= 75) {
					grade = "C";
					mhsLulus++;
				}else if(nilaiAkhir >= 76 && nilaiAkhir <= 84) {
					grade = "B";
					mhsLulus++;
				}else {
					grade = "A";
					mhsLulus++;
				}
				
			    Mahasiswa mhs = new Mahasiswa();
			    mhs.setNim(nim);
			    mhs.setNama(nama);
			    mhs.setNilaiAkhir((int) nilaiAkhir);
			    mhs.setGrade(grade);
			    list.add(mhs);
			}
			
			writer.println("No NIM NAMA NILAI_AKHIR GRADE");
			writer.println("========================================");
		    int i=1;
		    for (Mahasiswa mahasiswa : list) {
		    	writer.println(i + " "+ mahasiswa.getNim() + " " + mahasiswa.getNama() 
		    			+ " " + mahasiswa.getNilaiAkhir() + " " + mahasiswa.getGrade());
		    i++;
		    }		    
		    writer.println("========================================");
		    writer.println("Jumlah Mahasiswa : "+list.size());
		    writer.println("Jumlah Mahasiswa yang lulus : "+mhsLulus);
		    writer.println("Jumlah Mahasiswa yang tidak lulus : "+mhsTdkLulus);
		    writer.println("========================================");
		    
			System.out.println("No NIM NAMA NILAI_AKHIR GRADE");
			System.out.println("========================================");
			for (Mahasiswa mahasiswa : list) {
		    	System.out.println(i + " "+ mahasiswa.getNim() + " " + mahasiswa.getNama() 
    			+ " " + mahasiswa.getNilaiAkhir() + " " + mahasiswa.getGrade());
		    i++;
		    }	
		    System.out.println("========================================");
		    System.out.println("Jumlah Mahasiswa : "+list.size());
		    System.out.println("Jumlah Mahasiswa yang lulus : "+mhsLulus);
		    System.out.println("Jumlah Mahasiswa yang tidak lulus : "+mhsTdkLulus);
		    System.out.println("========================================");
		    
		    writer.close();
		    
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
