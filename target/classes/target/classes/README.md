# Simple CRUD
This repository contains a simple CRUD project built using Java Spring. 

It is the second step of understanding how to manipulate variables through REST calls.

All the relevant code now is inside the controller (for didactic purpose) 
The Idea is to understand different REST components (Path, Param, Header and Body)
And how to filter a list using them.

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## Database
The project uses PostgresSQL as the database. The necessary database migrations are managed using Flyway.
Just create a Database called Product and it should be usable.

To run the project: 

Create a database on postgres called product
Open the project on IntelliJ
Configure the application.properties file with the proper ip/port/database name
Clean Build (Or maven clean install)
Run the mainclass 
