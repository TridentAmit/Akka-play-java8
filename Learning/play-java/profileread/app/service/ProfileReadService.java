package service;

import java.util.concurrent.CompletableFuture;

import com.google.inject.Inject;

import dao.ProfileReadDao;
import model.ProfileReadResponse;

public class ProfileReadService {
	ProfileReadDao profileReadDao;
	
	@Inject
	public ProfileReadService(ProfileReadDao profileReadDao) {
		this.profileReadDao = profileReadDao;
	}
	public CompletableFuture<ProfileReadResponse> getProfileReadData(String acid) {
		return profileReadDao.getProfileReadData(acid);
	}

}
