# Learning-Spring-With-Spring-Boot
Learning Spring Boot by creating a web application

To enable database for data retrieval 

go this following directory 

Learning-Spring-With-Spring-Boot/learning-spring/bin

Run comand ./start_postgres.sql

This may throw error with psql command being unable to run

In this case, exec into docker container, then into /var/lib/postgresql

Run the following commands in the order below to populate the database

psql -U postgres -d dev -h localhost -f /var/lib/postgresql/schema.sql
psql -U postgres -d dev -h localhost -f /var/lib/postgresql/data.sql

If these commands succeed the database is populated and the application is ready to be run



To call api use curl in terminal 

curl localhost:8080/api/reservations

To find the one reservation use this command

curl localhost:8080/api/reservations?date=2020-01-01

Person with first name Judith should be amongst the data returned
