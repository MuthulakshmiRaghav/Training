package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); // launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main"); // load the Url
		driver.manage().window().maximize(); // maximize the browser

		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// verify the page
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attr = logout.getAttribute("value");

		if (attr.equals("Logout"))
			System.out.println("Successfully logged in");

		// click CRM/SFA link

		driver.findElement(By.linkText("CRM/SFA")).click();

		// click Leads link

		driver.findElement(By.linkText("Leads")).click();

		// click Create Lead link
		driver.findElement(By.linkText("Create Lead")).click();

		// Give inputs for Companyname, Firstname and Lastname

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Perficient");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Muthulakshmi");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Raghav");

		// dropdown
		WebElement sourceDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select select = new Select(sourceDropdown);
		select.selectByVisibleText("Employee");

		driver.findElement(By.className("smallSubmit")).click();

		// Verify the Lead page title
		driver.findElement(By.id("sectionHeaderTitle_leads")).isDisplayed();
		String title = driver.getTitle();
		System.out.println(title);

	}

}
