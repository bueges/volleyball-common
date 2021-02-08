package volleyball.tools.downloader;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class FileDownloaderTest {

    @Test
    @DisplayName("download a csv file")
    public void downloadCSVFile() throws MalformedURLException {
        URL url = new URL("https://www.hvbv.de/servlet/league/PlayingScheduleCsvExport?matchSeriesId=9936936");
        Optional<Path> path = FileDownloader.downloadFileFromURL(url);

        assertTrue(path.isPresent());
    }

    @Test
    @DisplayName("download file form invalid URL")
    public void downloadFileFromInvalidURL() throws MalformedURLException {
        URL url = new URL("https://www.hvbv.de/servlet/PlayingScheduleCsvExport?matchSeriesId=9936936");
        Optional<Path> path = FileDownloader.downloadFileFromURL(url);

        assertFalse(path.isPresent());
    }
}