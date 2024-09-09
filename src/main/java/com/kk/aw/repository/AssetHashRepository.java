// AssetHashRepository.java
package com.kk.aw.repository;


import com.kk.aw.model.AssetHash;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssetHashRepository extends MongoRepository<AssetHash, String> {
}
