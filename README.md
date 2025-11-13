Overview

This project is a spring boot app that connects to an in memory database (H2) as well as a persistent database using PostgreSql!

Setup

I have JDK 25 installed and set up with the project, seem to run into issues with lombok and other dependencies with versions lower than 25. 
Also seemed to be issues wth using intellij versions less than 2025, this may only be an issue in the labs though
By Cloning the project throughh intelliJ you should inherit all dependencies needed, aside from that you will need to download Docker Desktop.

Running (H2)

Open the properties files to check / change username / password as you need
Go to Edit Configurations -> profile -> type 'dev' -> Run
Once running enter: http://localhost:8080/h2-console to view the mock database. 
go to http://localhost:8080/swagger-ui/index.html to Post, Get, Put & Delete. Database entres can be seen from Swagger & from H2 using Sql queries

Running (PostgreSql)

As previously mentioned, check / change username / password as needed, these credentials will be needed so take note. 
From the CLI enter 'mvn -DskipTests package' to package the .jar file. Similarly, you can select the maven option on the right side of the ide where you can select package for the same effect.
Now, from the CLI enter 'docker compose up --build'

From here you can open swagger: http://localhost:8000/swagger-ui/index.html and begin using the program! 

#Note you can start directly from Docker Dekstop by selecting 'Run' on the conatainer, where you can then go to swagger on your localhost which is running onpor 8000 unlike the h2 database which is running on port 8080.

You can use the cmd 'docker compose down' to stop containers (data persists) & 'docker compose down -v' to stop containers (-v wipes database)

Enjoy!
