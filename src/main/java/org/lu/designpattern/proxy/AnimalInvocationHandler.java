package org.lu.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class AnimalInvocationHandler implements InvocationHandler {

	private Object realSubject = null;

	public AnimalInvocationHandler(Object realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		Object result = null;
		try {
			List<Class<?>> parameterTypes = Arrays.asList(method
					.getParameterTypes());
			for (Class<?> parameterType : parameterTypes) {
				System.out.println(parameterType.getName());
			}
			args[0] = Integer.valueOf(3);
			result = method.invoke(realSubject, args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
}
