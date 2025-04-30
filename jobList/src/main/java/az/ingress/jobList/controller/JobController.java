package az.ingress.jobList.controller;

import az.ingress.jobList.dto.JobDto;
import az.ingress.jobList.model.Job;
import az.ingress.jobList.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/jobs")
public class JobController {

    private final JobService jobService;


    @GetMapping
    public Page<JobDto> getAllJobs(Pageable pageable) {
        return jobService.getAllJobs(pageable);
    }


    @GetMapping("/filter")
    public Page<JobDto> filterJobs(@RequestParam(required = false) String location,
                                   @RequestParam(required = false) String jobType,
                                   @RequestParam(required = false) String experienceLevel,
                                   @RequestParam(required = false) String industry,
                                   @RequestParam(required = false) String keyword,
                                   Pageable pageable) {
        return jobService.filterJobs(location, jobType, experienceLevel, industry, keyword,pageable);
    }

    @GetMapping("/sort")
    public Page<JobDto> sortJobs(@RequestParam String sortBy,Pageable pageable) {
        return jobService.sortJobs(sortBy,pageable);
    }

    @PostMapping("/scrape")
    public void scrapeJobs() {
        jobService.scrapeJobs();
    }
}
