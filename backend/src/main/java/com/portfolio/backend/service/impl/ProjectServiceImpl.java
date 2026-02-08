package com.portfolio.backend.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Project;
import com.portfolio.backend.exception.ResourceNotFoundException;
import com.portfolio.backend.repository.ProjectRepository;
import com.portfolio.backend.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository projectRepository;
	public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
	@Override
public Project createProject(Project project) {
    return projectRepository.save(project);
}


	@Override
	public List<Project> getAllProjects() {
		
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectById(Long id) {
		return projectRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
	}

	@Override
	public Project updateProject(Long id, Project project) {
		Project existing = getProjectById(id);
		existing.setTitle(project.getTitle());
        existing.setDescription(project.getDescription());
        existing.setThumbnailUrl(project.getThumbnailUrl());
        existing.setLiveDemoUrl(project.getLiveDemoUrl());
        existing.setSourceCodeUrl(project.getSourceCodeUrl());

        return projectRepository.save(existing);
	}

	@Override
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
		
	}
	@Override
	public Page<Project> getProjects(int page, int size, String sortBy) {
		// TODO Auto-generated method stub
		PageRequest pageable = PageRequest.of(
				page,
				size,
				Sort.by(sortBy).descending()
				);
		
		return projectRepository.findAll(pageable);
	}
	
	
	
}
