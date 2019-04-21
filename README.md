# AppiumAndroidDemo

# Objective
Automate a simple "add to item to cart" test scenario on Android using Appium, Selenium and TestNG.

# Steps
1. Java setup - Install Java and setup the path appropriately
2. Appium setup - Download and install appium. Start appium server
3. Android SDK setup - Download Android SDK and setup the path appropriately
4. Clone the repository
5. Open the solution
6. Rebuild
7. Run the test

# Versions/tools used:
Appium - 1.12.1
Java - 1.8.0_202
Selenium - 3.141.59
Appium desktop - to identify elements
"apk info" app - to dienity package name and activity details
Eclipse IDE for Java Developers
Android 9 device (Oneplus 6)

# Test Case:
Package test contains a class called 'AssignmentScenario' which performs the following test steps:
1. Create capability instance with the platform and device details
2. Initiate Android driver
3. Create an instance of LoginPage class and call method login which uses email id and password to login to the Amazon Shopping app
4. Create instance of HomePage class and call method performSearch. Here we search for "airpods" and select "airpods in Cell Phones & Accessories". Switch on the prime filter to ensure only prime eligible results are displayed. Assert the search text box for "airpods"
5. Create instance of SearchResultsPage and call method selectItem. Select "Apple MMEF2AM/A AirPods Wireless Bluetooth Headset for iPhones with iOS 10 or Later White" (tried to select Amazon's choice but its not longer available in the search results page)
6. Create instance of ItemPage and call method addToCart
7. Assert that price on SearchResultsPage for the desired item matches with the price on the ItemPage
8. Create instance of CheckOutPage class and call method checkOut. Assert that the details on the page correspond to the desired item
9. Quit android driver


