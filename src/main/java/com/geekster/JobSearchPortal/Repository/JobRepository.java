package com.geekster.JobSearchPortal.Repository;

import com.geekster.JobSearchPortal.Model.Job;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface JobRepository extends CrudRepository<Job, Long> {

    List<Job> findByTitleContainingAndDescriptionContaining(String title, String description);

    List<Job> findByTitleContaining(String title);

    List<Job> findByDescriptionContaining(String description);
}
