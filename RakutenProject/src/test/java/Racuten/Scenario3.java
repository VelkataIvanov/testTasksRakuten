package Racuten;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Scenario3 {
	
	private RemoteWebDriver driver;

	@Before
	
public void openBrowser() {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\QAComplete\\Selenium\\Лекции\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		driver= new FirefoxDriver();
		driver.get("https://www.rakuten.de/");
		driver.manage().window().maximize();
				
	}

	@Test
	public void openBrowserVer1() {
		
		//Option one with login through login link at the home page
		
		WebElement login= driver.findElement(By.className("tr_header_login"));
		driver.findElement(By.className("tr_header_login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement emailAddress= driver.findElement(By.name("loginEmail"));
		emailAddress.sendKeys("velkataivanov@gmail.com");
		WebElement pass= driver.findElement(By.name("loginPassword"));
		pass.sendKeys("Pass1234");
		WebElement submitButton= driver.findElement(By.name("submit"));
		driver.findElement(By.name("submit")).click();
		
	}
	
	@Test
	public void openBrowserVer2() {
		
		//Option two is to login at the web site when first is picked some product, proceed to basket and go to check out the product
		
		WebElement product= driver.findElement(By.cssSelector("div.cp-recommended div.slide:nth-of-type(8)"));
		driver.findElement(By.cssSelector("div.cp-recommended div.slide:nth-of-type(8)")).click();
		String popUp=driver.getWindowHandle();
		WebElement cardButton= driver.findElement(By.id("cardButton"));
		driver.findElement(By.id("cardButton")).click();
		
		WebElement confirmButton = new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("atc_b_tsc")));
        confirmButton.click();
		
        WebElement submitButton= driver.findElement(By.name("go_to_checkout"));
        driver.findElement(By.name("go_to_checkout")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement login= driver.findElement(By.cssSelector("div.field-container input#client_email"));
        login.sendKeys("velkataivanov@gmail.com");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("Pass1234");
        WebElement goToNextStep= driver.findElement(By.name("go_to_next_step"));
        driver.findElement(By.name("go_to_next_step")).click();
		
	}
	
	@Test
	public void openBrowserVer3() {
		
		//Option three when try to login on site through  register link at the home page
		
		WebElement Register= driver.findElement(By.className("tr_header_register"));
		driver.findElement(By.className("tr_header_register")).click();
		
		WebElement loginEmail= driver.findElement(By.name("loginEmail"));
		loginEmail.sendKeys("velkataivanov@gmail.com");
		WebElement loginPassword= driver.findElement(By.name("loginPassword"));
		loginPassword.sendKeys("Pass1234");
		
		WebElement submit= driver.findElement(By.name("submit"));
		driver.findElement(By.name("submit")).click();
	}
	
	@After
    public void tearDown() {
      driver.close();
      driver.quit();
    }
	}
	
	

