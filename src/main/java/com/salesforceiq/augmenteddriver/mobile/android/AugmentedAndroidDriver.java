package com.salesforceiq.augmenteddriver.mobile.android;

import com.google.inject.name.Named;
import com.salesforceiq.augmenteddriver.modules.PropertiesModule;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Driver used for automation against Android.
 *
 * <p>
 *     IMPORTANT: Not using Guice, since we would need to do a Singleton, and that
 *     reduces the performance (when trying to run tests on parallel on SauceLabs, for
 *     some reason, it only creates one at a time, and sometimes Sauce takes 40 seconds
 *     to create a new one.
 * </p>
 */
public class AugmentedAndroidDriver extends AndroidDriver<WebElement> {
    private AugmentedAndroidFunctions augmentedFunctions;

    /**
     * Extensive constructor.
     *
     * @param remoteAddress Where the Selenium is running.
     * @param capabilities The capabilities to use.
     * @param augmentedFunctions the extra functionality for Android.
     * @throws MalformedURLException In case the remoteAddress is now well formed.
     */
    public AugmentedAndroidDriver(String remoteAddress,
                                  DesiredCapabilities capabilities,
                                  AugmentedAndroidFunctions augmentedFunctions) throws MalformedURLException {
        super(new URL(remoteAddress), capabilities);
        this.augmentedFunctions = augmentedFunctions;
    }

    /**
     * @return the augmented functionality on top of the driver.
     */
    public AugmentedAndroidFunctions augmented() {
        return augmentedFunctions;
    }

    /**
     * DO NOT USE.
     *
     * @param augmentedFunctions the functions to set on top of the driver.
     */
    public void setAugmentedFunctions(AugmentedAndroidFunctions augmentedFunctions) {
        this.augmentedFunctions = augmentedFunctions;
    }
}
