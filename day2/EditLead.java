package week6.day2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditLead extends ProjectSpecificMethods {

	@Test(dependsOnMethods = "week6.day1.CreateLead.Createlead")
	public void Editlead() {

		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Muthulakshmi");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Muthulakshmi")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Infosys");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String newCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println(newCompany);
		if (newCompany.contains("Infosys"))
			System.out.println("New company name is updated");
		else
			System.out.println("New company name is not updated");

	}

}
