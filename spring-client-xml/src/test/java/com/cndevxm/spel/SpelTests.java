package com.cndevxm.spel;

import org.junit.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Spel 测试类
 */
public class SpelTests {

	@Test
	public void testSpel() {
		// spel语言参考
		ExpressionParser parser = new SpelExpressionParser();
		// 字面量
		System.out.println("********字面量*********");
		System.out.println(parser.parseExpression("'Hello World'").getValue());
		System.out.println(parser.parseExpression("6.0221415E+23").getValue());
		System.out.println(parser.parseExpression("0x7FFFFFFF").getValue());
		System.out.println(parser.parseExpression("true").getValue());
		System.out.println(parser.parseExpression("null").getValue());

		System.out.println("********字面量*********");
	}
}
