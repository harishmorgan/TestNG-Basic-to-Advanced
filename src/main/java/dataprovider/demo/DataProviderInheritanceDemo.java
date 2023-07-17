package dataprovider.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataProviderInheritanceDemo {
	
	WebDriver driver;
	 
    @BeforeMethod
    public void setUp() {
 
        System.out.println("Start the test");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
 
    }
 
    // Passing the dataProvider to the test method through @Test annotation
    @Test(dataProvider = "testData", dataProviderClass = DataProviderClass.class)
    public void search(String keyWord) {
        WebElement txtBox = driver.findElement(By.id("sb_form_q"));
        txtBox.sendKeys(keyWord);
        System.out.println("Keyword entered is : " + keyWord);
        txtBox.sendKeys(Keys.ENTER);
        System.out.println("Search result is displayed.");
    }
 
    @AfterMethod
    public void burnDown() {
        driver.quit();
 
        System.out.println("End the test");
    }

}
