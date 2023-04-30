package com.geekster.JobSearchPortal.Controller;


import com.geekster.JobSearchPortal.Model.Job;
import com.geekster.JobSearchPortal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@Valid @RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        Optional<Job> job = jobService.getJob(id);
        return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public Iterable<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PutMapping("/{id}/title")
    public ResponseEntity<Void> updateJobTitle(@PathVariable Long id, @RequestBody String title) {
        jobService.updateJobTitle(id, title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public Iterable<Job> searchJobs(@RequestParam(name = "title", required = false) String title,
                                    @RequestParam(name = "description", required = false) String description) {
        if (title != null && description != null) {
            return jobService.searchJobsByTitleAndDescription(title, description);
        } else if (title != null) {
            return jobService.searchJobsByTitle(title);
        } else if (description != null) {
            return jobService.searchJobsByDescription(description);
        } else {
            return jobService.getAllJobs();
        }
    }
}
