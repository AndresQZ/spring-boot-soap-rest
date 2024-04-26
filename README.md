## Note: in order to be able to spin springBootApp up, install maven and lombok

# Clone the repository and use any of the two options below to run springBootApp

## raise springBootApp up using maven
```bash
mvn spring-boot:run
```

## run springBootApp as container (need docker)
```bash
sh dockerScript.sh
```

At the root project there is a wsdl file called springWS, which can be used for testing the WebService

## WSDL 
http://<hostname>:8080/ws/pokemons.wsdl

## H2 database - access
http://<hostname>:8080/h2-console

There must be a created table called **TRACE_REQUEST**

## Local Development -> generated-classes based on xsd schema
```bash
mvn compile
```