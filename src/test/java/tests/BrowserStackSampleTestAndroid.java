package tests;

import config.MobileConfig;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class BrowserStackSampleTestAndroid {

    static MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browserstack.user", config.getBrowserStackUser());
        caps.setCapability("browserstack.key", config.getBrowserStackKey());

        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        caps.setCapability("device", "Samsung Galaxy Tab S3");
        caps.setCapability("os_version", "9.0");

        caps.setCapability("project", "JavaProject");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "testForAndroid");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);
        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(
                        MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);
        List<AndroidElement> allProductsName = driver.findElementsByClassName(
                "android.widget.TextView");
        assert (allProductsName.size() > 0);
        driver.quit();

    }
}