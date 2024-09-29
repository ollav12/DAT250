# DAT250 Expass 5
- Olav Høysæther Opheim

## Short Report
In this i got familiar with MongoDB by following the tutorial, reading, setting up a DB and using basic CRUD operations.

## Technical problems
- I had no techinal problems during this expass

## Screenshots

### Verifying mongodb packages
![alt text](image.png)

## Experiment 1: MongDB CRUD operations
- Here are some screenshots from some of the crud operations i used when following the tutorials, i tested them on a test database i created.

### Insert
![alt text](image-1.png)
![alt text](image-2.png)

### Query

![alt text](image-4.png)
- Querying to find a specific object given objectid

### Update
![alt text](image-3.png)
- Added a "prodID: 0" to all and also updated the quantity of the first object to be 15 instead of prevoisly 125.

### Remove

![alt text](image-5.png)
- Deleted by using the interface and clciking delte on the given object

### Bulk write
For the following i used the test database that i have been using for the above crud operations, but added a pizzas collection as shown in the tutorial. And then ran the following commands to bulk write.

![alt text](image-6.png)


## Expermient 2: Aggregation

### Example working

#### Inserting documents
![alt text](image-7.png)

#### Defining map fucntion, reduce function and preform map reduce
![alt text](image-8.png)
- The mapReduce function was deprecated so i had to use the aggregate function.


## Reasons why Map-reduced operation is useful 
- Map reduced is useful for processing and analyzing large data sets. It is very useful when dealing with operations that require aggregation.

## Pending issues
- There are no pending issues