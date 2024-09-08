# DAT250 Expass 2
- Olav Høysæther Opheim

## Short summary
In this assignment i have implemented a simple REST API for Poll app using Spring Boot. I decided to use a Model View Controller 
structure for this project which i think turned out good. Controller folder contains the controllers for Poll, User and Vote. In the model we implement the logic for the Poll,
User, Vote and VoteOption. There is also a manager folder where PollManager resides.

I have manager to follow and finish the following steps in this assignemnt:
- Step 1 - I created a Spring project and initialized it to GitHub.
- Step 2 - I implemented the classes with the given parameters set in the task description.
- Step 3 - I implemented test scenarios, and did this by using Bruno.
- Step 4 - I implemented the controllers using @RestController and the corresponding @...Mappings.
- Step 5 - I have created manual tests in bruno folder, but i have connected postman to github workflows which show how automated testing can be conencted.
- Step 6 - I added the given dependencies to the gradle file and tinkered around and it seems to look fine.
- Step 7 - I have managed to use postman and integrate it so that it runs automatically. Note! I made the test cases in bruno so i only made one test case in postman to show that i am able to 
connect testing with github actions workflow. I found it repetitve to create all the test cases again, the bruno files can be used for manual testing.

## Technical difficulties
- First time using the Spring framework
- Working with new idea Intellij so spent some time to get familiar with the idea
- Spent some time trying to figure out how to integrate automated testing with postman on github workflows.

## Pending issues
- There are no pending issues other than not all test are automated.