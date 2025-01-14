

import com.ing.service.SourceFileDownloader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SourceFileDownloaderTest {

    @Test
    void testDownloadSource() throws Exception {
        SourceFileDownloader downloader = new SourceFileDownloader();
        String filePath = "src/test/resources/bloomChat.xml"; // Ensure this file exists
        File file = downloader.downloadSource(filePath);
        assertNotNull(file);
        assertTrue(file.exists());
        assertEquals("bloomChat.xml", file.getName());
    }

    @Test
    void testFileNotFound() {
        SourceFileDownloader downloader = new SourceFileDownloader();
        Exception exception = assertThrows(IOException.class, () -> downloader.downloadSource("invalid/path.xml"));
        assertEquals("Source file not found at path: src/test/resources/bloomChat.xml", exception.getMessage());
    }
}
