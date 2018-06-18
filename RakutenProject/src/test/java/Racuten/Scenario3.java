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
		
		
		
		driver= new FirefoxDriver();
		driver.get("https://www.rakuten.de/");
		driver.manage().window().maximize();
		
		String popUpBegin=driver.getWindowHandle();
		WebElement popUpButtonBegin= driver.findElement(By.id("consent_prompt_submit"));
		driver.findElement(By.id("consent_prompt_submit")).click();
				
	}

	@Test
	public void openBrowserVer1() {
		
		//Option one with login through login link at the home page
		
		WebElement login= driver.findElement(By.xpath("//a[@href='/kundenkonto']"));
		driver.findElement(By.xpath("//a[@href='/kundenkonto']")).click();
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
		
		WebElement product= driver.findElement(By.xpath("//a[@href='/produkt/bosch-professional-akkuschrauber-gsr-mx2drive-professional-bohrschrauber-blauschwarz-karton-2020151615']"));
		driver.findElement(By.xpath("//a[@href='/produkt/bosch-professional-akkuschrauber-gsr-mx2drive-professional-bohrschrauber-blauschwarz-karton-2020151615']")).click();
		
		WebElement cardButton= driver.findElement(By.xpath("//a[@class='button add-cart -red']"));
		driver.findElement(By.xpath("//a[@class='button add-cart -red']")).click();
		
		String popUp=driver.getWindowHandle();
		WebElement popUpButton= driver.findElement(By.xpath("//a[@href='/shopcart']"));
		driver.findElement(By.xpath("//a[@href='/shopcart']")).click();
		
		WebElement message= driver.findElement(By.cssSelector("div#sidebar h2"));
		String messageText= message.getText();
		assertEquals("Bestellübersicht", messageText);
		WebElement submitButton= driver.findElement(By.name("go_to_checkout"));
        driver.findElement(By.name("go_to_checkout")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement login= driver.findElement(By.name("username"));
        login.sendKeys("velkataivanov@gmail.com");
        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("Pass1234");
        WebElement goToNextStep= driver.findElement(By.name("go_to_next_step"));
        driver.findElement(By.name("go_to_next_step")).click();
		
	}
	
	@Test
	public void openBrowserVer3() {
		
		//Option three when try to login on site through  register link at the home page
		
		WebElement Register= driver.findElement(By.xpath("//a[@href='https://www.rakuten.de/kundenkonto']"));
		driver.findElement(By.xpath("//a[@href='https://www.rakuten.de/kundenkonto']")).click();
		
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
	
	

