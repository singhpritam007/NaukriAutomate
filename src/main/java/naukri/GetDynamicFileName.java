package naukri;

import java.io.File;

public class GetDynamicFileName {

public static String getFilePaths(String FileName_1, String FileName_2) {
    	
//    	FileName1 = "D:\\Others\\imp\\PRASHANT BAURAI - QA Automation Tester Resume - Latest.pdf";
//    	FileName2 = "D:\\Others\\imp\\PRASHANT BAURAI - QA Automation Tester Resume - Updated.pdf";
    	
    	File file1 = new File(FileName_1);
    	File file2 = new File(FileName_2);
    	File file3 =null;
        
    	String resumePath = "";
    	
    
    	
		try {
			  if(!file2.exists()) {
				file1.renameTo(file2);
//				System.out.println("File1 renamed => (File1 name ending with) = >"+ file2.getName().substring(48,55));
				resumePath = file2.getPath();
			    }
			
			else {
				file2.renameTo(file1);
//				System.out.println("File2 renamed => (File2 name ending with) = >"+ file1.getName().substring(48,55));
				resumePath = file1.getPath();
			   }
			
		} catch (Exception e) {

			System.out.println(e.getMessage().substring(0,(int)e.getMessage().length() ));
			
		}
		
//		System.out.println("New resume Path ==> "+resumePath.replace("\\","\\\\"));
		
		file3 = file2;
		file2 = file1;
		file1 = file3;
		file3 = null;
		
		return resumePath;
	}
}
