package com.madhav.Repo;

import com.madhav.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JobRepo extends MongoRepository<Post,String> {
}
