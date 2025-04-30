package az.ingress.jobList.service;

import az.ingress.jobList.dto.JobDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobService {


    Page<JobDto> getAllJobs(Pageable pageable);

    Page<JobDto> filterJobs(String location, String jobType, String experienceLevel, String industry, String keyword,
                            Pageable pageable);


    Page<JobDto> sortJobs(String sortBy, Pageable pageable);

    void scrapeJobs();

}
