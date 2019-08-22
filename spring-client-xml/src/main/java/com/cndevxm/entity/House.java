package com.cndevxm.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class House {

	// 地址
	private String address;

	// 固话
	private String fixedLine;

	// 房屋类型
	private String type;

	// 房屋属性
	private Properties properties;
	private List list;
	private Set set;
	private Map map;

	public House() {
	}

	public House(String address, String fixedLine, Properties properties, List list, Set set, Map map) {
		this.address = address;
		this.fixedLine = fixedLine;
		this.properties = properties;
		this.list = list;
		this.set = set;
		this.map = map;
	}

	public House(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFixedLine() {
		return fixedLine;
	}

	public void setFixedLine(String fixedLine) {
		this.fixedLine = fixedLine;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "House{" +
				"address='" + address + '\'' +
				", fixedLine='" + fixedLine + '\'' +
				", properties=" + properties +
				", list=" + list +
				", set=" + set +
				", map=" + map +
				'}';
	}
}
