package org.tiaa.in.StatusRetriever;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.model.SystemProperties;

import cucumber.api.java.After;
import freemarker.template.SimpleDate;

public class Main {

	static WebDriver driver;
	static String reportPath = "F:/BDD Reorts/"+"Report_"+ new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date())+".html";
	static Report report = new Report(reportPath);
	GetFileName getfilename = new GetFileName();
	
	@Before
	public void launchTheBrowser(){
		this.driver = new FirefoxDriver();
		report.initializeReport();
	}
	
	@Test
	public void checkStatus(){
		try{
			String extentReportPath = "C:/Users/selvavi/git/TIAA_Common_Cucumber_Framework/dryRunResults/org/tiaa/in/dryRunReports/SLU";
			LinkedList<String> pathList = getfilename.getFileNames(extentReportPath);
			CheckStatus checkStatus = new CheckStatus(driver);
			for(int i=0;i<pathList.size();i++){
				String currentFileName = extentReportPath+"/"+pathList.get(i);
				if(pathList.get(i).equals("Passed Scenarios 04, 05, 06, 07, 09, 23,  Common_Cucumber_framework11-03-2019_074240.html"))
					System.out.println();
				driver.get("file://"+currentFileName);
				report.reportStatus(checkStatus.returnTestcaseName(), pathList.get(i), currentFileName, checkStatus.verifyStatusOfReport());
			}
		}catch(Exception e){
			e.printStackTrace();
			driver.quit();
		}
	}
	
	@AfterClass
	public static void closeTheBrowser(){
		driver.quit();
		report.endReport();
	}
}
