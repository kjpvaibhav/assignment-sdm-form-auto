package com.cdac;

import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class assignment 
{
	public static void main(String args[])
	{
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\Vaibh\\eclipse-workspace\\testwithmaven\\site\\index.html");
		try 
		{
			Thread.sleep(5000);
			driver.manage().window().maximize();
			
			Thread.sleep(5000);
			String name = "Vaibhav";
			driver.findElement(By.id("name-textbox")).sendKeys(name);
			System.out.println("Entered Name is "+name);
		
			Thread.sleep(5000);
			List<WebElement> genderList = driver.findElements(By.className("gender-radio-btn"));
			System.out.println("Number of Genders Available: "+ genderList.size());
			
			String gender = "male";
			WebElement maleRadio = driver.findElement(By.cssSelector("input[type='radio'][value='"+gender+"']"));
			maleRadio.click();
			System.out.println("Selected Gender is "+gender);
			
			Thread.sleep(5000);
			List<WebElement> eduQulList = driver.findElements(By.tagName("option"));
			System.out.println("Number of Education Qualifications Available: "+ eduQulList.size());
			
			Thread.sleep(5000);
			String eduQual = "PGD";
			WebElement eduDropDown = driver.findElement(By.className("edu-dropdown"));
			Select selectEduQual = new Select(eduDropDown);
			selectEduQual.selectByVisibleText(eduQual);
			System.out.println("Selected Education Qualification is "+eduQual);
			
			Thread.sleep(5000);
			driver.findElement(By.className("submit-btn")).click();
			
			Thread.sleep(5000);
			WebElement submitConfirmation = driver.findElement(By.id("success-h1"));
			if (submitConfirmation.getText().equals("Submitted Successfully"))
				System.out.println("Form submitted Succesfully");
			else
				System.out.println("Form wasn't submitted");
			
			Thread.sleep(5000);
		} 
		 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			driver.quit();
		}
	}
}