package wareysis.com.br.flcx.config;

import org.springframework.context.annotation.Configuration;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

import jakarta.annotation.PostConstruct;

@Configuration
public class FirebaseConfig {

	@PostConstruct
	public void firebaseInitialize() {
		if (FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp();
		}
	}

	public static Firestore db() {
		return FirestoreClient.getFirestore();
	}
}
