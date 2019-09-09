package com.cndevxm.service;

import com.cndevxm.entity.Org;

import java.util.List;

public interface OrgService {

	void insertOrg(Org org);

	void updateOrg(Org org);

	void deleteOrg(Org org);

	List<Org> selectOrg(Org org);

}
