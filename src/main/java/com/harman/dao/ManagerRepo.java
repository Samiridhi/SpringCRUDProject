package com.harman.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.harman.entity.Manager;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Integer>{

}
