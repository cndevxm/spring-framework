package com.cndevxm;

import com.cndevxm.entity.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.registerBean("teacher", Teacher.ChineseTeacher.class);
		annotationConfigApplicationContext.refresh();
		Teacher.ChineseTeacher teacher = (Teacher.ChineseTeacher) annotationConfigApplicationContext.getBean("teacher");
		System.out.println(teacher);
		System.out.println(annotationConfigApplicationContext.getBeanDefinition("teacher").getBeanClassName());
	}
}
