package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 1. Launch https://www.snapdeal.com/ 2. Go to Mens Fashion 3. Go to Sports
		 * Shoes 4. Get the count of the sports shoes 5. Click Training shoes 6. Sort by
		 * Low to High 7. Check if the items displayed are sorted correctly 8.Select the
		 * price range (900-1200) 9.Filter with color Navy 10 verify the all applied
		 * filters 11. Mouse Hover on first resulting Training shoes 12. click QuickView
		 * button 13. Print the cost and the discount percentage 14. Take the snapshot
		 * of the shoes. 15. Close the current window 16. Close the main window
		 */
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// 1. Launch the Url
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.id("pushDenied")).click();
		
		// 2. Go to Mens Fashion
		Actions builder = new Actions(driver);
		WebElement mensFashion = driver.findElement(By.xpath("//span[@class='catText']"));
		wait.until(ExpectedConditions.elementToBeClickable(mensFashion));
		builder.moveToElement(mensFashion).perform();
		
		// 3. Go to Sport Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();

		// 4. Get the count of the sports shoes
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='child-cat-count '])[2]")));
		String shoesCount = driver.findElement(By.xpath("(//div[@class='child-cat-count '])[2]")).getText();
		System.out.println(shoesCount);

		// 5. Click Training shoes
		WebElement trainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		wait.until(ExpectedConditions.elementToBeClickable(trainingShoes)).click();

		// 6. Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("//li[@class='search-li']")).click();
		
		/*// Check if the items displayed are sorted correctly
		List<WebElement> elmts = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int noOfElements = elmts.size();
		String str = elmts.get(0).getText();
		System.out.println(str);
		
		*/
		
		
		// Select the price range (900-1200)
		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("1200");
		
		// Click GO button
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();

		/*// Filter with color Navy
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		*/
		
		
		// Mouse Hover on first resulting Training shoes
		WebElement firstResult = driver.findElement(By.xpath("//img[@title='TUFF 5005 SPRINT 01 Red Training Shoes']"));
		builder.moveToElement(firstResult).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'center quick-view-bar')]")));
		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
		
		// Print the cost and the discount percentage
		System.out.println("Price is: " + driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span")).getText());
		System.out.println("Discount Percentange is: " + driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']/span[2]")).getText());
	
	}

}
