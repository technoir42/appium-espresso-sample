package com.example.tests

import io.appium.java_client.AppiumBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class MainScreenTest {
    @RegisterExtension
    val appium = AppiumExtension()

    @Test
    fun `click on OK button`() {
        val button = appium.driver.findElement(AppiumBy.tagName("button_ok"))
        button.click()
    }
}
