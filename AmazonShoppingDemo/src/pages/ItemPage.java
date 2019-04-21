package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage {
	private AndroidDriver driver;
	public String itemPrice;
	
	public ItemPage(AndroidDriver driver){
		this.driver =  driver;
	}
	
	public void addToCart(AndroidDriver driver) throws InterruptedException {
		itemPrice = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"newPitchPriceWrapper_feature_div\")")).getText();
		System.out.println(itemPrice);
		TouchAction action = new TouchAction(driver);
		action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)));
		action.press(PointOption.point(0,600)).moveTo(PointOption.point(0,500)).release().perform();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Add to Cart\")")).click();
        action.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)));
        WebElement noThanksButton = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"a-autoid-3\")"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"a-autoid-3\")"))));
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"a-autoid-3\")")).click();
		WebElement cartIcon = driver.findElementByAccessibilityId("Cart");
		wait.until(ExpectedConditions.visibilityOf(cartIcon));
		cartIcon.click();
	}

}

