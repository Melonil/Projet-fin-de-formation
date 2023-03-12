package com.m2i.java.service;

import java.util.Collection;

public interface CRUDService<TDTO> {
	public Collection<TDTO> list(int limit);
	public TDTO create(TDTO t);
	public TDTO update(TDTO t);
	public TDTO get(Long id);
	public Boolean delete(Long id);
}
