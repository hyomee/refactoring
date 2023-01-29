package com.hyomee.refactoring.initData.controller;

import com.hyomee.refactoring.initData.dto.TbEntrAllDTO;
import com.hyomee.refactoring.initData.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class BusinessController {


    private final BusinessService businessService;

    @GetMapping(path ="/findAllEntrByEntrId/{entrId}",  produces = "application/json")
    public TbEntrAllDTO findAllEntrByEntrId(@PathVariable("entrId") String entrId) {
        return businessService.findByAllEntr(entrId);
    }


}
