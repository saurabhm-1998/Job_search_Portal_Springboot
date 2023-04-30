package com.geekster.JobSearchPortal.Model;

import com.geekster.JobSearchPortal.JobType;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @NotNull
    @DecimalMin(value = "0.0", message = "Salary must be a positive number")
    private Double salary;

    @NotBlank(message = "Company name is mandatory")
    private String companyName;

    @NotBlank(message = "Employer name is mandatory")
    private String employerName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;

    public void setTitle(String title) {
    }
}
