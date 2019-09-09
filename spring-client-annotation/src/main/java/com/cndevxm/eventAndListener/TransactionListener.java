package com.cndevxm.eventAndListener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TransactionListener {

	// 监听提交事务事件
	@TransactionalEventListener(classes = Object.class, phase = TransactionPhase.AFTER_COMMIT)
	public void memberServiceCommitListener(Object object) {
		System.out.println("监控到" + object + "方法发生了事务提交...");
	}

	// 监听回滚事件
	@TransactionalEventListener(classes = Object.class, phase = TransactionPhase.AFTER_ROLLBACK)
	public void memberServiceRollbackListener(Object object) {
		System.out.println("监控到" + object + "方法发生了事务回滚...");
	}
}
