import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class utilityMethod {
    private static AppiumDriver driver;
    private DesiredCapabilities capabilities = new DesiredCapabilities();
@BeforeTest
    public void setCapabilities() throws InterruptedException, MalformedURLException {

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
        capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Thread.sleep(10000);



    }

    @Test
    public void homePageValidation()
    {
        WebElement skipButton= driver.findElementById("in.amazon.mShop.android.shopping:id/skip_sign_in_button");
        skipButton.click();
      // WebElement logo= driver.findElementById("in.amazon.mShop.android.shopping:id/sso_splash_logo");
       //Assert.assertNotNull(logo);
       System.out.print("loot");
    }

@AfterTest
    public void quit()
    {
        driver.quit();
    }
}
