package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CustomerServiceOptions {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 1. Launch Salesforce application https://login.salesforce.com/ 2. Login with
		 * Provided Credentials 3. Click on Learn More link in Mobile Publisher 4.
		 * Clilck on Products and Mousehover on Service 5. Click on Customer Services 6.
		 * Get the names Of Services Available 7. Verify the title
		 */
		
		
		// Handled browser notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 1. Launch the url
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		// 2. Login with Provided Credentials		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		
		// 3. Click on Learn More link in Mobile Publisher
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//span[text()='Learn More']"))));
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		// Switch to the next window using Windowhandles	
		Set<String> set = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<String>(set);
		String firstWindow = listOfWindows.get(0);
		String secondWindow = listOfWindows.get(1);
		driver.switchTo().window(secondWindow);
			
		// Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
			
		// 4. Clilck on Products and Mousehover on Service
		// Handled shadow root element
		Shadow sDom = new Shadow(driver);
		WebElement products = sDom.findElementByXPath("//span[text()='Products']");
		products.click();
		WebElement services = sDom.findElementByXPath("(//div[@class='nav-item-label--l2--container'])[4]");
		wait.until(ExpectedConditions.visibilityOf(services));
		Actions builder = new Actions(driver);
		builder.moveToElement(services).perform();
		
		// 5. Click on Customer Services
		WebElement customerServices = sDom.findElementByXPath("//a[text()='Customer Service']");
		customerServices.click();
		
		// 6. Get the names Of Services Available
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='page-list-item ']"));
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
		
		System.out.println(driver.getTitle());
	}

}
