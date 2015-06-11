package org.kosta.madfortaste.user.service;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

	void login(String userId, String password, HttpServletRequest req);

}
