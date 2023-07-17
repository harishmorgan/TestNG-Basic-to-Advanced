package parallel.dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviderDemo {
	
	@DataProvider(name = "testData", parallel=true)
    public Object[][] dataProvFunc() {
          return new Object[][] {           
              {"","","Epic sadface: Username is required"},        
              {"","Test","Epic sadface: Username is required"},
              {"$%1234","2345%$","Epic sadface: Username and password do not match any user in this service"}          
            };
       }
   }

