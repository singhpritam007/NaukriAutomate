package naukri;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.monte.media.Registry;


public class VideoRecorder {

    private static ScreenRecorder screenRecorder;
    private static File currentVideoFile;

    public static void startRecording(final String testName) throws Exception {
        final File videoFolder = new File("E:\\eclipse_backup\\NaukriAutomate\\target\\test-recordings");
        if (!videoFolder.exists()) {
            videoFolder.mkdirs();
        }

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gc,
                gc.getBounds(),
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO,
                        EncodingKey, "tscc",
                        CompressorNameKey, "tscc",
                        DepthKey, 16,
                        FrameRateKey, Rational.valueOf(5, 1),  // Lower frame rate
                        QualityKey, 0.3f,                      // Lower quality
                        KeyFrameIntervalKey, 15 * 60),
                null, null,
                videoFolder) {

            @Override
            protected File createMovieFile(Format fileFormat) throws java.io.IOException {
                currentVideoFile = new File(videoFolder,
                        testName + "-" + System.currentTimeMillis() + "." + Registry.getInstance().getExtension(fileFormat));
                return currentVideoFile;
            }
        };

        screenRecorder.start();
    }

    public static void stopRecording() throws Exception {
        if (screenRecorder != null) {
            screenRecorder.stop();
        }
    }

    public static void deleteRecording() {
        if (currentVideoFile != null && currentVideoFile.exists()) {
            currentVideoFile.delete();
            System.out.println("Recording deleted: " + currentVideoFile.getName());
        }
    }
}
