package org.Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lumel_Demo {

    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://todomvc.com/examples/angular/dist/browser/#/all");

        // Enter the first item in todo
        WebElement enterItems = driver.findElement(By.xpath("//input[@placeholder='What needs to be done?']"));
        enterItems.sendKeys("Drink water every hour");

        Robot rc = new Robot();
        rc.keyPress(KeyEvent.VK_ENTER);
        rc.keyRelease(KeyEvent.VK_ENTER);

        // Verify the item is added
        if (isElementPresent(driver, By.xpath("//label[text()='Drink water every hour']"))) {
            System.out.println("Item is added in the list");
        } else {
            System.out.println("There is no such item");
        }

        // Enter the second item
        enterItems.sendKeys("HappyLife");
        rc.keyPress(KeyEvent.VK_ENTER);
        rc.keyRelease(KeyEvent.VK_ENTER);

        // Click on check box
        WebElement enterCheckBox = driver.findElement(By.xpath("//input[@class='toggle']"));
        enterCheckBox.click();

        Thread.sleep(3000);
//		Delete the item		
		WebElement deleteItem = driver.findElement(By.xpath("//button[@class='destroy']"));
		if (deleteItem.isDisplayed()) {
			System.out.println("crossed element is present");
		} else {
			System.out.println("No crossed element is present");
		}deleteItem.click();
		

        // Verify the item has been removed
		{
            if (isElementPresent(driver, By.xpath("//label[text()='Drink water every hour']"))) {
                System.out.println("Element is present");
            }
         else {
            System.out.println("Element is NOT present (it has been removed)");
        }

        // Click on the Active button
        driver.findElement(By.xpath("//a[text()='Active']")).click();
        // Verify the Active items present    
        if (isElementPresent(driver, By.xpath("//a[text()='Active']"))) {
            System.out.println("Active items is present");
        } else {
            System.out.println("NO Active items is present");
        }

        // Click on Complete button
        driver.findElement(By.xpath("//a[text()='Completed']")).click();
        // Verifying the Completed items is present    
        if (isElementPresent(driver, By.xpath("//a[text()='Completed']"))) {
            System.out.println("Completed items is present");
        } else {
            System.out.println("No completed items is present");
        }

        driver.close();
		}}

    // Helper method to check if an element is present
    private static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}




































