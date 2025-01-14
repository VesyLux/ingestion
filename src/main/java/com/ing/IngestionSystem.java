package com.ing;

import com.ing.model.InternalData;
import com.ing.service.DataTransformer;
import com.ing.service.MetadataEnricher;
import com.ing.service.SearchSystemClient;
import com.ing.service.SourceFileDownloader;

import java.io.File;
import java.util.List;

public class IngestionSystem {

    private final SourceFileDownloader fileDownloader;
    private final DataTransformer dataTransformer;
    private final MetadataEnricher metadataEnricher;
    private final SearchSystemClient searchSystemClient;

    public IngestionSystem(SourceFileDownloader fileDownloader, DataTransformer dataTransformer, MetadataEnricher metadataEnricher, SearchSystemClient searchSystemClient) {
        this.fileDownloader = fileDownloader;
        this.dataTransformer = dataTransformer;
        this.metadataEnricher = metadataEnricher;
        this.searchSystemClient = searchSystemClient;
    }

    public void ingest(String filePath) {
        try {
            // Step 1: Download Source
            File sourceFile = fileDownloader.downloadSource(filePath);

            // Step 2: Transform Data
            List<InternalData> transformedData = dataTransformer.transform(sourceFile);

            // Step 3: Enrich Data
            metadataEnricher.enrich((List<InternalData>) transformedData);

            // Step 4: Save to Search System
            searchSystemClient.save((InternalData) transformedData);

            System.out.println("Ingestion process completed successfully.");
        } catch (Exception e) {
            System.err.println("Error during ingestion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/resources/bloomChat.xml";

        SourceFileDownloader fileDownloader = new SourceFileDownloader();
        DataTransformer dataTransformer = new DataTransformer();
        MetadataEnricher metadataEnricher = new MetadataEnricher();
        SearchSystemClient searchSystemClient = new SearchSystemClient();

        IngestionSystem ingestionSystem = new IngestionSystem(fileDownloader, dataTransformer, metadataEnricher, searchSystemClient);
        ingestionSystem.ingest(filePath);
    }
}