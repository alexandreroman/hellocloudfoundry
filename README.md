# Hello Cloud Foundry!

This is a simple Kotlin app, using Spring Boot.
The purpose of this app is to play with [Cloud Foundry](https://www.cloudfoundry.org), and learn how to use it.

This app is made of two modules:
 - App: the main app, exposing a REST service and a simple UI
 - Config: a local Spring Cloud Config server, enabling dynamic configuration in dev mode

## Prerequisites

Tests are made using [Pivotal Web Services (PWS)](https://run.pivotal.io).

You need a Java 8 SDK to build this app.

## Build instructions

This project is using [Maven 3.5+](http://maven.apache.org):
    
    $ mvn clean package

## How to run this app

If you are behind a proxy, please enter these commands:
    
    $ export http_proxy=http://host:port
    $ export https_proxy=http://host:port

To deploy this app to PWS, use these commands:

    $ cf login -a http://api.run.pivotal.io
    $ cf push

## Enjoy!

The app should be available at https://hello-cloud-foundry-RANDOM.cfapps.io/greeting.
Check command output or [Apps Manager](https://console.run.pivotal.io) to get the real endpoint.

You can set your name by adding a query parameter 'name', such as
https://hello-cloud-foundry-RANDOM.cfapps.io/greeting?name=Boss.
