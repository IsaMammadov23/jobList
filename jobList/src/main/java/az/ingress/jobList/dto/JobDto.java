package az.ingress.jobList.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobDto {

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
