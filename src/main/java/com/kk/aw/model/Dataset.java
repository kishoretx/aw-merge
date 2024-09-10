// DATASET.java
package com.kk.aw.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Dataset {
    @Id
    private String referenceId;
    private String datasetId;
    private String sourceId;
    private String name;
}
