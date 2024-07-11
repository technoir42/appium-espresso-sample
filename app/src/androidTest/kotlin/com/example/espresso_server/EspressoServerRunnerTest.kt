package com.example.espresso_server

import androidx.test.filters.LargeTest
import io.appium.espressoserver.lib.http.Server
import org.junit.Rule
import org.junit.Test

@LargeTest
class EspressoServerRunnerTest {
    @get:Rule
    val server = Server()

    @Test
    fun startEspressoServer() {
        server.run()
    }
}
