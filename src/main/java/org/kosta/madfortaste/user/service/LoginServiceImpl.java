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
	
	@Autowired
	private MemberService memberService;

	@Override
	public boolean login(String userId, String password, HttpServletRequest req) {
		boolean successOrFailure = false;
		User user = loginDao.isExistUser(userId);
		if (user != null) {
			HttpSession session = req.getSession(false);
			if (user instanceof Member) { // 회원일때
				Member member = (Member) user;
				if (password.equals(member.getPassword())) {
					memberService.upExp(userId, 30);
					member = loginDao.getMemberInfo(userId);
					session.setAttribute("member", member);
					successOrFailure = true;
				}

			} else if (user instanceof Owner) { // 업주일때
				Owner owner = (Owner) user;
				if (password.equals(owner.getPassword())) {
					owner = loginDao.getOwnerInfo(userId);
					session.setAttribute("owner", owner);
					successOrFailure = true;
				}
			}
		}
		return successOrFailure;
	}

	@Override
	public void reLogin(User user, HttpSession session, HttpServletRequest req) {
		if(user instanceof Member) {
			Member member = (Member) user;
			member = loginDao.getMemberInfo(member.getId());
			session.setAttribute("member", member);
		} else if (user instanceof Owner) {
			Owner owner = (Owner) user;
			owner = loginDao.getOwnerInfo(owner.getOwnerId());
			session.setAttribute("owner", owner);
		}
	}
}
