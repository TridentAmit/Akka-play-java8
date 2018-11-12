package handlers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.JsonNode;

import model.ErrorResponse;
import play.http.HttpErrorHandler;
import play.libs.Json;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import play.mvc.Results;

@Singleton
public class ErrorHandler implements HttpErrorHandler {
    public CompletionStage<Result> onClientError(RequestHeader request, int statusCode, String message) {
        return CompletableFuture.completedFuture(
                Results.status(statusCode, "A client error occurred: " + message)
        );
    }

    public CompletionStage<Result> onServerError(RequestHeader request, Throwable exception) {
        return CompletableFuture.completedFuture(
                Results.internalServerError("A server error occurred: " + exception.getMessage())
        );
    }
    
	public Result onServerError(Throwable exception) {
		final JsonNode json ;
		final int status ;
		if(exception instanceof CompletionException) {
			exception = exception.getCause();
		}
		if (exception instanceof NullPointerException) {
			json = Json.toJson(new ErrorResponse("A1", "A2", "A3"));
			status =501;
		} else if (exception instanceof NumberFormatException) {
			json = Json.toJson(new ErrorResponse("B1", "B2", "B3"));
			status =502;
		}else {
			json = Json.toJson(new ErrorResponse("C1", "C2", "C3"));
			status =503;
		}
		return Results.status(status, json);
	}
}
