package org.kosta.madfortaste.user.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.kosta.madfortaste.user.domain.Member;

public interface MemberService {
	
	public abstract Member insertMember(Member member, HttpServletRequest req) throws IllegalStateException, IOException;

	public abstract Member selectMemberById(String id);

	public abstract int selectTotalCount();

	public abstract List<Member> selectMemberList(int currentPage);

	public abstract void updateMember(Member member, HttpServletRequest req) throws IllegalStateException, IOException;

	public abstract void deleteMember(String id);

	public abstract void upExp(String id, int acquiredExp);

	public abstract void upPoint(String id, int acquiredPoint);

	public abstract void downPoint(String id, int lostPoint);
	
	public abstract void insertDailyCheckTime(String id);
	
	public int GetDailyCheckedMember(String id);

	public boolean dailyCheck(String id);
	
}
