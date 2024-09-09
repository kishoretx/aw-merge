// ContentSummaryController.java
package com.example.demo.controller;


import com.kk.aw.model.ContentSummary;
import com.kk.aw.repository.ContentSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/content-summaries")
public class ContentSummaryController {
    @Autowired
    private ContentSummaryRepository contentSummaryRepository;

    @PostMapping
    public ContentSummary createContentSummary(@RequestBody ContentSummary contentSummary) {
        return contentSummaryRepository.save(contentSummary);
    }

    @GetMapping
    public List<ContentSummary> getAllContentSummaries() {
        return contentSummaryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ContentSummary> getContentSummaryById(@PathVariable String id) {
        return contentSummaryRepository.findById(id);
    }

    /*
    @PutMapping("/{id}")
    public ContentSummary updateContentSummary(@PathVariable String id, @RequestBody ContentSummary contentSummary) {
        contentSummary.setId(id);
        return contentSummaryRepository.save(contentSummary);
    }
    */

    @DeleteMapping("/{id}")
    public void deleteContentSummary(@PathVariable String id) {
        contentSummaryRepository.deleteById(id);
    }
}
