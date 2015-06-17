package org.kosta.madfortaste.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.madfortaste.user.domain.User;

public interface LoginService {

	void login(String userId, String password, HttpServletRequest req);

	void reLogin(User user, HttpSession session, HttpServletRequest req);

}
