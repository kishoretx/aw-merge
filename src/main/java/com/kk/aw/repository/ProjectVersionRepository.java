// ProjectVersionRepository.java
package com.kk.aw.repository;


import com.kk.aw.model.ProjectVersion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectVersionRepository extends MongoRepository<ProjectVersion, String> {
    @Query("{ 'parentId': ?0 }")
    List<ProjectVersion> findByParentId(String parentId);

    @Query("{ 'id': ?0 }")
    Optional<ProjectVersion> findById(String id);

    List<ProjectVersion> findByProjectId(String projectId);
    ProjectVersion findByProjectIdAndId(String projectId, String versionId);
}


