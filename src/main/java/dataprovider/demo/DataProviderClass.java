package dataprovider.demo;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name = "testData")
    public Object[][] dataProvFunc() {
        return new Object[][] { 
          { "Selenium" }, { "TestNG" }, { "Automation" } };
    }

}
