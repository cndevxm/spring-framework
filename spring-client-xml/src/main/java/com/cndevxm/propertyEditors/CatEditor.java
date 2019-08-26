package com.cndevxm.propertyEditors;

import com.cndevxm.entity.Cat;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;

// Dog 的propertyEditor
public class CatEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isBlank(text) && text.indexOf(",") == -1) {
			throw new IllegalArgumentException("传入参数不正确");
		}
		String[] args = text.split(",");
		Cat cat = new Cat();
		cat.setVariety(args[0]);
		cat.setAge(Integer.valueOf(args[1]));
		cat.setCoat(args[2]);

		super.setValue(cat);
	}
}
