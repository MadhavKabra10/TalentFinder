package com.madhav.Repo;

import com.madhav.Model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.AggregateIterable;

@Component
public class SearchFunctionality {
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter converter;
    public List<Post> search(String parameter){
        List<Post> posts = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("JobListingProject");
        MongoCollection<Document> collection = database.getCollection("Jobs");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", parameter)
                                                .append("path", Arrays.asList("job_profile", "skills", "location")))),
                new Document("$sort",
                        new Document("avg_salary_in_rupees", -1L)),
                new Document("$limit", 5L)));
        result.forEach(document -> posts        .add(converter.read(Post.class,document)));
        return posts;
    }
}
