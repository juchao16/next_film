package com.next.juc.film.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/example/")
@Api("ExampleController的相关Api")
public class ExampleController {

    @GetMapping(value = "test")
    @ApiOperation(value = "测试Swagger",notes = "测试Swagger的notes")
    @ApiImplicitParam(name = "test",value = "入参test",paramType = "query",required = true,dataType = "string")
    public String  test(@RequestParam("test") String test){
        System.out.println("test="+test);
        return  "test="+test;
    }
}
