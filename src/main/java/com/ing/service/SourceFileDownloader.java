package com.ing.service;

import java.io.File;

public class SourceFileDownloader {

    public File downloadSource(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("File not found at: " + filePath);
        }
        System.out.println("Source file downloaded from: " + filePath);
        return file;
    }
}