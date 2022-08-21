package week6.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataCreateLead extends ProjectSpecificMethods {

	@DataProvider(name = "create")
	public String[][] getData() throws IOException {
		
		String[][] data = ReadData.readExcelData("CreateLead");
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
