// DATASET.java
package com.kk.aw.model;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Dataset {
    private String referenceId;
    private String datasetId;
    private String sourceId;
    private String name;
}
