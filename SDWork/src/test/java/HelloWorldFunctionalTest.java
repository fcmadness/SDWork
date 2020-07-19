import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorldFunctionalTest {
	  private WebDriver driver;

	    @BeforeClass
	    public static void setupClass() {
//	        ChromeDriverManager.getInstance().setup();
	        WebDriverManager.chromedriver().setup();
	    }

	    @Before
	    public void setUp() {
	        driver = new ChromeDriver();               
	    }

	    @After
	    public void tearDown() {
	        if (driver != null)
	            driver.quit();                         
	    }

	    @Test
	    public void sayHello() throws Exception {      
	       String name="Sofi";
	    	driver.get("http://localhost:8080/SDWork");
	        Thread.sleep(5000);  
	        
	        WebElement input = driver.findElement(By.id("say-hello-text-input"));
	        input.sendKeys(name);
	        Thread.sleep(3000);  

	        WebElement clickButton = driver.findElement(By.id("say-hello-button"));
	        clickButton.click();

//	        driver.findElement(By.id("say-hello-text-input")).sendKeys("Dolly");
//	        driver.findElement(By.id("say-hello-button")).click();

	        assertEquals("SD Hello World Page", driver.getTitle());
	        assertEquals("Hello, "+ name + "!", driver.findElement(By.tagName("h2")).getText());
	        Thread.sleep(10000);  
	    }
}
