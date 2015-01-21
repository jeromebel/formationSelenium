package com.exemples.tests.digitick;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.exemples.tests.CommonSelenium;

public class PageResultat {
	
	private WebDriver driver;

	public PageResultat (WebDriver driver){
		this.driver = driver;
	}

	public boolean hasResult() {
		return CommonSelenium.isElementPresent(driver, By.id("resultatEvenement"));
	}
	
	public void clickReserver(int numTicket){
		WebElement ticketElement = driver.findElement(By.id("fest"+numTicket));
		ticketElement.findElement(By.className("accueilimagebillet")).click();		
	}
	
	
}
