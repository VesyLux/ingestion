package com.ing.service;

import com.ing.model.InternalData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DataTransformer {
    public InternalData transform(File file) throws Exception {
        JAXBContext context = JAXBContext.newInstance(InternalData.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (InternalData) unmarshaller.unmarshal(file);
    }
}