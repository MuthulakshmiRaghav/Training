package week6.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethods {

	@DataProvider(name = "create")
	public String[][] getData() {
		String[][] data = new String[2][7];

		data[0][0] = "Perficient";
		data[0][1] = "Muthulakshmi";
		data[0][2] = "Raghav";
		data[0][3] = "Muthu";
		data[0][4] = "QA";
		data[0][5] = "Automation Tester";
		data[0][6] = "sai@gmail.com";
		
		data[1][0] = "Infosys";
		data[1][1] = "Mahiya";
		data[1][2] = "Raghav";
		data[1][3] = "mahi";
		data[1][4] = "Java";
		data[1][5] = "Dev";
		data[1][6] = "mahi@gmail.com";

		return data;
	}

	@Test(dataProvider = "create")
	public void Createlead(String cmpName, String firstName, String lastName, String firstNameLocal , String deptName, String desc, String email) {

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cmpName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(firstNameLocal);
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(deptName);
		driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);

		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.id("sectionHeaderTitle_leads")).isDisplayed();
		String title = driver.getTitle();
		System.out.println(title);

	}

}
