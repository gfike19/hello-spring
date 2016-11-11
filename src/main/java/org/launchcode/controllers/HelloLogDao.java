package org.launchcode.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.models.HelloLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface HelloLogDao extends CrudRepository<HelloLog, Integer> {
	
	public List<HelloLog> findAll();
	public HelloLog findByUid(Integer uid);
//	public List<HelloLog> findByName(String name);
}
