package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class LoginPage{
	private String username;
	private String password;
	private AndroidDriver driver;
	
	public LoginPage(AndroidDriver driver,String username,String password){
		this.driver = driver;
		this.username = username;
		this.password = password;
	}
	
	public void login(AndroidDriver driver) {
		driver.launchApp();
		WebElement signInButton = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/sign_in_button\")"));
		signInButton.click();
		WebElement emailIdTextBox = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"ap_email_login\")"));
		WebElement ContinueButton = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"continue\")"));
		emailIdTextBox.sendKeys(username);
		ContinueButton.click();
		WebElement passwordTextBox = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"ap_password\")"));
		WebElement signInSubmitButton = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"signInSubmit\")"));	
		passwordTextBox.sendKeys(password);
		signInSubmitButton.click();
	}
}
