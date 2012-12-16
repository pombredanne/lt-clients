# LT Client

This is a REST API aiming at painlessly managing all business-related activities of
Lateral Thoughts workers.

## Getting started

1. tailor `datasource.properties` to your needs (any RDBMS should do).
*Note: 'git update-index --assume-unchanged' is strongly advised here.*
1. run `mvn tomcat:run`
1. open 'localhost:8080/clients' with your favourite tool (curl, browser...).
Note you can also, for comfort of use, install [Spring Shell](http://www.springsource.org/spring-shell).

## TODO

1. _client_: create/delete/expose LT clients (company name, address, email)
1. _worker/client_: assign/update worker workload to client (number of days [step:0.5], TJM, worker status)
1. _activity_: search by worker AND (period OR day)
1. _activity_: search by client AND period
1. API authentication
1. _activity_: expose alternate email representation


## DONE

1. _worker_: create/delete/expose LT workers (firstName, lastName, email)
