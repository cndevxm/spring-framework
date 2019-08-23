package com.cndevxm.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Component
public class House {

	@Autowired
	@Qualifier("modelHouse")
	private ModelHouse modelHouse;

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

	// 使用自动注入parentBean和初始化方法来完成parentBean属性的继承
	@PostConstruct
	public void init() {
		this.properties = modelHouse.getProperties();
		this.list = modelHouse.getList();
		this.set = modelHouse.getSet();
		this.map = modelHouse.getMap();
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
