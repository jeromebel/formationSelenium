package com.exemples.tests.digitick;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.exemples.tests.CommonSelenium;

public class PageReserveation {
	
	WebDriver driver;
	
	public PageReserveation(WebDriver driver){
		this.driver = driver;
	}
	
	public void ajoutPlacesAuPanier(int nbrPlaces){
		selectPlaces(nbrPlaces);
		checkNoAssurance();
		clickAjoutPanier();
	}

	public void selectPlaces(int nbrPlaces){
		Select places = new Select(driver.findElement(By.className("champ")));
		List<WebElement> options = places.getOptions();
		options.get(nbrPlaces + 1).click();;
		places.selectByValue(Integer.toString(nbrPlaces));
	}
	
	public void checkNoAssurance(){
		CommonSelenium.clickById(driver, "choixAssuranceReponse1");
	}
	
	public void clickAjoutPanier(){
		CommonSelenium.clickById(driver, "submitPanier");
	}
}
