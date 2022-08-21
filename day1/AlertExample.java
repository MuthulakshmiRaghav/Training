package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();

		// Click Prompt Box
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();

		// Switch to Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Get the text
		String text = driver.findElement(By.id("result1")).getText();
		System.out.println(text);

	}

}
