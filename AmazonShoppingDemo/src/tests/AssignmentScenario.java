package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.net.MalformedURLException;
import pages.*;
import org.testng.annotations.*;
import org.testng.Assert;

public class AssignmentScenario {
	private String username = "kingtesterblizzard@gmail.com";
	private String password = "kingtester1234";
	
	@Test
	public void test() throws MalformedURLException, InterruptedException {
		//Prepare Appium Session
		AssignmentScenario s1 = new AssignmentScenario();
		File app = new File("src/app/Amazon Shopping_v18.8.0.100_apkpure.com.apk");
		DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "OnePlus 6T");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "9");
        dc.setCapability("appPackage", "com.amazon.mShop.android.shopping");
        dc.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
        dc.setCapability("app", app.getAbsolutePath());
        
        //Initialize driver
        AndroidDriver driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),dc);
        
        //Login Page steps to sign in using email id and password
        LoginPage loginPage = new LoginPage(driver,s1.username,s1.password);
        loginPage.login(driver);
        
        //Search for "airpods" on the homepage
        HomePage homePage = new HomePage(driver);
        homePage.performSearch(driver);
        
        //Switch on the prime filter, scan the search results and select the desired item
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectItem(driver);
        
        //Add item to cart
        ItemPage itemPage = new ItemPage(driver);
        itemPage.addToCart(driver);
        
        //Assert price of item from SearchResultsPage with ItemPage
        Assert.assertEquals(searchResultsPage.itemPrice, itemPage.itemPrice);
        
        //Assert details on the CheckOutPage
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.checkOut(driver);
        
        //Close the driver
        driver.quit();
	}
	


}
