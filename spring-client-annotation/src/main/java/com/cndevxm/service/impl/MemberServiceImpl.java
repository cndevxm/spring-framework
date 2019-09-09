package com.cndevxm.service.impl;

import com.cndevxm.entity.Member;
import com.cndevxm.service.MemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	@Transactional(transactionManager = "txManager")
	public boolean insertMember(Member member) {
		String insertSql = "insert into member(id,name,age,idCard) values(uuid(),?,?,?)";
		jdbcTemplate.update(insertSql, member.getName(), member.getAge(), member.getIdCard());
		applicationEventPublisher.publishEvent("insert");
		return true;
	}

	@Override
	@Transactional(transactionManager = "txManager")
	public boolean updateMember(Member member) {
		String updateSql = "update member set name=? , age=? , idCard=? where id=?";
		jdbcTemplate.update(updateSql, member.getName(), member.getAge(), member.getIdCard(), member.getId());
		return true;
	}

	@Override
	@Transactional(transactionManager = "txManager")
	public boolean deleteMember(Member member) {
		String deleteSql = "delete from member where id=?";
		jdbcTemplate.update(deleteSql, member.getId());
		return true;
	}

	@Override
	@Transactional(transactionManager = "txManager")
	public List<Member> selectMember(Member member) {
		String querySql = "select * from member where 1=1";
		if (StringUtils.isNotBlank(member.getId())) {
			querySql += " and id = '" + member.getId() + "'";
		}
		if (StringUtils.isNotBlank(member.getName())) {
			querySql += " and name = '" + member.getName() + "'";
		}
		if (member.getAge() != 0) {
			querySql += " and age = " + member.getAge();
		}
		if (StringUtils.isNotBlank(member.getIdCard())) {
			querySql += " and idCard = '" + member.getIdCard() + "'";
		}
		List<Member> members = new ArrayList<>();
		jdbcTemplate.query(querySql, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setIdCard(rs.getString("idCard"));
				members.add(member);
			}
		});
		return members;
	}

	// 未添加声明式事务管理会首先执行第一条sql，再抛出异常
	@Override
	public boolean insMember(Member member) {
		String insertSql = "insert into member(id,name,age,idCard) values(uuid(),?,?,?)";
		jdbcTemplate.update(insertSql, member.getName(), member.getAge(), member.getIdCard());
		if (0 == 0) {
			throw new RuntimeException("运行时异常");
		}
		jdbcTemplate.update(insertSql, member.getName(), member.getAge(), member.getIdCard());
		return true;
	}
}
