# DAT250 Expass 7
- Olav Høysæther Opheim

## Part 1: Switching from H2 to PostgreSQL using docker image 
- Link to expass4 code: https://github.com/ollav12/dat250-jpa-tutorial

### Setup
- I am working on a different computer than expass 1 so i have to install docker using the tutorial from expass 1. And under you can see an image where i can verify that docker is installed on the system with no errors.
![alt text](image-24.png)

### Postgre docker image
- I run the "docker pull postgres" command in terminal to download a postgre image to my machine.
![alt text](image-25.png)

### Docker ...
- Creating a docker instance
![alt text](image-26.png) 

- Running "docker ps" and "docker logs jpa"
![alt text](image-27.png)

### Connecting to PostgreSQL using DBeaver
- I connect to the sql clinet using DBeaver and created a user
![alt text](image-28.png)

- I have now updated the build.gradle.kts file
![alt text](image-29.png)

- Here i updated the presistence.xml file
![alt text](image-30.png)

### Updating database
- Using DBeaver i manually execute the sql query script "scheme.up.sql" that is created when gradle test is ran and the database is up to date
![alt text](image-31.png)

- I updated the privelages to the "jpa_client" user so that the test would pass (see issues).
![alt text](image-32.png)

## Part 2: Creating a docker image



## Issues and techical difficulites
- The "jpa_client" user did not have the correct privelages in the database to execute the sql scripts so when connecting to the databse with the user, all the tests failed. I updated to give access/permission in all tables and the tests now pass!
- I tinkered around with the .xml file to see if there were some settings there that was causing the databse to not update/create the tables. Once i reread the tutorial i saw that i had to manually execute the schema.up.sql in dbeaver for the tables to be created.