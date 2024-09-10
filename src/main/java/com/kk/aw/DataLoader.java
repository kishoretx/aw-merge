package com.kk.aw;


import com.kk.aw.model.*;
import com.kk.aw.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.*;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(
            ProjectRepository projectRepository,
            ProjectVersionRepository projectVersionRepository,
            //ContentSummaryRepository contentSummaryRepository,
            AssetHashRepository assetHashRepository,
            DatasetRepository datasetRepository) {
        return args -> {
            // Create AssetHash data
            AssetHash assetHash1 = new AssetHash("asset1", "Tree", "user1", LocalDateTime.now(), "6GKKJKHNMDTTHKTDZ56", "SHA-256");
            AssetHash assetHash2 = new AssetHash("asset2", "Scorecard", "user2", LocalDateTime.now(), "8GKKJKHNMDHKUUTDZ90", "SHA-512");
            AssetHash assetHash3 = new AssetHash("asset3", "Notebook", "user3", LocalDateTime.now(), "0GKKJKKKHNMDHKTDZ27", "SHA-256");
            AssetHash assetHash4 = new AssetHash("asset4", "BinningLibrary", "user4", LocalDateTime.now(), "9GKKJKHNMDHKTDHHZ99", "SHA-512");


            assetHashRepository.saveAll(Arrays.asList(assetHash1, assetHash2, assetHash3, assetHash4));

            // Create Dataset data
            Dataset dataset1 = new Dataset("ds_ref1", "dataset1", "source1", "Dataset One");
            Dataset dataset2 = new Dataset("ds_ref2", "dataset2", "source2", "Dataset Two");
            Dataset dataset3 = new Dataset("ds_ref3", "dataset3", "source3", "Dataset Three");
            datasetRepository.saveAll(Arrays.asList(dataset1, dataset2, dataset3));

            // Create ContentSummary data
            Map<String, AssetHash> assetHashMap = new HashMap<>();
            assetHashMap.put("asset1", assetHash1);
            assetHashMap.put("asset2", assetHash2);
            assetHashMap.put("asset3", assetHash3);
            assetHashMap.put("asset4", assetHash4);
            //ContentSummary contentSummary = new ContentSummary(12, 5, 3, 7, 4, 9,  Arrays.asList(dataset1, dataset2, dataset3), Arrays.asList("tag1", "tag2"), assetHashMap);
            //contentSummaryRepository.save(contentSummary);

            // Create Projects and Versions
            List<Project> projects = new ArrayList<>();
            List<ProjectVersion> allVersions = new ArrayList<>();

            for (int i = 1; i <= 10; i++) {
                // Create Project
                Project project = new Project(
                        "project" + i,
                        "Project " + i,
                        "author" + i,
                        "Project " + i + " Description",
                        LocalDateTime.now(),
                        "user" + i,
                        LocalDateTime.now(),
                        0, // Will be updated based on versions count
                        0, // Will be updated based on versions size
                        new ArrayList<>()
                );

                // Create between 2 and 7 versions for each project
                int numVersions = new Random().nextInt(6) + 2; // Random number between 2 and 7
                List<ProjectVersion> projectVersions = new ArrayList<>();

                // Create versions first
                for (int j = 1; j <= numVersions; j++) {
                    ProjectVersion projectVersion = new ProjectVersion(
                            "version" + (i * 10 + j),
                            "project" + i, //@KK
                            "s3://bucket/archive" + (i * 10 + j),
                            null, // parentId will be set later
                            "author" + i,
                            "Project Version " + (i * 10 + j) + " Description",
                            LocalDateTime.now(),
                            LocalDateTime.now(),
                            100 + j * 10, // Size increment based on version
                            true,
                            false,
                            //contentSummary
                            12, 5, 3, 7, 4, 9,  Arrays.asList(dataset1, dataset2, dataset3), Arrays.asList("tag1", "tag2"), assetHashMap
                    );

                    projectVersions.add(projectVersion);
                }

                // Set parentId for each version (except the first one)
                for (int j = 1; j < numVersions; j++) {
                    projectVersions.get(j).setParentId(projectVersions.get(j - 1).getId());
                }

                // Save versions
                projectVersionRepository.saveAll(projectVersions);

                // Update Project with version count and latest version size
                project.setVersionCount(numVersions);
                project.setLatestVersionSize(projectVersions.get(numVersions - 1).getSize());
                project.setProjectVersions(projectVersions);

                projects.add(project);
            }

            // Save all projects
            projectRepository.saveAll(projects);
        };
    }
}
