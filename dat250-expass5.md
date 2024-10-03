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
In this experiment i followed the tutorial linked in the assignment, and below you can find some screenshots from me following the tutorial using the mongo shell

### Insert
Using InsertOne()
![alt text](image-9.png)

Using Find()
![alt text](image-10.png)

Using insertMany()
![alt text](image-11.png)

### Query
I insert some data into a collection so that i can do some queries.
![alt text](image-12.png)

A simple find query-
![alt text](image-13.png)

Use find and specify "AND" conditions
![alt text](image-14.png)

Here is a more complex query i used in the tutorial
![alt text](image-15.png)

which corresponds to the following sql statement: SELECT * FROM inventory WHERE status = "A" AND ( qty < 30 OR item LIKE "p%")

### Update
- First i insert the data we are using for this tutorial
![alt text](image-16.png)

- Using the updateOne function
![alt text](image-17.png)

- Using the replaceOne function
![alt text](image-18.png)

### Remove
- Data i inserted for this tutorial 
![alt text](image-19.png)

- Using the delte one function
![alt text](image-21.png)

- Using the delete many function
![alt text](image-20.png)

### Bulk write
- Bulk writing is a way to preform a bulk (multiple) operations in one execution. For this tutorial i fist insert some data as explained in the tutorial, before executing a bulk write.
![alt text](image-6.png)

## Expermient 2: Aggregation
- I start by insterting the data.
![alt text](image-7.png)

- We now define the functions and can query the new collection and get the results.
- The mapReduce function was deprecated so i had to use the aggregate function.
![alt text](image-8.png)

## Reasons why Map-reduced operation is useful 
- Map reduced is useful for processing and analyzing large data sets. It is very useful when dealing with operations that require aggregation.

## Pending issues
- There are no pending issues