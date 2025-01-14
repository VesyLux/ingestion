import com.ing.model.InternalData;
import com.ing.service.MetadataEnricher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetadataEnricherTest {

    @Test
    void testEnrich() {
        MetadataEnricher enricher = new MetadataEnricher();
        List<InternalData> dataList = new ArrayList<>();
        InternalData data = new InternalData();
        data.setRoomId("Room123");
        dataList.add(data);

        enricher.enrich(dataList);

        assertNotNull(dataList.get(0).getCompanyId());
        assertEquals("MockCompanyID-Room123", dataList.get(0).getCompanyId());
    }
}

