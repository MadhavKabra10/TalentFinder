package com.madhav;

import com.madhav.Model.Post;
import com.madhav.Repo.JobRepo;
import com.madhav.Repo.SearchFunctionality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("JobEntry")
public class Controller {
    @Autowired
    JobRepo repo;
    @Autowired
    SearchFunctionality searchFunctionality;
    @GetMapping("getAllJobs")
    @CrossOrigin
    public List<Post> getAllJobs(){
        return repo.findAll();
    }
    @GetMapping("search/{parameter}")
    @CrossOrigin
    public List<Post> getParticular(@PathVariable String parameter){
        return searchFunctionality.search(parameter);
    }
    @PostMapping("PutJob")
    public void addJob(@RequestBody Post post){
        repo.save(post);
    }
}
