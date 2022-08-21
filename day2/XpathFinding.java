package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathFinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		/*
	1. 	Go to find leads screen
		a) Find the xpath for first name text box using the label
		b) Find the xpath for the first matching result lead
		*/
		
		//Go to Findleads
		driver.findElement(By.xpath("//a[text()='Find Leads']"));
		
		//a
		driver.findElement(By.xpath("(//label[text()='First name:']//following::input[@name='firstName'])[3]"));
		
		//b
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
	
		
				
		
		
	}

}
