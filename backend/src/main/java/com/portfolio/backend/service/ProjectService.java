package com.portfolio.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.portfolio.backend.entity.Project;

public interface ProjectService {
	Project createProject(Project project);

    List<Project> getAllProjects();

    Project getProjectById(Long id);

    Project updateProject(Long id, Project project);
    Page<Project> getProjects(int page, int size, String sortBy);

    void deleteProject(Long id);
}
