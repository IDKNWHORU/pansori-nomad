package com.example.demo.nft;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/nft")
public class NFTController {

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getMessageById(@PathVariable String id) {
        return ResponseEntity.ok(new HashMap<>() {
            {
                put("name", "whoru");
                put("description", "leon_cave");
            }
        });
    }

    @PostMapping("/{id}")
    public ResponseEntity<Map<String, String>> createNft(@PathVariable String id,
            @RequestParam String name,
            @RequestParam String description) {
        return ResponseEntity.ok(new HashMap<>() {
            {
                put("type", "create");
                put("name", name);
                put("description", description);
            }
        });
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateNft(@PathVariable String id,
            @RequestParam String name,
            @RequestParam String description) {
        return ResponseEntity.ok(new HashMap<>() {
            {
                put("type", "update");
                put("name", name);
                put("description", description);
            }
        });
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