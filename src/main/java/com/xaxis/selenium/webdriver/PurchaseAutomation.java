package com.xaxis.selenium.webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PurchaseAutomation {
	WebDriver driver;
	JavascriptExecutor jse;
	/*//Login name text box
		@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input" )
		WebElement  LoginName;
		//Password text box
		@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input" )
		WebElement  Password;
		//Submit button
		@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button" )
		WebElement Submit;
		//Logout link
		@FindBy(id = "layoutLogoutId" )
		WebElement Logout;*/

	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\santoshs\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			//Opening site
			driver.get("https://www.amazon.in/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//searched item
	public void searchItems() throws InterruptedException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Redmi Note 5");
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();

	}

	// refine search from left navigation(with refine features like dual sim)
	public void refineDeviceFeatures() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0,1000)");//scroll and search device feature

		driver.findElement(By.xpath("//*[@id=\"leftNavContainer\"]/ul[14]/div/li[1]/span/span/div/label/input")).click();
	}

	// closeing site
	public void closeSite() throws InterruptedException {
		Thread.sleep(6000);
		driver.quit();
		driver = null;
	}
}
