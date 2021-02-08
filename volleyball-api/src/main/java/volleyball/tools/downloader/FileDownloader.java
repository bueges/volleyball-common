package volleyball.tools.downloader;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Slf4j
public class FileDownloader {

    /**
     * download a file from a source url
     *
     * @param sourceURL - the source url
     * @return the path of the downloaded file location
     */
    public static Optional<Path> downloadFileFromURL(URL sourceURL) {
        Optional<Path> targetPath = Optional.empty();

        if (sourceURL != null) {
            try {
                String fileName = "tmp_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss")) + ".tmp";
                Path path = Paths.get("downloads", fileName);

                log.info("download file from URL : {}", sourceURL);
                FileUtils.copyURLToFile(sourceURL, path.toFile());
                log.info("save file at : {}", path.toFile());

                targetPath = Optional.of(path);
            } catch (IOException e) {
                log.error("an IOException occurred during downloading a file from : {}", sourceURL);
                e.printStackTrace();
            }
        }

        return targetPath;
    }
}
