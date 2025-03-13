package com.snareclick.server.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/create")
public class CreateController {

    @GetMapping
    public String getMethodName() {
        return "Hello";
    }

}
