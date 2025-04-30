package az.ingress.jobList.repository;

import az.ingress.jobList.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

    Page<Job> findByLocation(String location, Pageable pageable);
    Page<Job> findByJobType(String jobType, Pageable pageable);
    Page<Job> findByExperienceLevel(String experienceLevel, Pageable pageable);
    Page<Job> findByIndustry(String industry, Pageable pageable);
    Page<Job> findByTagsContaining(String tag, Pageable pageable);
}
