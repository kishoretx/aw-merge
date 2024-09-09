// AssetHashController.java
package com.kk.aw.controller;


import com.kk.aw.model.AssetHash;
import com.kk.aw.repository.AssetHashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asset-hashes")
public class AssetHashController {
    @Autowired
    private AssetHashRepository assetHashRepository;

    @PostMapping
    public AssetHash createAssetHash(@RequestBody AssetHash assetHash) {
        return assetHashRepository.save(assetHash);
    }

    @GetMapping
    public List<AssetHash> getAllAssetHashes() {
        return assetHashRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AssetHash> getAssetHashById(@PathVariable String id) {
        return assetHashRepository.findById(id);
    }

    @PutMapping("/{id}")
    public AssetHash updateAssetHash(@PathVariable String id, @RequestBody AssetHash assetHash) {
        assetHash.setAssetId(id);
        return assetHashRepository.save(assetHash);
    }

    @DeleteMapping("/{id}")
    public void deleteAssetHash(@PathVariable String id) {
        assetHashRepository.deleteById(id);
    }
}
