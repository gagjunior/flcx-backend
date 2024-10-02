package wareysis.com.br.flcx.models;

import com.google.firebase.auth.UserRecord;

public class UserModel {

	private String uid;
	private String email;
	private String fullName;
	private boolean emailVerified = false;
	private String phoneNumber;
	private String displayName;
	private String photoUrl;
	private boolean disabled = false;
	private String createTime;
	private String updateTime;

	public UserModel() {
		super();
	}

	public UserModel(String email) {
		super();
		this.email = email;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public static UserModel fromUserRecord(UserRecord userRecord, String fullName) {
		UserModel userModel = new UserModel();

		userModel.setDisabled(userRecord.isDisabled());
		userModel.setDisplayName(userRecord.getDisplayName());
		userModel.setEmail(userRecord.getEmail());
		userModel.setEmailVerified(userRecord.isEmailVerified());
		userModel.setFullName(fullName);
		userModel.setPhoneNumber(userRecord.getPhoneNumber());
		userModel.setPhotoUrl(userRecord.getPhotoUrl());
		userModel.setUid(userRecord.getUid());

		return userModel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserModel [uid=");
		builder.append(uid);
		builder.append(", email=");
		builder.append(email);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", emailVerified=");
		builder.append(emailVerified);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", displayName=");
		builder.append(displayName);
		builder.append(", photoUrl=");
		builder.append(photoUrl);
		builder.append(", disabled=");
		builder.append(disabled);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append("]");
		return builder.toString();
	}

}
