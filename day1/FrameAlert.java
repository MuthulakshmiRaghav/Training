package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();

		// Click TryIt
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		// Click Cancel on the alert
		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		// Print the resulting text
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
	}

}
