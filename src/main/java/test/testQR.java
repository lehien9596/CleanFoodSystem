package test;

import java.awt.CardLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import utils.Utils;

public class testQR {
	private static ImageIcon createQRCode(String key, int width, int height) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            int white = 255 << 16 | 255 << 8 | 255;
            int black = 0;
            BitMatrix bitMatrix = writer.encode(key, BarcodeFormat.QR_CODE, width, height);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    image.setRGB(i, j, bitMatrix.get(i, j) ? black : white);
                }
            }
            return new ImageIcon(image);
        } catch (WriterException ex) {
            ex.printStackTrace();
        }
        return null;
    }
 
    public static void main(String[] args) {
    	 BufferedImage bufferedImage = Utils.createQRCode("xsdfA4", 256, 256);
         if (bufferedImage==null) {
         	return;
         }
         
         //String sss = Utils.imgToBase64String(bufferedImage, "png");
    }
    
    public void test() {
    	JPanel panel = new JPanel();
        panel.setLayout(new CardLayout());
        JLabel label = new JLabel();
        label.setIcon(createQRCode("Hien -", 400, 400));
        panel.add(label);
        panel.setLayout(new CardLayout());
        JFrame frame = new JFrame();
        frame.setLayout(new CardLayout());
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
 

}
