# Appium Espresso sample

This sample project shows how to build Espresso server APK from a local Gradle module,
consuming Appium Espresso driver as an Android library.

## Preparing the environment

```shell
npm install -g appium
appium driver install espresso
```

## Building and installation

Run the following to build and install the app and Espresso server on the connected device:

```shell
./gradlew :app:installStaging :app:installStagingAndroidTest
```

Alternatively, build Espresso server from a standalone test module:

```shell
./gradlew :app:installStaging :espresso_server:installStaging
```

## Running tests

Run tests against the connected device:

```shell
./gradlew :tests:test --rerun
```
