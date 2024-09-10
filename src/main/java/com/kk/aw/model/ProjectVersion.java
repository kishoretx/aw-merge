// PROJECT_VERSION.java
package com.kk.aw.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document(collection = "PROJECT_VERSION")
public class ProjectVersion {
    @Id
    private String id;
    private String projectId; // Add this field
    private String s3UrlToArchive;
    private String parentId;
    private String author;
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime lastUpdatedTime;
    private Integer size;
    private Boolean exist;
    private Boolean forcedPush;

    //contentSummary
    private int treeCount;
    private int binningLibraryCount;
    private int inferencesCount;
    private int notebookCount;
    private int scorecardCount;
    private int segementedScorecardCount;

    private List<Dataset> dataset;
    private List<String> tag;
    private Map<String, AssetHash> assetHash;


}
