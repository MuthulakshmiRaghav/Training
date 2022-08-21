package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Enter username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on leads button
		driver.findElement(By.linkText("Leads")).click();

		// Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();

		// Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Babu");

		// Click Find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		// Click on first resulting lead
		WebElement elmt = driver.findElement(By.xpath("//td//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a"));		
		try
		{
			elmt.click();
			System.out.println(driver.getTitle());
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Exception Handled");
			wait.until(ExpectedConditions.elementToBeClickable(elmt));
			elmt.click();
		}
	}

}
