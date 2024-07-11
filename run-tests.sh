#!/usr/bin/env bash
set -euo pipefail

adb shell pm uninstall com.example.app || true
adb shell pm uninstall io.appium.espressoserver.test || true

# Use Espresso server built from AndroidTest component of app module
./gradlew :app:installStaging :app:installStagingAndroidTest
./gradlew :tests:test --rerun

# Use Espresso server built from a standalone test module
./gradlew :app:installStaging :espresso_server:installStaging
./gradlew :tests:test --rerun
