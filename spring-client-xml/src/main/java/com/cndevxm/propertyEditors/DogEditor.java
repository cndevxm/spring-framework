package com.cndevxm.propertyEditors;

import com.cndevxm.entity.Dog;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;

// Dog 的propertyEditor
public class DogEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isBlank(text) && text.indexOf(",") == -1) {
			throw new IllegalArgumentException("传入参数不正确");
		}
		String[] args = text.split(",");
		Dog dog = new Dog();
		dog.setVariety(args[0]);
		dog.setAge(Integer.valueOf(args[1]));
		dog.setCoat(args[2]);

		super.setValue(dog);
	}
}
