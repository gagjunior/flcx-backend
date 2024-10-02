package wareysis.com.br.flcx.repositories;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import javax.annotation.Nullable;

import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentChange;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.FirestoreException;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

import wareysis.com.br.flcx.config.FirebaseConfig;
import wareysis.com.br.flcx.models.UserModel;

@Repository
public class UserRepository {

	public Optional<UserModel> createNewUser(String email, String password, String fullName) {
		CreateRequest request = new CreateRequest().setEmail(email).setPassword(password);
		Optional<UserModel> userModel = Optional.empty();
		Optional<UserRecord> userRecord = Optional.empty();
		try {
			userRecord = Optional.ofNullable(FirebaseAuth.getInstance().createUser(request));
			if (userRecord.isPresent()) {

				userModel = Optional.ofNullable(UserModel.fromUserRecord(userRecord.get(), fullName));

				if (userModel.isPresent()) {
					userModel.get().setCreateTime(new Date().toInstant().toString());
					FirebaseConfig.db().collection("users").document(userRecord.get().getEmail()).set(userModel.get());
				}

			}
		} catch (FirebaseAuthException e) {
			e.printStackTrace();
		}
		return userModel;
	}

	public Optional<UserModel> getUserByEmail(String email) {
		Optional<UserRecord> userRecord = Optional.empty();
		

		FirebaseConfig.db().collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
			public void onEvent(@Nullable QuerySnapshot documentSnapshots, @Nullable FirestoreException error) {
				for (QueryDocumentSnapshot documentChange : documentSnapshots.getDocuments()){
					System.out.println("Full Name -> " + documentChange.toObject(UserModel.class).getFullName().toString());
				}		
			}
        });


		return Optional.empty();

	}

}
