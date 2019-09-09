package com.cndevxm.entity;

public class Org {

	private String id;
	private String orgId;
	private String orgName;

	public Org() {
	}

	public Org(String id, String orgId, String orgName) {
		this.id = id;
		this.orgId = orgId;
		this.orgName = orgName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Override
	public String toString() {
		return "Org{" +
				"id='" + id + '\'' +
				", orgId='" + orgId + '\'' +
				", orgName='" + orgName + '\'' +
				'}';
	}
}
