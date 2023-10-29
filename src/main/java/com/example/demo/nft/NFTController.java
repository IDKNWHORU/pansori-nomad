package com.example.demo.nft;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/nft")
public class NFTController {

    @GetMapping("")
    public String getMessage() {
        return "hello nft";
    }

    @GetMapping("/{id}")
    public String getMessageById(@PathVariable String id) {
        return "hello nft and " + id;
    }

}