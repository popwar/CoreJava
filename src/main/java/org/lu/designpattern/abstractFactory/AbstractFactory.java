package org.lu.designpattern.abstractFactory;

public abstract class AbstractFactory<T> implements BaseFactory {

	public abstract T createObject(T t);
}
