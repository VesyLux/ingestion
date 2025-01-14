package com.ing;

import com.ing.model.InternalData;
import com.ing.service.DataTransformer;
import com.ing.service.MetadataEnricher;
import com.ing.service.SearchSystemClient;
import com.ing.service.SourceFileDownloader;

import java.io.File;

public class IngestionSystem {
    private final SourceFileDownloader downloader = new SourceFileDownloader();
    private final DataTransformer transformer = new DataTransformer();
    private final MetadataEnricher enricher = new MetadataEnricher();
    private final SearchSystemClient searchClient = new SearchSystemClient();

    public void ingest(String filePath) throws Exception {
        File sourceFile = downloader.downloadSource(filePath);
        InternalData internalData = transformer.transform(sourceFile);
        enricher.enrich(internalData);
        searchClient.save(internalData);
    }

    public static void main(String[] args) {
        try {
            new IngestionSystem().ingest("src/main/resources/bloomChat.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}