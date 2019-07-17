package com.cndevxm;

import com.cndevxm.entity.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(Teacher.class);
		annotationConfigApplicationContext.refresh();
		Teacher teacher = (Teacher) annotationConfigApplicationContext.getBean("teacher");
		System.out.println(teacher);
	}
}
