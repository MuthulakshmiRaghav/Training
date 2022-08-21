package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the url
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		// SwitchTo Frame
		driver.switchTo().frame(0);

		// Get text before drag and drop
		System.out.println(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText());

		// Drag and Drop the box
		WebElement drag = driver.findElement(By.id("draggable"));

		Actions builder = new Actions(driver);
		builder.dragAndDropBy(drag, 150, 60).perform();
		System.out.println(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText());

	}

}
