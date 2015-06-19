package org.kosta.madfortaste.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.madfortaste.user.domain.User;

public interface LoginService {

	public boolean login(String userId, String password, HttpServletRequest req);
	
	public void reLogin(User user, HttpSession session, HttpServletRequest req);

}
