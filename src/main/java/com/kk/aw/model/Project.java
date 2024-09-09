// PROJECT.java
package com.kk.aw.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document(collection = "PROJECT")
public class Project {
    @Id
    private String id;
    private String name;
    private String author;
    private String description;
    private LocalDateTime createdTime;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedTime;
    private Integer versionCount;
    private Integer latestVersionSize;
    private List<ProjectVersion> projectVersions;

}
