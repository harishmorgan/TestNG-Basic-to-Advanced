package depends.on;

import org.testng.annotations.Test;

public class TestNGGroupDemo {

	@Test(alwaysRun = true, groups = { "e2etest", "integerationtest" })
    public void testPrintMessage() {
        System.out.println("This method is run by both e2e and integeration test");
    }
 
    @Test(alwaysRun = true, groups = { "e2etest" })
    public void testE2EMessage() {
        System.out.println("This method is run by e2e test");
    }
 
    @Test(alwaysRun = true, groups = { "integerationtest" })
    public void testingIntegrationMessage() {
        System.out.println("This method is run by integeration test");
    }
 
    @Test(alwaysRun = true, groups = { "acceptancetest" })
    public void testingAcceptanceMessage() {
        System.out.println("This method is run by Acceptance test");
    }
 
    @Test(alwaysRun = true, groups = { "e2etest", "acceptancetest" })
    public void testE2EAndAcceptanceMessage() {
        System.out.println("This method is run by both e2e and acceptance test");
    }
 
    @Test(alwaysRun = true, groups = { "e2etest", "integerationtest", "acceptancetest" })
    public void testE2EAndAcceptanceAndIntegrationMessage() {
        System.out.println("This method is run by e2e, integration and acceptance test");
    }
 
}
