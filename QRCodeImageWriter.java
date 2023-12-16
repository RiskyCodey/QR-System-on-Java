package idproject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QRCodeImageWriter {

    public static void generateAndSaveQRCode(String userInputString, String filePath) {
        Map<EncodeHintType, Object> hintMap = new HashMap<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hintMap.put(EncodeHintType.MARGIN, 1);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            int size = 300; // QR code size
            BitMatrix bitMatrix = new MultiFormatWriter().encode(userInputString, BarcodeFormat.QR_CODE, size, size, hintMap);
            BufferedImage qrImage = toBufferedImage(bitMatrix);

            // Load the icon/image
            BufferedImage icon = ImageIO.read(new File("C:\\Users\\candi\\Downloads\\ICONS BG.png"));

            // Calculate the position to center the icon on the QR code
            int xPos = (qrImage.getWidth() - icon.getWidth()) / 2;
            int yPos = (qrImage.getHeight() - icon.getHeight()) / 2;

            // Create a Graphics2D object to draw the composite image
            Graphics2D g2d = qrImage.createGraphics();
            g2d.drawImage(icon, xPos, yPos, null);
            g2d.dispose();

            saveAsPNG(qrImage, filePath);

        } catch (WriterException | IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to save QR Code",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF; // Black or White color
                image.setRGB(x, y, rgb);
            }
        }
        return image;
    }

    private static void saveAsPNG(BufferedImage image, String filePath) throws IOException {
        File file = new File(filePath);
        ImageIO.write(image, "png", file);
    }
}