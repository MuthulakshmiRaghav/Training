package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) {

		/*
		 * 1) Go to https://www.nykaa.com/ 2) Mouseover on Brands and Search L'Oreal
		 * Paris 3) Click L'Oreal Paris 4) Check the title contains L'Oreal
		 * Paris(Hint-GetTitle) 5) Click sort By and select customer top rated 6) Click
		 * Category and click Hair->Click haircare->Shampoo 7) Click->Concern->Color
		 * Protection 8)check whether the Filter is applied with Shampoo 9) Click on
		 * L'Oreal Paris Colour Protect Shampoo 10) GO to the new window and select size
		 * as 175ml 11) Print the MRP of the product 12) Click on ADD to BAG 13) Go to
		 * Shopping Bag 14) Print the Grand Total amount 15) Click Proceed 16) Click on
		 * Continue as Guest 17) Check if this grand total is the same in step 14 18)
		 * Close all windows
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// 1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// 2) Mouseover on Brands and Search L'Oreal Paris
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).perform();
		
		// 3) Click L'Oreal Paris
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		builder.moveToElement(driver.findElement(By.linkText("L'Oreal Paris"))).click().perform();
			
		// 4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println(driver.getTitle());
		
		// 5) Click sort By and select customer top rated
		WebElement sortBy = driver.findElement(By.className("sort-name"));
		wait.until(ExpectedConditions.visibilityOf(sortBy)).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div")).click();
		
		// 6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.id("first-filter")).click();	
		driver.findElement(By.xpath("(//li[@class='css-1do4irw']//div)[2]")).click();
		driver.findElement(By.xpath("//div[@class='control-value']/following-sibling::div")).click();
		
		// 7) Click->Concern->Color Protection
		driver.findElement(By.xpath("(//div[@class='filter-open css-1kwl9pj'])[6]")).click();
		driver.findElement(By.xpath("//div[@class='control-value']/span[text()='Color Protection']/following::div")).click();

	}

}
