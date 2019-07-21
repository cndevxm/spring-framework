package com.cndevxm.entity;

public class House {

	private String address;

	private String fixedLine;

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

	@Override
	public String toString() {
		return "House{" +
				"address='" + address + '\'' +
				", fixedLine='" + fixedLine + '\'' +
				'}';
	}
}
