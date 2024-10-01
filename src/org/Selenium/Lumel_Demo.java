package org.Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Lumel_Demo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://todomvc.com/examples/angular/dist/browser/#/all");
//		Enter the items in todo 
		WebElement enterItems = driver.findElement(By.xpath("//input[@placeholder=\"What needs to be done?\"]"));
		enterItems.sendKeys("Drink water every hour");	
		
		
		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement enterItems2 = driver.findElement(By.xpath("//input[@placeholder=\"What needs to be done?\"]"));
		enterItems2.sendKeys("HappyLife");
		
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
		
//		Click on check box
		WebElement enterCheckBox = driver.findElement(By.xpath("//input[@class=\"toggle\"]"));
		enterCheckBox.click();	
		
		Thread.sleep(3000);
//		Delete the item		
		WebElement deleteItem = driver.findElement(By.xpath("//button[@class='destroy']"));
		deleteItem.click();	
		
//		verifying the Active button
		WebElement Active_Button = driver.findElement(By.xpath("//a[text()='Active']"));
		Active_Button.click();
		Active_Button.isEnabled();
//		Verifying the Complete items is present
		WebElement verify_Complete_Button = driver.findElement(By.xpath("//a[text()='Completed']"));
		verify_Complete_Button.click();
		verify_Complete_Button.isEnabled();
		System.out.println("CompletedItems");
		
		
	
		
	}	

	
}
