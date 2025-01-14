import com.ing.model.InternalData;
import com.ing.service.SearchSystemClient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SearchSystemClientTest {

    @Test
    void testSave() {
        SearchSystemClient client = new SearchSystemClient();
        List<InternalData> dataList = new ArrayList<>();
        InternalData data = new InternalData();
        data.setRoomId("Room123");
        data.setStartTimeUTC("1693125331");
        data.setCompanyId("MockCompanyID-Room123");
        data.addMessage("Test message");
        dataList.add(data);

        client.save((InternalData) dataList);
    }
}