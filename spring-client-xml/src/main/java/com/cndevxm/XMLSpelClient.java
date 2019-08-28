package com.cndevxm;

import com.cndevxm.entity.Company;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;

/**
 * 基于XML配置的application
 */
public class XMLSpelClient {

	public static void main(String[] args) {

		// 基于类路径的xml文件配置
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-spel.xml");

		// profile
		applicationContext.getEnvironment().setActiveProfiles("prod");
		applicationContext.refresh();

		ExpressionParser parser = new SpelExpressionParser();
		// 字面值
		System.out.println(parser.parseExpression("'Hello World!'").getValue());
		// 方法
		System.out.println(parser.parseExpression("'Hello World'.concat('!')").getValue());
		// 属性
		System.out.println(parser.parseExpression("'Hello World'.bytes").getValue());
		// 级联操作
		System.out.println(parser.parseExpression("'Hello World'.bytes.length").getValue());
		// 构造函数
		System.out.println(parser.parseExpression("new String('hello world').toUpperCase()").getValue());

		// 使用<T> T getValue(@Nullable Class<T> desiredResultType)方法，转换失败爆出异常

		// 对跟对象进行操作
		Company company = new Company();
		company.setName("中移动");
		System.out.println(parser.parseExpression("name").getValue(company));
		System.out.println(parser.parseExpression("name == '中移动'").getValue(company, Boolean.class));

		// 使用Spelparserconfiguration 对表达式组件行为进行控制
		SpelParserConfiguration spelParserConfiguration = new SpelParserConfiguration(true, true);
		SpelExpressionParser spelExpressionParser = new SpelExpressionParser(spelParserConfiguration);
		Expression expression = spelExpressionParser.parseExpression("list[3]");
		ListDemo listDemo = new ListDemo();
		System.out.println(expression.getValue(listDemo).equals(""));

		// spel编译器模式
		// 1、通过SpelParserConfiguration进行编译器模式配置
		// 2、通过spring.expression.compiler.mode属性进行配置

		// spel在bean definitions中的使用
		// 使用#{expression string}形式 定义表达式
		System.out.println(applicationContext.getBean("firstRandom").toString());
		System.out.println(applicationContext.getBean("jdbcDemo").toString());
		System.out.println(applicationContext.getBean("jdbcDemo1").toString());


		applicationContext.registerShutdownHook();
	}

	static class ListDemo {
		public List<String> list;
	}

	static class RandomDemo {
		private double randow;

		public RandomDemo() {
		}

		public double getRandow() {
			return randow;
		}

		public void setRandow(double randow) {
			this.randow = randow;
		}

		@Override
		public String toString() {
			return "RandomDemo{" +
					"randow=" + randow +
					'}';
		}
	}

	static class JdbcDemo {

		private String driver;
		private String url;

		public JdbcDemo() {
		}

		public void setDriver(String driver) {
			this.driver = driver;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getDriver() {
			return driver;
		}

		public String getUrl() {
			return url;
		}

		@Override
		public String toString() {
			return "JdbcDemo{" +
					"driver='" + driver + '\'' +
					", url='" + url + '\'' +
					'}';
		}
	}
}