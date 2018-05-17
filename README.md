# Jokes App

This app comes with multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The finished app consists
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## Implementation

* Free and Paid flavors to the app, and set up build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configured a multi project build to compile the libraries and app
* Used the Gradle App Engine plugin to deploy a backend
* Configured an integration test suite that runs against the local App Engine development server
