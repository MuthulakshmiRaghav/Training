package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsWindowHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		// Enter username and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on leads button
		driver.findElement(By.linkText("Leads")).click();

		// Click Merge Leads Link
		driver.findElement(By.linkText("Merge Leads")).click();

		// Click the icon following the from lead
		driver.findElement(By.xpath("(//span[@class='requiredField'])[1]/following::a")).click();

		// Switch to new window
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> listOfWindow = new ArrayList<String>(windowHandles);
		String secondWindow = listOfWindow.get(1);

		driver.switchTo().window(secondWindow);

		driver.findElement(By.name("firstName")).sendKeys("Muthulakshmi");

		// Click Find Leads Button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		// Click on the first resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();

		// Move the control back to first window
		driver.switchTo().window(listOfWindow.get(0));
		System.out.println(driver.getTitle());
	}

}
