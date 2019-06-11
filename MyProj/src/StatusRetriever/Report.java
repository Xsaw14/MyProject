package org.tiaa.in.StatusRetriever;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Report {
	String path = new String();
	FileWriter er = null;
	
	public Report(String path) {
		// TODO Auto-generated constructor stub
		try{
			this.path = path;
			this.er = new FileWriter(new File(path));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void initializeReport(){
		try{
			er.write("<html><body><table ><tr><th>Testcase Name</th><th>Path</th><th>Status</th></tr>");
			er.write(System.lineSeparator());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void reportStatus(String testCaseName, String fileName, String filePath, String status){
		try{
			if(status.toUpperCase().equals("FAIL")){
				er.write("<tr><td>"+testCaseName+"</td><td><a href="+filePath+">"+fileName+"</a></td><td>FAIL</td>");
				er.write(System.lineSeparator());
			}else if(status.toUpperCase().equals("PASS")){
				er.write("<tr><td>"+testCaseName+"</td><td><a href="+filePath+">"+fileName+"</a></td><td>PASS</td>");
				er.write(System.lineSeparator());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void endReport(){
		try{
			er.write("</table></body></html>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
