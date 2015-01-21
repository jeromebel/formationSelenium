package com.exemples.tests.digitick;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.exemples.tests.CommonSelenium;
import com.thoughtworks.selenium.SeleniumException;

public class PageAccueil {
	
	private WebDriver driver;
	
	public PageAccueil(WebDriver driver){
		this.driver = driver;
	}
	
	public void recherche(String recherche){
		fillRecherche(recherche);
		clickOK();
	}
	
	public void fillRecherche(String recherche){
		WebElement champsRecherche = driver.findElement(By.id("rechercheChamp"));
		champsRecherche.clear();
		champsRecherche.sendKeys(recherche);
	}
	
	public void clickOK(){
		CommonSelenium.clickById(driver, "rechercheValider");
	}
	
	public boolean verifyPanier(int nbrPlaces){
		try{
			WebElement panier = driver.findElement(By.id("resumePanier"));
			if(nbrPlaces == 1){
				return "1 PLACE".equals(panier.getText());
			} else if(nbrPlaces > 1){
				return (nbrPlaces + " PLACES").equals(panier.getText());
			}else {
				return false;
			}
			
		} catch(NoSuchElementException e){
			return false;
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	

}
