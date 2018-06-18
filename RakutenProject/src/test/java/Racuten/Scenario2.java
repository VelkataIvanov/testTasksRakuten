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
		
		
		driver= new FirefoxDriver();
		driver.get("https://www.rakuten.de/");
		driver.manage().window().maximize();
		
		String popUpBegin=driver.getWindowHandle();
		WebElement popUpButtonBegin= driver.findElement(By.id("consent_prompt_submit"));
		driver.findElement(By.id("consent_prompt_submit")).click();
				
	}

	@Test
	public void Scenario2() {
		
		
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

