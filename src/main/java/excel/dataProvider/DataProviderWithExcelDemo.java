package excel.dataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderWithExcelDemo {
	
	WebDriver driver;
	 
	   @BeforeMethod
	    public void setUp() {
	        System.out.println("Start test");
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.bing.com");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	    }
	 
	    @Test(dataProvider = "excelData", dataProviderClass = ExcelDataProvider.class)
	    public void search(String keyWord1, String keyWord2) {
	 
	        WebElement txtBox = driver.findElement(By.id("sb_form_q"));
	        txtBox.sendKeys(keyWord1, " ", keyWord2);
	        System.out.println("Keyword entered is : " + keyWord1 + " " + keyWord2);
	        txtBox.sendKeys(Keys.ENTER);
	        System.out.println("Search results are displayed.");
	        System.out.println("RESULT: "+ driver.getTitle());
	        Assert.assertTrue(driver.getPageSource().contains(keyWord1));
	    }
	 
	    @AfterMethod
	    public void burnDown() {
	        driver.quit();
	    }

}
