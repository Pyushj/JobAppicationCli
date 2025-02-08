package com.kankinara.JobAppCli;

import com.kankinara.JobAppCli.model.JobPost;
import com.kankinara.JobAppCli.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("jobs")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("job/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return jobService.findJobbyId(postId);
    }

    @PostMapping("job")
    public void postJob(@RequestBody JobPost jobPost){
        jobService.addJob(jobPost);
    }

    @PutMapping("job")
    public void updateJob(@RequestBody JobPost jobPost){
        jobService.updateJob(jobPost);
    }

    @DeleteMapping("job")
    public void deleteJob(@RequestBody JobPost jobPost){
        jobService.deleteJob(jobPost);
    }

    @DeleteMapping("job/{postId}")
    public void deleteJobById(@PathVariable int postId){
        jobService.deleteJobById(postId);
    }

    @PostMapping("init")
    public void initializeApplication(){
        jobService.initApplication();
    }
}
