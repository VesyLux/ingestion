
import com.ing.model.InternalData;
import com.ing.service.DataTransformer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class DataTransformerTest {

    @Test
    void testTransform() throws Exception {
        DataTransformer transformer = new DataTransformer();
        File file = new File("src/test/resources/bloomChat.xml"); // Ensure this file exists
        List<InternalData> dataList = transformer.transform(file);
        assertNotNull(dataList);
        assertFalse(dataList.isEmpty());
        assertEquals("CHAT-fs:58F7B7091930001E", dataList.get(0).getRoomId());
    }
}