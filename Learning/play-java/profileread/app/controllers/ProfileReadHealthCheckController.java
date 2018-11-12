package controllers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import com.google.inject.Inject;

import play.mvc.Controller;
import play.mvc.Result;
import util.FunctionalUtility;

public class ProfileReadHealthCheckController extends Controller {
	private FunctionalUtility functionalUtility;
	
	@Inject
	ProfileReadHealthCheckController(FunctionalUtility functionalUtility) {
		this.functionalUtility = functionalUtility;
	}
	
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public CompletionStage<Result> getStatus() {
    			return 	CompletableFuture.supplyAsync(()->functionalUtility.healthCheckRespose.get());
    }
}
