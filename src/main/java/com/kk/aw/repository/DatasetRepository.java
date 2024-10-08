// DatasetRepository.java
package com.kk.aw.repository;

import com.kk.aw.model.Dataset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasetRepository extends MongoRepository<Dataset, String> {
}
