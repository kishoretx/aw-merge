package com.kk.aw.controller;


import com.kk.aw.model.ProjectVersion;
import com.kk.aw.repository.ProjectVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project-versions")
public class ProjectVersionController {
    @Autowired
    private ProjectVersionRepository projectVersionRepository;

    @PostMapping
    public ProjectVersion createProjectVersion(@RequestBody ProjectVersion projectVersion) {
        return projectVersionRepository.save(projectVersion);
    }

    @GetMapping
    public List<ProjectVersion> getAllProjectVersions() {
        return projectVersionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Optional<ProjectVersion>> getProjectVersionById(@PathVariable String id) {
        return Optional.ofNullable(projectVersionRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ProjectVersion updateProjectVersion(@PathVariable String id, @RequestBody ProjectVersion projectVersion) {
        projectVersion.setId(id);
        return projectVersionRepository.save(projectVersion);
    }

    @DeleteMapping("/{id}")
    public void deleteProjectVersion(@PathVariable String id) {
        projectVersionRepository.deleteById(id);
    }



    @GetMapping("/childProjectIds/{projectVersionId}")
    public List<ProjectVersion> findChildProjectIds(@PathVariable String projectVersionId) {
        List<ProjectVersion> versions = projectVersionRepository.findByParentId(projectVersionId);
        return versions; // Assuming child project IDs are indirectly obtained via versions
    }


    @GetMapping("/parentIds/{projectVersionId}")
    public Optional<ProjectVersion>findParentIds(@PathVariable String projectVersionId) {

        Optional<ProjectVersion> projectVersion = (projectVersionRepository.findById(projectVersionId));
        System.out.println("childProjectVersion: " + projectVersion.get().getParentId());
        String parentId = projectVersion.get().getParentId();

        return projectVersionRepository.findById(parentId);
    }
}
