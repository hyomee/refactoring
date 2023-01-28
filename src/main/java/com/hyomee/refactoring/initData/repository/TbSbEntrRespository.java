package com.hyomee.refactoring.initData.repository;

import com.hyomee.refactoring.initData.entity.TbSbEntr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbSbEntrRespository extends JpaRepository<TbSbEntr, Long> {

     int countByEntrIdAndProdNo(String entrId, String entrNo);

}
