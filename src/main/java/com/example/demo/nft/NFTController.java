package com.example.demo.nft;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/{id}")
    public boolean createNft(@PathVariable String id,
            @RequestParam String a) {
        return true;
    }

    @GetMapping("/image")
    public ResponseEntity<Resource> showImage() {
        try {
            Resource image = new ClassPathResource("static/images/image.jpg");

                return ResponseEntity.ok()
                    .header("Content-Type", "image/jpeg")
                    .body(image);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}