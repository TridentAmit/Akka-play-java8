package enums;

public enum ConfigurationKey {
	SUC_STATUS("profileRead.suc.status"),
	HEALTH_CHECK_MSG("profileRead.healthCheck.msg"),
	PROFILE_READ_VERSION("profileRead.version");
	
	String key;
	ConfigurationKey(String key){
		this.key = key;
	}
	public String getKey() {
		return this.key;
	}

}
