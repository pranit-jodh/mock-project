package com.test.dunder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.dunder.entity.Paper;

@Repository
public interface PaperRepo extends JpaRepository<Paper, Integer>{

}
