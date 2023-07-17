package dataprovider.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	 
    @DataProvider(name = "testData")
    public Object[][] dataProvFunc() {
        return new Object[][] { { "Selenium" }, { "TestNG" } };
    }
 
    @BeforeMethod
    public void setUp() {
 
        System.out.println("Start the test");
        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bing.com/");
        driver.manage().window().maximize();
 
    }
 
    // Passing the dataProvider to the test method through @Test annotation
    @Test(dataProvider = "testData")
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
    
    /*In the above example, I am passing two search keywords, viz “Selenium” and “TestNG” to the test method 
     * using the DataProvider method.
     */

}
