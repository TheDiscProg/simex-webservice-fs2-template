# Simex Web service Template using FS2 Stream
A blueprint for creating new services. It:
* Is written in Scala
* Uses Guardrail to build the HTTP API
* Uses Blaze HTTP server

Use this when using ***Stream[F, Unit]*** as the final type; ***F*** can be Cats ***IO*** and is provided as default.
This is ideal for services that listen on RabbitMQ or Kafka queues.

## What's included
There is a simple health check API that returns a status.  
A basic health check is enabled but other health checks can be added (see below).  
Please note that the health check API does not use SIMEX.

## Extending the service for specific service
Use the ***base*** section for entities (basic data carriers) and interfaces or traits.  
The package ***...server.entities*** is where any SIMEX request/response should live. As these are evolved 
to a final solution, they can be moved into a separate repository.

### Package Naming: Application
This should refer to the name of the service or application, for example, ***authenticator***.

### Package Naming: Service
Within an application, there are different ***domains*** of concern. Here are some examples:
* Database access: ***repository***
* External services: the service should be named by which external service it is accessing 
* Messaging systems: Such as RabbitMQ, hence can be called ***rabbit***

Within the service package, sub-packages can be created for entities, services, etc, in order to 
make the code cleaner. However, entities and traits should all live in ***base***.

## Health Check
A basic health check is enabled in this service, but additional health checks can be enabled as described below. A 
high-level description is given below.

HeathRoutes --> HealthCheckService --> List: HealthChecker

**HealthCheckService** returns ***HealthCheckStatus*** which consists of:  
***HealthStatus***: The overall status of the service  
A list of ***HealthCheckerResponse*** each containing the response of a **HealthChecker**.

### Create Specific Health Check
Create a specific checker by implementing the trait **HealthChecker**.

### Add Checker to Checkers list for HealthCheckService
Add the health checker to the list for **HealthCheckService** in **AuthenticatorServer**.