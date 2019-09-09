package com.cndevxm.service.impl;

import com.cndevxm.entity.Org;
import com.cndevxm.service.OrgService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 使用编程式事务
public class OrgServiceImpl implements OrgService {

	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate transactionTemplate;
	private PlatformTransactionManager txManager;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void setTxManager(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}

	@Override
	public void insertOrg(Org org) {

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				String insertSql = "insert into org(id,orgId,orgName) values(uuid(),?,?)";
				jdbcTemplate.update(insertSql, org.getOrgId(), org.getOrgName());
			}
		});
	}

	@Override
	public void updateOrg(Org org) {
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		// 设置隔离级别
		transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
		// 设置传播方式
		transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus transactionStatus = txManager.getTransaction(transactionDefinition);

		try {
			String updateSql = "update org set orgId=? , orgName=? where id=?";
			jdbcTemplate.update(updateSql, org.getOrgId(), org.getOrgName(), org.getId());
		} catch (Exception e) {
			txManager.rollback(transactionStatus);
			throw e;
		}
		txManager.commit(transactionStatus);
	}

	@Override
	public void deleteOrg(Org org) {

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				String deleteSql = "delete from org where id=?";
				jdbcTemplate.update(deleteSql, org.getId());
				status.setRollbackOnly();
			}
		});
	}


	@Override
	public List<Org> selectOrg(Org org) {
		String querySql = "select id,orgId,orgName from org where 1=1";
		if (StringUtils.isNotBlank(org.getId())) {
			querySql += " and id = '" + org.getId() + "'";
		}
		if (StringUtils.isNotBlank(org.getOrgId())) {
			querySql += " and orgId = '" + org.getOrgId() + "'";
		}
		if (StringUtils.isNotBlank(org.getOrgName())) {
			querySql += " and orgName = '" + org.getOrgName() + "'";
		}
		List<Org> list = new ArrayList<>();

		// 采用流式处理
//		jdbcTemplate.query(querySql, new RowCallbackHandler() {
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				Org org = new Org();
//				org.setId(rs.getString("id"));
//				org.setOrgId(rs.getString("orgId"));
//				org.setOrgName(rs.getString("orgName"));
//				list.add(org);
//			}
//		});

		// 采用批量化处理
		list = jdbcTemplate.query(querySql, new RowMapper<Org>() {

			@Override
			public Org mapRow(ResultSet rs, int rowNum) throws SQLException {
				Org org = new Org();
				org.setId(rs.getString("id"));
				org.setOrgId(rs.getString("orgId"));
				org.setOrgName(rs.getString("orgName"));
				return org;
			}
		});
		return list;
	}

}
