package com.ing.service;

import com.ing.model.InternalData;

import java.util.List;

public class MetadataEnricher {

    public void enrich(List<InternalData> dataList) {
        for (InternalData data : dataList) {
            data.setCompanyId("MockCompanyID-" + data.getRoomId());
        }
        System.out.println("Data enriched successfully.");
    }
}