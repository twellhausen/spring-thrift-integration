# spring-thrift-integration
This is an example that shows how to integrate Thrift in a Spring application without using Spring Boot.
Instead it relies on Spring's `WebApplicationInitializer` class so that no web.xml is needed.

## How to build

Let Maven compile the code:

```
mvn compile
```

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
Please read my (German) article on the [Freiberufler Team Blog](http://freiberufler-team.de/) for more information.
