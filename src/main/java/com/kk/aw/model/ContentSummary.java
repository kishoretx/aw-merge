// CONTENT_SUMMARY.java
package com.kk.aw.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ContentSummary {
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
