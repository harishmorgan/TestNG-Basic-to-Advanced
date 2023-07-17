package testng.features;

import org.testng.annotations.*;

public class AnnotationsExample {
	
	@BeforeTest
    public void init(){
        System.out.println("---------------- Before Test ------------- ");
        //open the browser
    }
 
    @AfterTest
    public void quit(){
        System.out.println("---------------- After Test ------------- ");
        //close the browser
    }
 
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("############# Before Method ############# ");
        //Initialize the Report
    }
 
    @AfterMethod
    public void afterMethod() {
        System.out.println("############ After Method ##############");
        //Finalize the Report
    }
 
    @BeforeClass
    public void beforeClass() {
        System.out.println("************* Before Class *************");
    }
 
    @AfterClass
    public void afterClass() {
        System.out.println("************* After Class ***************");
    }
 
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This will execute Before Suite");
    }
 
    @AfterSuite
    public void afterSuite() {
        System.out.println("This will execute After Suite");
    }
 
    @Test
    public void loginTest(){
        System.out.println("Login the application ");
 
    }
 
    @Test
    public void logout(){
        System.out.println("Logout the application ");
 
    }

}
