package fr.formation.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.androidpublisher.AndroidPublisher;
import com.google.api.services.androidpublisher.AndroidPublisherScopes;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

@Service
public class GoogleSheetService {
	@Value("classpath:/credentials.json")
	private Resource credentialJson;
	
	private Sheets sheet;
	
	public void createSheetService() throws GeneralSecurityException, IOException {
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
		
		GoogleCredentials credential = GoogleCredentials
				.fromStream(this.credentialJson.getInputStream())
				.createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
		
		this.sheet = new Sheets
			.Builder(httpTransport, jsonFactory, new HttpCredentialsAdapter(credential))
			.setApplicationName("DemoCgi")
			.build();
	}
	
	public void read() throws IOException {
        final String spreadsheetId = "10YgqTjyqOjkhw9SNaB2LJSRTOdwyo9YhXruf9WVAvxM";
        final String range = "Feuille 1!A2:B";
        
        ValueRange response = this.sheet.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        
        List<List<Object>> values = response.getValues();
        
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        }
        
        else {
            System.out.println("ColA, ColB");
            for (List row : values) {
                System.out.printf("%s, %s\n", row.get(0), row.get(1));
            }
        }
	}
}