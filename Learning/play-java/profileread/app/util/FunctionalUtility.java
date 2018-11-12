package util;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.typesafe.config.Config;

import enums.ConfigurationKey;
import model.ProfileReadHealthCheckResponse;
import play.libs.Json;
import play.mvc.Result;

public class FunctionalUtility {
	private Config config;
	
	@Inject
	FunctionalUtility(Config config) {
		this.config = config;
	}
	
	public final Supplier<Result> healthCheckRespose = (()->play.mvc.Results.status(config.getInt(ConfigurationKey.SUC_STATUS.getKey())
				, Json.toJson( new ProfileReadHealthCheckResponse(config.getInt(ConfigurationKey.SUC_STATUS.getKey())
						, config.getString(ConfigurationKey.PROFILE_READ_VERSION.getKey())
						, config.getString(ConfigurationKey.HEALTH_CHECK_MSG.getKey()))))
	);
}
