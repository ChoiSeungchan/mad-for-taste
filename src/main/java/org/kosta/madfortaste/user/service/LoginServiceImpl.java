package org.kosta.madfortaste.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kosta.madfortaste.user.dao.LoginDao;
import org.kosta.madfortaste.user.domain.Member;
import org.kosta.madfortaste.user.domain.Owner;
import org.kosta.madfortaste.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public void login(String userId, String password, HttpServletRequest req) {
		User user = loginDao.isExistUser(userId);
		if (user != null) {
			HttpSession session = req.getSession(false);
			if (user instanceof Member) { // 회원일때
				Member member = (Member) user;
				if (password.equals(member.getPassword())) {
					member = loginDao.getMemberInfo(userId);
					session.setAttribute("member", member);
				}

			} else if (user instanceof Owner) { // 업주일때
				Owner owner = (Owner) user;
				if (password.equals(owner.getPassword())) {
					owner = loginDao.getOwnerInfo(userId);
					session.setAttribute("owner", owner);
				}
			}
		}
	}
}
