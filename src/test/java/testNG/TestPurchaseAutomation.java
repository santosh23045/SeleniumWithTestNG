package testNG;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class TestPurchaseAutomation {
	WebDriver driver;
	JavascriptExecutor jse;
	com.xaxis.selenium.webdriver.PurchaseAutomation purchaseAutomation = null;
	
	@Test(priority=0)
	public void testInvokeBrowser() {
		
		try {
			purchaseAutomation = new com.xaxis.selenium.webdriver.PurchaseAutomation();
			purchaseAutomation.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//searched item
	@Test(priority=1)
	public void testSearchItems() throws InterruptedException {
		purchaseAutomation.searchItems();

	}

	// refine search from left navigation(with refine device features like dual sim)
	@Test(priority=2)
	public void testRefineDeviceFeatures() {
		purchaseAutomation.refineDeviceFeatures();
	}

	// closeing site

	@Test(priority=4)
	public void testCloseSite() throws InterruptedException {
		purchaseAutomation.closeSite();
	}
}