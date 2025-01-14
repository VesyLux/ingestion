import com.ing.IngestionSystem;
import com.ing.service.DataTransformer;
import com.ing.service.MetadataEnricher;
import com.ing.service.SearchSystemClient;
import com.ing.service.SourceFileDownloader;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.mockito.Mockito.*;

class IngestionSystemTest {

    @Test
    void testIngest() throws Exception {
        // Mock dependencies
        SourceFileDownloader mockDownloader = mock(SourceFileDownloader.class);
        DataTransformer mockTransformer = mock(DataTransformer.class);
        MetadataEnricher mockEnricher = mock(MetadataEnricher.class);
        SearchSystemClient mockSearchClient = mock(SearchSystemClient.class);

        File mockFile = new File("src/test/resources/sample.xml");
        when(mockDownloader.downloadSource(anyString())).thenReturn(mockFile);
        when(mockTransformer.transform(mockFile)).thenReturn(MockData.getInternalDataList());

        IngestionSystem ingestionSystem = new IngestionSystem(mockDownloader, mockTransformer, mockEnricher, mockSearchClient);
        ingestionSystem.ingest("src/test/resources/sample.xml");

        verify(mockDownloader).downloadSource(anyString());
        verify(mockTransformer).transform(mockFile);
        verify(mockEnricher).enrich(anyList());
        verify(mockSearchClient).save((com.ing.model.InternalData) anyList());
    }
}