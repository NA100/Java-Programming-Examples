package com.tgt.testapp.database;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDAO {

    public static void main(String[] args) {

        // make a connection to MongoDB server through MongoClient instance.
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // connect to a database
        MongoDatabase database = mongoClient.getDatabase("test");

        // get all database names
        mongoClient.getDatabaseNames().forEach(System.out::println);

        // retrieving a collection.
        MongoCollection<Document> collection = database.getCollection("Todos");

        // inserting new documents into the collection.
        Document document = new Document("title", "mongodb")
                .append("id", 1)
                .append("description", "database")
                .append("likes", 100)
                .append("url", "http://www.tutorialspoint.com/mongodb/")
                .append("by", "tutorials point");

        System.out.println("Document inserted successfully");
        collection.insertOne(document);

        // delete a document
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("text", "a new document is created");
        collection.deleteOne(searchQuery);
    }

}
