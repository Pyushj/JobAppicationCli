package com.kankinara.JobAppCli.service;

import com.kankinara.JobAppCli.model.JobPost;
import com.kankinara.JobAppCli.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.findAll();
    }

    public JobPost findJobbyId(int postId) {
        return jobRepo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    public void deleteJob(JobPost jobPost) {
        jobRepo.delete(jobPost);
    }

    public void deleteJobById(int postId) {
        jobRepo.deleteById(postId);
    }

    public void initApplication() {

        List<JobPost> jobs = new ArrayList<>();
        jobs.add(new JobPost(101, "Java Developer", 2));
        jobs.add(new JobPost(102, "Android Developer", 5));
        jobs.add(new JobPost(103, "Go Developer", 2));
        jobs.add(new JobPost(104, "Rust Developer", 1));

        jobRepo.saveAll(jobs);
    }
}
