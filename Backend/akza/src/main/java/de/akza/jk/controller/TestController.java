package de.akza.jk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public ResponseEntity<String> getHelloMessage() {
        return ResponseEntity.ok("This is an unsecure Endpoint!");
    }

    @GetMapping("/secure-hello")
    public ResponseEntity<String> getSecureHelloMessage() {
        return ResponseEntity.ok("This is a secure Endpoint!");
    }

    @GetMapping("/some-test")
    public ResponseEntity<String> getTestMessage() {
        return ResponseEntity.ok("This is a Test-Message");
    }
}
