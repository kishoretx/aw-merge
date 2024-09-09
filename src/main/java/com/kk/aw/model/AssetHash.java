// ASSET_HASH.java
package com.kk.aw.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "ASSET_HASH")
public class AssetHash {
    @Id
    private String assetId;
    private String assetType;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdatedTime;
    private String hashCode;
    private String hashAlgorithm;


}
