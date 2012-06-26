package com.logus.hephaestus.model.repository;

import java.io.Serializable;
import java.util.List;

import com.logus.hephaestus.model.Model;

public interface Repository<T extends Model<ID>, ID extends Serializable> {

	T persist(T entity);

	void persist(List<T> entities);

	Boolean remove(T entity);

	T findById(ID id);

	public List<T> findAll();
}