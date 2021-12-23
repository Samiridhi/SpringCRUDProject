package com.harman.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harman.entity.Emp;

@Repository
public interface EmpRepo extends JpaRepository<Emp, Integer>{

	public List<Emp> findByEmpDesignation(String designation);
	public List<Emp> findByEmpPManager(String manager);
}
