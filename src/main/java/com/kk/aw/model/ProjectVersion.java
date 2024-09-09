// PROJECT_VERSION.java
package com.kk.aw.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document(collection = "PROJECT_VERSION")
public class ProjectVersion {
    @Id
    private String id;
    private String s3UrlToArchive;
    private String parentId;
    private String author;
    private String description;
    private LocalDateTime createdTime;
    private LocalDateTime lastUpdatedTime;
    private Integer size;
    private Boolean exist;
    private Boolean forcedPush;
    private ContentSummary contentSummary;

}
