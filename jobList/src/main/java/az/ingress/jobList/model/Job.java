package az.ingress.jobList.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "jobs")

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String companyName;
    private String location;
    private String jobType;
    private String salaryRange;
    private String jobDescription;
    private String requirements;
    private String experienceLevel;
    private String educationLevel;
    private String industry;
    private Date postedDate;
    private Date applicationDeadline;
    private String howToApply;
    private String companyLogo;
    private String benefits;
    private String tags;
    private String source;


}
