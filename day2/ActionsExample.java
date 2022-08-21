package week4.day2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsExample {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		//Scroll down to the Footer
		Actions builder = new Actions(driver);
		WebElement footer = driver.findElement(By.xpath("//a[@class='rdc-footer-links'][text()='Colombia']"));
		//builder.moveToElement(footer).perform();
		
		builder.scrollToElement(footer).perform();
		
		//Take the Screenshot
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("footer.png");
		FileUtils.copyFile(source, dest);
		
	}

}
