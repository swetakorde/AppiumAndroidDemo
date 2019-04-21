package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class SearchResultsPage {
	
	private AndroidDriver driver;
	public String itemPrice;
	
	public SearchResultsPage(AndroidDriver driver){
		this.driver =  driver;
	}

	public void selectItem(AndroidDriver driver) {
		itemPrice = driver.findElementByAccessibilityId("$143.39").getText();
		MobileElement item = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/fragment_container\")).getChildByDescription("+ "new UiSelector().className(\"android.widget.ImageView\"), \"Apple MMEF2AM/A AirPods Wireless Bluetooth Headset for iPhones with iOS 10 or Later White - (Renewed),image\")"));
		item.click();
	}
}
