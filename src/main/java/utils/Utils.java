package utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Utils {
	public static BufferedImage readFileImage(String path) {
		System.out.println("Path image\n" + path);
		File f = new File(path);
		BufferedImage image;
		try {
			image = ImageIO.read(f);
			return image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String imgToBase64String(final BufferedImage img, final String formatName) {
		final ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			ImageIO.write(img, formatName, os);
			return "data:image/png;base64, " + Base64.getEncoder().encodeToString(os.toByteArray());
		} catch (final IOException ioe) {
			System.err.println("Convert base64 ex " + ioe.toString());
		}
		return null;
	}
	
	public static String imgToBase64StringCore(final BufferedImage img, final String formatName) {
		final ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			ImageIO.write(img, formatName, os);
			return Base64.getEncoder().encodeToString(os.toByteArray());
		} catch (final IOException ioe) {
			System.err.println("Convert base64 ex " + ioe.toString());
		}
		return null;
	}

	public static BufferedImage createQRCode(String key, int width, int height) {
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
			return image;
		} catch (WriterException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String sendGET(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
		}
		return "Not found 404";
	}

	public static String sendPost(String url, String referer, String urlParameters) throws Exception {

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Accept", "*/*");
		con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		con.setRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Authorization", "Client-ID 5598bd10336275d");
		if (referer != null) {
			con.setRequestProperty("Referer", referer);
		}

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		return response.toString();

	}

	public static void doTrustToCertificates() {
		try {
			TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
					// No need to implement.
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
					// No need to implement.
				}
			} };
			// Install the all-trusting trust manager
			try {
				SSLContext sc = SSLContext.getInstance("SSL");
				sc.init(null, trustAllCerts, new java.security.SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
		}
	}
}
