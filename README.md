# LT Client

[![Build Status](https://travis-ci.org/LateralThoughts/lt-clients.png)](https://travis-ci.org/LateralThoughts/lt-clients)

This is a REST API aiming at painlessly managing all business-related activities of
Lateral Thoughts workers.

## Getting started

1. tailor `datasource.properties` to your needs (any RDBMS should do).
*Note: 'git update-index --assume-unchanged' is strongly advised here.*
1. run `mvn tomcat7:run` (notice it's tomcat7, not tomcat!)
1. open 'localhost:8080/clients' with your favourite tool (curl, browser...).
Note you can also, for comfort of use, install [Spring Shell](http://www.springsource.org/spring-shell).


## Deployment

It's live: [http://lt-clients.cloudfoundry.com/](http://lt-clients.cloudfoundry.com/)!

You'll need Cloud Foundry command line utility: [VMC](http://docs.cloudfoundry.com/tools/vmc/installing-vmc.html)
if you wanna be able to deploy the application.

You can also check the [hands-on](https://github.com/ericbottard/hands-on-cloudfoundry) to get familiar with CF.

## TODO

1. _worker/client_: assign/update worker workload to client (number of days [step:0.5], TJM, worker status)
1. _activity_: search by worker AND (period OR day)
1. _activity_: search by client AND period
1. API authentication
1. _activity_: expose alternate email representation
1. get rid of web.xml!


## DONE

1. _worker_: create/delete/expose LT workers (firstName, lastName, email)
1. _client_: create/delete/expose LT clients (company name, address, email)


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/fbiville/lt-clients/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

