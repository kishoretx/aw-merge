// ContentSummaryRepository.java
package com.kk.aw.repository;

import com.kk.aw.model.ContentSummary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentSummaryRepository extends MongoRepository<ContentSummary, String> {
}
