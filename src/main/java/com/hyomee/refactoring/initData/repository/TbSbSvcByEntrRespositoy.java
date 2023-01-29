package com.hyomee.refactoring.initData.repository;

import com.hyomee.refactoring.initData.entity.TbSbSvcByEntr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbSbSvcByEntrRespositoy extends JpaRepository<TbSbSvcByEntr, Long> {

    List<TbSbSvcByEntr> findByEntrId(String  entrId);
}
