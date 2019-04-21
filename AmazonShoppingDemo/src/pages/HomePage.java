package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	private AndroidDriver driver;
	
	public HomePage(AndroidDriver driver){
		this.driver =  driver;
	}
	
	public void performSearch(AndroidDriver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement searchTextBox = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/rs_search_src_text\")"));
		searchTextBox.sendKeys("airpods");
        WebElement dropdownSuggestion = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"in Cell Phones & Accessories\")"));
        dropdownSuggestion.click();
        
        WebElement prime = driver.findElementByAccessibilityId("Prime Eligible,image");
        int x = prime.getLocation().x;
        int y = prime.getLocation().y;
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x+100,y)).perform();
       
        Assert.assertEquals(searchTextBox.getText(), "airpods");
	}

}
