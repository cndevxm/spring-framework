package com.cndevxm.service;

import com.cndevxm.entity.Member;

import java.util.List;

public interface MemberService {

	boolean insertMember(Member member);

	boolean updateMember(Member member);

	boolean deleteMember(Member member);

	List<Member> selectMember(Member member);

	boolean insMember(Member member) throws Exception;

}
