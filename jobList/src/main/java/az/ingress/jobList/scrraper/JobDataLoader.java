package az.ingress.jobList.scrraper;

import az.ingress.jobList.model.Job;
import az.ingress.jobList.repository.JobRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j

public class JobDataLoader implements CommandLineRunner {

    private final JobRepository jobRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public JobDataLoader(JobRepository jobRepository, ObjectMapper objectMapper) {
        this.jobRepository = jobRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (jobRepository.count() == 0) {
            loadJobsFromJson();
        }
    }

    private void loadJobsFromJson() {
        try {
            Resource resource = new ClassPathResource("data/jobs.json");
            List<Job> jobs = objectMapper.readValue(resource.getInputStream(),
                    new TypeReference<List<Job>>() {});
            jobRepository.saveAll(jobs);
            log.info("Successfully loaded {} jobs from JSON", jobs.size());
        } catch (IOException e) {
            log.error("Error loading jobs from JSON", e);
        }
    }
}
