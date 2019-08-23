package com.cndevxm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("modelHouse")
public class ModelHouse {

	@Autowired
	@Qualifier("gc")
	private House gc;

	@Autowired
	@Qualifier("yf")
	private House yf;

	// 地址
	private String address;

	// 固话
	private String fixedLine;

	// 房屋类型
	private String type;

	// 房屋属性
	private Properties properties = new Properties() {{
		put("brand", "万科地产");
		put("englishName", "vanke");
	}};
	private List list = new ArrayList() {{
		add("碧桂园地产");
		add(gc);
	}};
	private Set set = new HashSet() {{
		add("恒大地产");
		add(gc);
	}};
	private Map map = new HashMap() {{
		put("brand", "万达地产");
		put("house", yf);
	}};

	public Properties getProperties() {
		return properties;
	}

	public List getList() {
		return list;
	}

	public Set getSet() {
		return set;
	}

	public Map getMap() {
		return map;
	}
}
