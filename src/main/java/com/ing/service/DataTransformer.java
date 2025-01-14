package com.ing.service;

import com.ing.model.InternalData;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataTransformer {

    public List<InternalData> transform(File file) throws Exception {
        List<InternalData> dataList = new ArrayList<>();

        // Parse the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);

        NodeList conversations = doc.getElementsByTagName("Conversation");

        for (int i = 0; i < conversations.getLength(); i++) {
            Element conversationElement = (Element) conversations.item(i);

            String roomId = conversationElement.getElementsByTagName("RoomID").item(0).getTextContent();
            String startTimeUTC = conversationElement.getElementsByTagName("StartTimeUTC").item(0).getTextContent();

            InternalData data = new InternalData();
            data.setRoomId(roomId);
            data.setStartTimeUTC(startTimeUTC);

            // Process messages
            NodeList messages = conversationElement.getElementsByTagName("Message");
            for (int j = 0; j < messages.getLength(); j++) {
                Element messageElement = (Element) messages.item(j);
                String content = messageElement.getElementsByTagName("Content").item(0).getTextContent();
                data.addMessage(content);
            }

            dataList.add(data);
        }

        System.out.println("Data transformed successfully.");
        return dataList;
    }
}