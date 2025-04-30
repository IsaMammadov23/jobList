package az.ingress.jobList.service.impl;

import az.ingress.jobList.dto.JobDto;
import az.ingress.jobList.repository.JobRepository;
import az.ingress.jobList.service.JobService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class JobServiceImpl  implements JobService {


    private final JobRepository jobRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<JobDto> getAllJobs(Pageable pageable) {
        return jobRepository.findAll(pageable)
                .map(job -> modelMapper.map(job,JobDto.class));
    }

    @Override
    public Page<JobDto> filterJobs(String location, String jobType, String experienceLevel, String industry, String keyword,
                                   Pageable pageable) {
        if (location != null) {
            return jobRepository.findByLocation(location,pageable)
                    .map(job -> modelMapper.map(job,JobDto.class));
        }
        if (jobType != null) {
            return jobRepository.findByJobType(jobType,pageable)
                    .map(job -> modelMapper.map(job,JobDto.class));
        }
        if (experienceLevel != null) {
            return jobRepository.findByExperienceLevel(experienceLevel,pageable)
                    .map(job -> modelMapper.map(job,JobDto.class));
        }
        if (industry != null) {
            return jobRepository.findByIndustry(industry,pageable)
                    .map(job -> modelMapper.map(job,JobDto.class));
        }
        if (keyword != null) {
            return jobRepository.findByTagsContaining(keyword,pageable)
                    .map(job -> modelMapper.map(job,JobDto.class));
        }
        return jobRepository.findAll(pageable)
                .map(job -> modelMapper.map(job,JobDto.class));
    }

    @Override
    public Page<JobDto> sortJobs(String sortBy, Pageable pageable) {
        Pageable sortedPageable;
        if ("postedDate".equalsIgnoreCase(sortBy)) {
            sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("postedDate"));
        } else if ("salaryRange".equalsIgnoreCase(sortBy)) {
            sortedPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("salaryRange"));
        } else {
            sortedPageable = pageable;
        }
        return jobRepository.findAll(sortedPageable)
                .map(job -> modelMapper.map(job,JobDto.class));
    }

    @Override
    public void scrapeJobs() {

    }
}
