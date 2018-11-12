package dao;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import model.ProfileReadResponse;

public class ProfileReadDao {
	private List<ProfileReadResponse> profileReadList(){
		ProfileReadResponse response = new ProfileReadResponse();
		response.setAcid("id1");
		response.setCsid("1234567890");
		response.setfName("Judith");
		response.sethAddress("USA");
		response.setlName("Simons");
		response.setoAddress("Marriott");
		response.setmNumber("123456");
		return Arrays.asList(response);
	}
	public CompletableFuture<ProfileReadResponse> getProfileReadData(String acid) {
		ProfileReadResponse r = new ProfileReadResponse();
		if(acid.equalsIgnoreCase("420")) {
			r.setT(new NumberFormatException("Wrong inpput"));
			return CompletableFuture.supplyAsync(()->r);
		}
		List<ProfileReadResponse> prList = profileReadList().stream().filter(p ->p.getAcid().equalsIgnoreCase(acid)).collect(Collectors.toList());
		return prList.isEmpty() ? CompletableFuture.supplyAsync(()->{r.setT(new NullPointerException("No data found"));
																	return r;}) : CompletableFuture.supplyAsync(()->prList.get(0));
	}

}
