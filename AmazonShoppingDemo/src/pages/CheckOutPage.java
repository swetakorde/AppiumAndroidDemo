package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class CheckOutPage {
	private AndroidDriver driver;
	
	public CheckOutPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	public void checkOut(AndroidDriver driver) {
		MobileElement itemDesc = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"Apple MMEF2AM/A AirPods Wireless Bluetooth Headset for iPhones w...\")");
		MobileElement itemPrice = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"$143.39\")");
		Assert.assertEquals(itemDesc.getText(),"Apple MMEF2AM/A AirPods Wireless Bluetooth Headset for iPhones w...");
		Assert.assertEquals(itemPrice.getText(),"$143.40");
		
	}

}
