package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

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

	}

}
