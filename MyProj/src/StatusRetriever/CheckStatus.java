package org.tiaa.in.StatusRetriever;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckStatus {
	
	@FindBy(xpath = "//*[@id='test-collection']/li/div[1]/span[2]")
	WebElement statusXpath;
	
	@FindBy(xpath = "//*[@id='test-details-wrapper']/div/div/h5")
	WebElement testCaseName;
	
	WebDriver driver = null;
	public CheckStatus(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyStatusOfReport(){
		try{
			String status = statusXpath.getText();
			if(status.toUpperCase().equals("PASS")){
				return "PASS";
			}else if(status.toUpperCase().equals("FAIL")){
				return "FAIL";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String returnTestcaseName(){
		try{
			return testCaseName.getText();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
