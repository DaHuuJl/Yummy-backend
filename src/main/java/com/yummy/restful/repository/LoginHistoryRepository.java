package com.yummy.restful.repository;

import com.yummy.restful.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
  List<LoginHistory> findAllByUser(Long userId);
}
