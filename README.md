# spring-thrift-integration
This is an example that shows how to integrate [Thrift](https://thrift.apache.org/) in a Spring application without using Spring Boot. Instead it relies on Spring's `WebApplicationInitializer` class so that no web.xml is needed.

## How to build

Let Maven compile the code:

```
mvn compile
```
If an error arises, check whether the Thrift binaries are installed on your machine. If not, please go to [thrift.apache.org](https://thrift.apache.org/) in order to download and install Thrift.

## How to start up

First start the server:

```
mvn jetty:run
```

Then start the client:

```
mvn exec:java
```

## More information
Please read my (German) article on the [Freiberufler-Team blog](http://freiberufler-team.de/software-architektur/thrift-api-mit-spring-wie-integriert-man-beides-2070.html) for more information.
