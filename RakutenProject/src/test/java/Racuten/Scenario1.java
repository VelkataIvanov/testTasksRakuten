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
    	
    	//System.setProperty("webdriver.chrome.driver", "D:\\QAComplete\\Selenium\\Лекции\\chromedriver.exe");
		//driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.get("https://www.rakuten.de/");
        driver.manage().window().maximize();
    }
    
 	@Test
    public void Scenario1()
    {
 		WebElement homePage= driver.findElement(By.id("q"));
 		homePage.sendKeys("mobile");
 		WebElement searchButton= driver.findElement(By.className("b-sprite-icon-search"));
 		driver.findElement(By.className("b-sprite-icon-search")).click();
 		WebElement selectList= driver.findElement(By.id("p-amount_2442"));
 		driver.findElement(By.id("p-amount_2442")).click();
 		WebElement message= driver.findElement(By.id("filter-open"));
 		String messageText = message.getText();
 		assertEquals("Artikel filtern", messageText);
 		
    }

	@After
    public void tearDown() {
      driver.close();
      driver.quit();
    }
}