package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 1. Launch Salesforce application https://login.salesforce.com/ 
		 * 2. Login with username as "ramkumar.ramaiah@testleaf.com " and password as "Password$123"
		 * 3. Click on Learn More link in Mobile Publisher 
		 * 4. Click confirm on Confirm redirect 5. Click Resources and mouse hover on Learning On Trailhead 6.
		 * Clilck on Salesforce Certifications 6. Click on Ceritification Administrator
		 * 7. Navigate to Certification - Administrator Overview window 8. Verify the
		 * Certifications available for Administrator Certifications should be displayed
		 * 
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// 1. Launch the url
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// 2. Enter the username and Password
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();

		// 3. click on the learn more option in the Mobile publisher
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Learn More']")));
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		// Switch to the next window using Windowhandles	
		Set<String> set = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(set);
		
		String firstWindow = listOfWindows.get(0);
		String secondWindow = listOfWindows.get(1);
		driver.switchTo().window(secondWindow);
	
		// 4. Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		Shadow dom=new Shadow(driver);

		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='hgf-button']")));
		WebElement elmt = dom.findElementByXPath("//button[@class='hgf-button']");
		elmt.click();

		// 5. Click Resources and mouse hover on Learning On Trailhead
		
		
		

	}

}
