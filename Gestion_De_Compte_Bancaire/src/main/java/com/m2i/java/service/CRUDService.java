package com.m2i.java.service;

import java.util.Collection;

public interface CRUDService<T> {
	public Collection<T> list(int limit);
	public T create(T t);
	public T update(T t);
	public T get(Long id);
	public Boolean delete(Long id);
}
