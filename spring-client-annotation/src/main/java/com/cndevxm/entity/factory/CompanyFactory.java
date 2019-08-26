package com.cndevxm.entity.factory;

import com.cndevxm.annotations.profiles.Dev;
import com.cndevxm.annotations.profiles.Prod;
import com.cndevxm.annotations.profiles.Test;
import com.cndevxm.entity.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CompanyFactory {

	@Dev
	@Bean("company")
	public Company companyForDev() {
		Company company = new Company();
		company.setName("开发环境公司");
		return company;
	}

	@Test
	@Bean("company")
	public Company companyForTest() {
		Company company = new Company();
		company.setName("测试环境公司");
		return company;
	}

	@Prod
	@Bean("company")
	public Company companyForProd() {
		Company company = new Company();
		company.setName("生产环境公司");
		return company;
	}


}
