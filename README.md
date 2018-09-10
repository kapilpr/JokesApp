# Jokes App
![jokes_desc](https://user-images.githubusercontent.com/30549956/45269867-02104380-b44a-11e8-9feb-f7f1d5edc632.png)

This app comes with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The finished app consists
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project?

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## Learning outcomes

* Free and Paid flavors to the app, and set up build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configured a multi project build to compile the libraries and app
* Used the Gradle App Engine plugin to deploy a backend
* Configured an integration test suite that runs against the local App Engine development server

## How to Complete this Project?

### Step 1: Create a Java library

The first task is to create a Java library that provides jokes.

### Step 2: Create an Android Library

Create an Android Library containing an Activity that will display a joke
passed to it as an intent extra. Wire up project dependencies so that the
button can now pass the joke from the Java Library to the Android Library.

### Step 3: Create GCE Module

Instead of pulling jokes directly from the Java library, set up a Google Cloud Endpoints development server,
and pull the jokes from there. Create an Async task to retrieve jokes. Make a button to kick off a task to retrieve a joke, then launch the activity from the Android Library to display it.

### Step 4: Add Functional Tests

Add code to test that the Async task successfully retrieves a non-empty
string. 

### Step 5: Add a Paid Flavor

Add free and paid product flavors to the app. Remove the ad (and any
dependencies) from the paid flavor.

### Step 6: Add Interstitial Ad

### Step 7: Add Loading Indicator

Add a loading indicator that is shown while the joke is being retrieved and
disappears when the joke is ready. 

### Step 8: Configure Test Task

To tie it all together, create a Gradle task that:

1. Launches the GCE local development server
2. Runs all tests
3. Shuts the server down again

## Rubric

### Required Components

- [x] Project contains a Java library for supplying jokes
- [x] Project contains an Android library with an activity that displays jokes passed to it as intent extras.
- [x] Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
- [x] Project contains connected tests to verify that the async task is indeed loading jokes.
- [x] Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.

### Required Behavior

- [x] App retrieves jokes from Google Cloud Endpoints module and displays them via an Activity from the Android Library.
- [x] Make the free app variant display interstitial ads between the main activity and the joke-displaying activity.
- [x] Have the app display a loading indicator while the joke is being fetched from the server.
- [x] Write a Gradle task that starts the GCE dev server, runs all the Android tests, and shuts down the dev server.
