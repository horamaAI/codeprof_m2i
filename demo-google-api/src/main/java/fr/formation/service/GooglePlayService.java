package fr.formation.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.androidpublisher.AndroidPublisher;
import com.google.api.services.androidpublisher.AndroidPublisherScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

@Service
public class GooglePlayService {
	@Value("classpath:/credentials.json")
	private Resource credentialJson;
	
	private AndroidPublisher publisher;
	
	public void createPublisherService() throws GeneralSecurityException, IOException {
		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
		
		GoogleCredentials credential = GoogleCredentials
				.fromStream(this.credentialJson.getInputStream())
				.createScoped(Collections.singleton(AndroidPublisherScopes.ANDROIDPUBLISHER));
		
		this.publisher = new AndroidPublisher
			.Builder(httpTransport, jsonFactory, new HttpCredentialsAdapter(credential))
			.setApplicationName("DemoCgi")
			.build();
	}
}