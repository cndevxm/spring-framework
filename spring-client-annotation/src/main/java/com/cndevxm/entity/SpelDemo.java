package com.cndevxm.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("spelDemo")
public class SpelDemo {

	@Value("#{ T(java.lang.Math).random() }")
	private double random;

	@Value("#{@systemProperties['jdbc.driver']}")
	private String deiver;

	@Value("#{systemProperties['JAVA_HOME']}")
	private String url;

	public void setRandom(double random) {
		this.random = random;
	}

	public void setDeiver(String deiver) {
		this.deiver = deiver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getRandom() {
		return random;
	}

	public String getDeiver() {
		return deiver;
	}

	public String getUrl() {
		return url;
	}

	public SpelDemo() {
	}

	@Override
	public String toString() {
		return "SpelDemo{" +
				"random=" + random +
				", deiver='" + deiver + '\'' +
				", url='" + url + '\'' +
				'}';
	}
}
