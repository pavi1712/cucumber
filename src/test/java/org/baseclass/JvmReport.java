package org.baseclass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class JvmReport {
	
	public static void generateJvmReport(String jsonpath) { 
		
		//1.To fetch the JVMReport path
		File f=new File("C:\\Users\\USER\\Desktop\\WS\\Cucumber\\AllReport\\JVMReport");
		
		//2.To add the details for report generation
		Configuration c = new Configuration(f,"FACEBOOK APPLICATION");
		
		c.addClassifications("Windows", "10");
		c.addClassifications("JDK", "1.7");
		c.addClassifications("Tools", "eclipse Photon");
		
		//3.To add the json file path into list
		List l=new ArrayList<>();
		l.add(jsonpath);
		
		//4.To create object for ReportBuilder class and call generateReport
		ReportBuilder r=new ReportBuilder(l,c);
		r.generateReports();

	}

}
