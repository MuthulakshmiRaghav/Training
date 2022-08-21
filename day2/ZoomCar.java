package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("https://zoomcar.com/in/bangalore");
		Thread.sleep(3000);

		driver.manage().window().maximize();
	/*	
		
		
		
		7) Click Continue
		8) Click Find Cars
		9) Find the price of maruti swift dzire
*/
 		//3) Click on Pickup City
		driver.findElement(By.xpath("//div[@class='placeholder']")).click();
		
	//	4) Click the fist suggested pick up location 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='pointer']")).click();
		
		//	5) Click on Calendate date
		driver.findElement(By.xpath("//span[@class='field-date start-time']")).click();
		Thread.sleep(3000);

		//6) Click on Date 19 (twice)
		driver.findElement(By.xpath("//tr/td[contains(text(),'19')]")).click();
		driver.findElement(By.xpath("//tr/td[contains(text(),'19')]")).click();

		//7) Click Continue
		driver.findElement(By.xpath("(//button[@class='button-primary'])[2]")).click();
		
		//8) Click Find Cars
		driver.findElement(By.xpath("//button[@class='button-primary']")).click();
		Thread.sleep(7000);
				
		//9) Find the price of maruti swift dzire
		String price = driver.findElement(By.xpath("(//h3[contains(text(),'Maruti Swift Dzire')]/following::div[@class='price-book-ctr']/div/div)")).getText();
		System.out.println(price);
		
		
	}

}
