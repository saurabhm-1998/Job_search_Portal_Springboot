package com.geekster.JobSearchPortal.Service;

import com.geekster.JobSearchPortal.Model.Job;
import com.geekster.JobSearchPortal.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Optional<Job> getJob(Long id) {
        return jobRepository.findById(id);
    }

    public Iterable<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public void updateJobTitle(Long id, String title) {
        jobRepository.findById(id).ifPresent(job -> {
            job.setTitle(title);
            jobRepository.save(job);
        });
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> searchJobsByTitleAndDescription(String title, String description) {
        return jobRepository.findByTitleContainingAndDescriptionContaining(title, description);
    }

    public List<Job> searchJobsByTitle(String title) {
        return jobRepository.findByTitleContaining(title);
    }

    public List<Job> searchJobsByDescription(String description) {
        return jobRepository.findByDescriptionContaining(description);

    }
}
