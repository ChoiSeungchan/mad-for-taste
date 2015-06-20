package org.kosta.madfortaste.user.dao;

import java.util.List;
import java.util.Map;

import org.kosta.madfortaste.common.lib.Page;
import org.kosta.madfortaste.user.domain.Member;

public interface MemberDao {

	public abstract Member insertMember(Member member);

	public abstract Member selectMemberById(String id);

	public abstract int selectTotalCount();

	public abstract List<Member> selectMemberList(Page page);

	public abstract void updateMember(Member member);

	public abstract void deleteMember(String id);

	public abstract void upExp(String id, int acquiredExp);

	public abstract void upPoint(String id, int acquiredPoint);

	public abstract void downPoint(String id, int lostPoint);

	public abstract void insertDailyCheckTime(String id);

	public abstract int GetDailyCheckedMember(Map<String, Object> map);

	public abstract void updateDailyCheck(String id);

}