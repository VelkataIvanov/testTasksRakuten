package Racuten;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 {
	
	private static WebDriver driver;
	
	@Before
	
	public void openBrowser() {
		
		//System.setProperty("webdriver.chrome.driver", "D:\\QAComplete\\Selenium\\Лекции\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		driver= new FirefoxDriver();
		driver.get("https://www.rakuten.de/");
		driver.manage().window().maximize();
				
	}

	@Test
	public void Scenario2() {
		
		//For this task I decide to write two version for execution:
		//First one is with direct login into the web site/this variant is comment at the moment/
		//Second one is first to be chosen product and proceed further
		
		//WebElement login= driver.findElement(By.className("tr_header_login"));
		//driver.findElement(By.className("tr_header_login")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebElement emailAddress= driver.findElement(By.name("loginEmail"));
		//emailAddress.sendKeys("velkataivanov@gmail.com");
		//WebElement pass= driver.findElement(By.name("loginPassword"));
		//pass.sendKeys("Pass1234");
		//WebElement submitButton= driver.findElement(By.name("submit"));
		//driver.findElement(By.name("submit")).click();
		//WebElement account=driver.findElement(By.cssSelector("#undefined-sticky-wrapper > div > div > div > div:nth-child(3) > div > ul > li.b-dropdown.b-account-info.tr_header_account_name > a > b:nth-child(3)"));
		//String messageText= account.getText();
		//assertEquals("Velkata", messageText);
		
		//WebElement homePage= driver.findElement(By.cssSelector("#undefined-sticky-wrapper > div > div > div > div.b-nav-category > div > a"));
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElement(By.cssSelector("#undefined-sticky-wrapper > div > div > div > div.b-nav-category > div > a")).click();
		
		//From here I want to locate some product from home page
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//WebElement product= driver.findElement(By.xpath("//div[@class='cp-recommended']//descendant::div[@class='slider-button-small']//div[@class='bx-wrapper multiple-slides']//descendant::div[contains(@class,'multiple-slides')]//descendant::div[contains(@class,'slide')]//descendant::article[@class='product']//a[@href='//www.rakuten.de/produkt/dyson-v7-motorhead-pro-2019382190.html?icid=DE_mkt:de:home_recommended_1_product_1_2019382190_nocampaign?portaldv=6']//descendant::div[@class='product-image-wrap']//descendant::div[@class='fix-vert']//descendant::img[@title='Dyson V7 Motorhead Pro']"));
		//driver.findElement(By.xpath("//div[@class='cp-recommended']//descendant::div[@class='slider-button-small']//div[@class='bx-wrapper multiple-slides']//descendant::div[contains(@class,'multiple-slides')]//descendant::div[contains(@class,'slide')]//descendant::article[@class='product']//a[@href='//www.rakuten.de/produkt/dyson-v7-motorhead-pro-2019382190.html?icid=DE_mkt:de:home_recommended_1_product_1_2019382190_nocampaign?portaldv=6']//descendant::div[@class='product-image-wrap']//descendant::div[@class='fix-vert']//descendant::img[@title='Dyson V7 Motorhead Pro']")).click();
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
        
        Select dropGender= new Select(driver.findElement(By.id("gender")));
        dropGender.selectByVisibleText("Herr");
        
        WebElement firstName= driver.findElement(By.id("first-name"));
        firstName.sendKeys("Velkata");
        WebElement lastName= driver.findElement(By.id("last-name"));
        lastName.sendKeys("Ivanov");
        WebElement street= driver.findElement(By.id("street"));
        street.sendKeys("Weg R");
        WebElement streetNumber= driver.findElement(By.id("street-number"));
        streetNumber.sendKeys("123");
        WebElement zipCode= driver.findElement(By.id("zip-code"));
        zipCode.sendKeys("12559");
        WebElement city= driver.findElement(By.id("city"));
        city.sendKeys("Berlin");

        WebElement button= driver.findElement(By.id("go_to_next_step"));
        driver.findElement(By.id("go_to_next_step")).click();
	}

	@After
    public void tearDown() {
      driver.close();
      driver.quit();
    }
}

