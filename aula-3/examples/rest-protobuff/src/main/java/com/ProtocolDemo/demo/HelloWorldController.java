package com.ProtocolDemo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public String helloWorld(){
        HelloWorldOuterClass.HelloWorld helloWorld = HelloWorldOuterClass.HelloWorld.newBuilder().setHelloWorld("Hello World").build();
        return helloWorld.toString();
    }
}
