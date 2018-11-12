package controllers;

import java.util.concurrent.CompletionStage;

import com.google.inject.Inject;

import handlers.ErrorHandler;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import service.ProfileReadService;

public class ProfileReadController extends Controller {
	
	private final ProfileReadService profileReadService;
	private final ErrorHandler errorHandler;
	@Inject
	ProfileReadController(ProfileReadService profileReadService, ErrorHandler errorHandler) {
		this.profileReadService = profileReadService;
		this.errorHandler = errorHandler;
	}
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public CompletionStage<Result> getReadData() {
    	Http.Headers headers = request().getHeaders();
    	String acid = headers.get("ACID").orElse("1234");
    return profileReadService.getProfileReadData(acid)
    		.thenApply(pr -> {
    			if(pr.getT() != null) {
    				return errorHandler.onServerError(pr.getT());
    			}
    			return ok(Json.toJson(pr));
    		}).exceptionally(errorHandler::onServerError);
    }
}
