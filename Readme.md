# Spring Boot MongoDB CRUD Application

This is a Spring Boot application that uses MongoDB as its database. It provides REST APIs for CRUD operations and custom queries for various collections.

## Project Overview

The application manages the following collections in MongoDB:
- **PROJECT**
- **PROJECT_VERSION**
- **CONTENT_SUMMARY**
- **ASSET_HASH**
- **DATASET**

### Collections Schema

#### PROJECT
- `id`: String
- `name`: String
- `author`: String
- `description`: String
- `createdTime`: DateTime
- `lastUpdatedBy`: String
- `lastUpdatedTime`: DateTime
- `versionCount`: Integer
- `latestVersionSize`: Integer
- `projectVersions`: List<ProjectVersion>

#### PROJECT_VERSION
- `id`: String
- `s3UrlToArchive`: String
- `parentId`: String
- `projectId`: String
- `author`: String
- `description`: String
- `createdTime`: DateTime
- `lastUpdatedTime`: DateTime
- `size`: Integer
- `exist`: Boolean
- `forcedPush`: Boolean
- `reference`: String
- `scorecard`: String
- `tree`: String
- `dataset`: List<Dataset>
- `tag`: List<String>
- `assetHash`: Map<String, AssetHash>

#### ASSET_HASH
- `assetId`: String
- `assetType`: String
- `lastUpdatedBy`: String
- `lastUpdatedTime`: DateTime
- `hashCode`: String
- `hashAlgorithm`: String

#### DATASET
- `referenceId`: String
- `datasetId`: String
- `sourceId`: String
- `name`: String

## API Endpoints

### PROJECT

- **Create Project**
    - `POST /projects`
    - Request Body: `Project`
    - Response: Created `Project`

- **Get All Projects**
    - `GET /projects`
    - Response: List of `Project`

- **Get Project by ID**
    - `GET /projects/{id}`
    - Response: `Project`

- **Update Project**
    - `PUT /projects/{id}`
    - Request Body: `Project`
    - Response: Updated `Project`

- **Delete Project**
    - `DELETE /projects/{id}`
    - Response: No Content

### PROJECT_VERSION

- **Create Project Version**
    - `POST /project-versions`
    - Request Body: `ProjectVersion`
    - Response: Created `ProjectVersion`

- **Get All Project Versions**
    - `GET /project-versions`
    - Response: List of `ProjectVersion`

- **Get Project Version by ID**
    - `GET /project-versions/{id}`
    - Response: `ProjectVersion`

- **Update Project Version**
    - `PUT /project-versions/{id}`
    - Request Body: `ProjectVersion`
    - Response: Updated `ProjectVersion`

- **Delete Project Version**
    - `DELETE /project-versions/{id}`
    - Response: No Content

- **Find Parent IDs by Project Version ID**
    - `GET /project-versions/parentIds/{projectVersionId}`
    - Response: List of `ProjectVersion` with matching `parentId`

- **Find Child Project IDs by Project Version ID**
    - `GET /project-versions/childProjectIds/{projectVersionId}`
    - Response: List of `ProjectVersion` where `parentId` matches the given `projectVersionId`

### CONTENT_SUMMARY

- **Create Content Summary**
    - `POST /content-summaries`
    - Request Body: `ContentSummary`
    - Response: Created `ContentSummary`

- **Get All Content Summaries**
    - `GET /content-summaries`
    - Response: List of `ContentSummary`

- **Get Content Summary by ID**
    - `GET /content-summaries/{id}`
    - Response: `ContentSummary`

- **Update Content Summary**
    - `PUT /content-summaries/{id}`
    - Request Body: `ContentSummary`
    - Response: Updated `ContentSummary`

- **Delete Content Summary**
    - `DELETE /content-summaries/{id}`
    - Response: No Content

### ASSET_HASH

- **Create Asset Hash**
    - `POST /asset-hashes`
    - Request Body: `AssetHash`
    - Response: Created `AssetHash`

- **Get All Asset Hashes**
    - `GET /asset-hashes`
    - Response: List of `AssetHash`

- **Get Asset Hash by ID**
    - `GET /asset-hashes/{id}`
    - Response: `AssetHash`

- **Update Asset Hash**
    - `PUT /asset-hashes/{id}`
    - Request Body: `AssetHash`
    - Response: Updated `AssetHash`

- **Delete Asset Hash**
    - `DELETE /asset-hashes/{id}`
    - Response: No Content

### DATASET

- **Create Dataset**
    - `POST /datasets`
    - Request Body: `Dataset`
    - Response: Created `Dataset`

- **Get All Datasets**
    - `GET /datasets`
    - Response: List of `Dataset`

- **Get Dataset by ID**
    - `GET /datasets/{id}`
    - Response: `Dataset`

- **Update Dataset**
    - `PUT /datasets/{id}`
    - Request Body: `Dataset`
    - Response: Updated `Dataset`

- **Delete Dataset**
    - `DELETE /datasets/{id}`
    - Response: No Content

## Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/your-repo.git


## Mongo DB

- **List Services:**
    - brew services list

- **Start MongoDB:**
    - brew services start mongodb-community@5.0

- **Stop MongoDB:**
  - brew services stop mongodb-community@5.0

- **Restart MongoDB:**
  - brew services restart mongodb-community@5.0

- **Access Mongo Express UI:**
  - http://localhost:8081/