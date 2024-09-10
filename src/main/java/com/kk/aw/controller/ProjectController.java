// ProjectController.java
package com.kk.aw.controller;


import com.kk.aw.model.Project;
import com.kk.aw.model.ProjectVersion;
import com.kk.aw.repository.ProjectRepository;
import com.kk.aw.repository.ProjectVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectVersionRepository projectVersionRepository;

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable String id) {
        return projectRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable String id, @RequestBody Project project) {
        project.setId(id);
        return projectRepository.save(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable String id) {
        projectRepository.deleteById(id);
    }

    //--------------------------


    @GetMapping("/{projectId}/versions")
    public List<ProjectVersion> getVersions(@PathVariable String projectId) {
        return projectVersionRepository.findByProjectId(projectId);
    }

    @GetMapping("/{projectId}/versions/{versionId}")
    public ProjectVersion getVersion(@PathVariable String projectId, @PathVariable String versionId) {
        return projectVersionRepository.findByProjectIdAndId(projectId, versionId);
    }

    @GetMapping("/{projectId}/parent-version/{versionId}")
    public ProjectVersion getParentVersion(@PathVariable String projectId, @PathVariable String versionId) {
        ProjectVersion version = projectVersionRepository.findByProjectIdAndId(projectId, versionId);
        if (version != null) {
            return projectVersionRepository.findByProjectIdAndId(projectId, version.getParentId());
        }
        return null;
    }

    @GetMapping("/{projectId}/child-version/{versionId}")
    public List<ProjectVersion> getChildVersions(@PathVariable String projectId, @PathVariable String versionId) {
        List<ProjectVersion> allVersions = projectVersionRepository.findByProjectId(projectId);
        return allVersions.stream()
                .filter(version -> version.getParentId() != null && version.getParentId().equals(versionId))
                .toList();
    }
}
