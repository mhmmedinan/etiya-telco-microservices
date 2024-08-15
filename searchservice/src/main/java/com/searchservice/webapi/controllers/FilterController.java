package com.searchservice.webapi.controllers;

import com.searchservice.entities.Customer;
import com.searchservice.services.abstracts.FilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/search")
@RequiredArgsConstructor
public class FilterController {

    private final FilterService filterService;

    @GetMapping
    public List<Customer> getList(){
        return filterService.getList();
    }

    @GetMapping("getbyfirstname")
    public Customer getByFirstName(@RequestParam String firstName){
        return filterService.getByFirstName(firstName);
    }
}
