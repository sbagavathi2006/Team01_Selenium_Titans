package utilities;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoogleDriveDownloader {


	public static void downloadExcelFromDrive(String fileId, String localFilePath) throws Exception {
		String downloadUrl = "https://docs.google.com/spreadsheets/d/" + fileId + "/export?format=xlsx";
		URL url = new URL(downloadUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Cache-Control", "no-cache");
		connection.connect();

		int responseCode = connection.getResponseCode();
		if (responseCode != 200) {
			throw new RuntimeException(
					"Failed to download file from Google Drive. HTTP Response Code: " + responseCode);
		}

		try (InputStream in = connection.getInputStream(); FileOutputStream out = new FileOutputStream(localFilePath)) {

			byte[] buffer = new byte[4096];
			int bytesRead;

			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
		}

		System.out.println("Downloaded Excel from Google Drive to: " + localFilePath);
	}
	
}
