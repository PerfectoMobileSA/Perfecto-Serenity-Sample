package com.perfecto.cucumber.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.perfecto.PerfectoSerenityDriver;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.google.com/ncr")
public class GooglePage extends PageObject {

    @FindBy(name = "q")
    WebElementFacade search;

    @FindBy(name = "btnK")
    WebElementFacade searchButton;
    
//    public GooglePage(WebDriver driver, int ajaxTimeout) {
//		super(driver, ajaxTimeout);
//	}

    public void searchForString(String searchString) {
        search.sendKeys(searchString);
    }

    public void submitForm() throws Exception {
       try {
    	   searchButton.click();
           Thread.sleep(5000);
	} catch (Exception e) {
		search.sendKeys(Keys.ENTER);
	}
    }

    public void titleShouldMatch(String matchTitle) {
        assertThat(this.getTitle()).containsIgnoringCase(matchTitle);
    }
}
