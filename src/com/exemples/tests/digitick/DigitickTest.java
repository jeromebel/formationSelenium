package com.exemples.tests.digitick;

import static org.junit.Assert.*;

import org.junit.Test;

import com.exemples.tests.CommonSelenium;

public class DigitickTest extends CommonSelenium{
	
	private String baseUrl = "http://www.digitick.com/";

	  @Test
	  public void testDigitick() throws Exception {
	    driver.get(baseUrl + "/#/");
	    try {
	      PageAccueil pageAccueil = new PageAccueil(driver);
	      pageAccueil.recherche("moodoid");
	      //assertFalse(pageAccueil.verifyPanier(0));
	      PageResultat pageResultat = new PageResultat(driver);
	      if(pageResultat.hasResult()){
	    	  pageResultat.clickReserver(0);
	      } else {
	    	  System.out.println("No result!");
	    	  assertTrue(false);
	      }
	      PageReserveation pageReserveation = new PageReserveation(driver);
	      pageReserveation.ajoutPlacesAuPanier(4);
	      assertTrue(pageAccueil.verifyPanier(4));
	      
	    } catch (Error e) {	    	
	      verificationErrors.append(e.toString());
	    }
	  }

}
