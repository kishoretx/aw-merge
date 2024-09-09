// DatasetController.java
package com.kk.aw.controller;


import com.kk.aw.model.Dataset;
import com.kk.aw.repository.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/datasets")
public class DatasetController {
    @Autowired
    private DatasetRepository datasetRepository;

    @PostMapping
    public Dataset createDataset(@RequestBody Dataset dataset) {
        return datasetRepository.save(dataset);
    }

    @GetMapping
    public List<Dataset> getAllDatasets() {
        return datasetRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dataset> getDatasetById(@PathVariable String id) {
        return datasetRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Dataset updateDataset(@PathVariable String id, @RequestBody Dataset dataset) {
        dataset.setDatasetId(id);
        return datasetRepository.save(dataset);
    }

    @DeleteMapping("/{id}")
    public void deleteDataset(@PathVariable String id) {
        datasetRepository.deleteById(id);
    }
}
