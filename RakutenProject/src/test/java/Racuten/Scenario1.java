package Racuten;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Scenario1 {

    private static WebDriver driver;

    @Before
    public void openBrowser() {
    	
    	
    	
        driver = new FirefoxDriver();
        driver.get("https://www.rakuten.de/");
        driver.manage().window().maximize();
        
        
       	  String popUpBegin=driver.getWindowHandle();
		  WebElement popUpButtonBegin= driver.findElement(By.id("consent_prompt_submit"));
		  driver.findElement(By.id("consent_prompt_submit")).click();
        
    }
    
 	@Test
    public void Scenario1()
    {
 		
 		
 		WebElement homePage= driver.findElement(By.id("search-input"));
 		homePage.sendKeys("mobile");
 		WebElement searchButton= driver.findElement(By.xpath("//button[@class='button-search']"));
 		driver.findElement(By.xpath("//button[@class='button-search']")).click();
 		WebElement selectList= driver.findElement(By.xpath("//a[@href='/produkt/stativleinwand-203-x-203-cm-bilddiagonale-ca-113-bzw-289-cm-mobile-beamer-leinwand-i-1895797099']"));
 		driver.findElement(By.xpath("//a[@href='/produkt/stativleinwand-203-x-203-cm-bilddiagonale-ca-113-bzw-289-cm-mobile-beamer-leinwand-i-1895797099']")).click();
 		WebElement message= driver.findElement(By.cssSelector("h2.title"));
 		String messageText = message.getText();
 		assertEquals("Produktbeschreibung", messageText);
 		
    }

	@After
    public void tearDown() {
      driver.close();
      driver.quit();
    }
}