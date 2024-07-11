package com.example.tests

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.EspressoOptions
import io.appium.java_client.service.local.AppiumDriverLocalService
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

class AppiumExtension : BeforeEachCallback, AfterEachCallback {
    private lateinit var service: AppiumDriverLocalService
    lateinit var driver: AndroidDriver

    override fun beforeEach(context: ExtensionContext) {
        service = AppiumDriverLocalService.buildDefaultService()
        service.start()

        val options = EspressoOptions()
            .setDeviceName("Android Emulator")
            .setAppPackage("com.example.app")
            .setAppActivity("com.example.app.MainActivity")
            .skipServerInstallation()
            .eventTimings()
        options.setCapability("appium:settings[driver]", "compose")
        driver = AndroidDriver(service.url, options)
    }

    override fun afterEach(context: ExtensionContext) {
        if (::driver.isInitialized) {
            driver.quit()
        }
        if (::service.isInitialized) {
            service.stop()
        }
    }
}
