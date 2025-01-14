import com.ing.model.InternalData;

import java.util.ArrayList;
import java.util.List;

public class MockData {
    public static List<InternalData> getInternalDataList() {
        List<InternalData> dataList = new ArrayList<>();
        InternalData data = new InternalData();
        data.setRoomId("Room123");
        data.setStartTimeUTC("1693125331");
        data.setCompanyId("MockCompanyID-Room123");
        data.addMessage("Test message");
        dataList.add(data);
        return dataList;
    }
}
