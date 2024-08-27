package com.example.demo.ui;

import com.example.demo.application.GuestBookService;
import com.example.demo.ui.dto.GuestBookCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guestBook")
public class GuestBookController {

    private final GuestBookService guestBookService;

    @PostMapping()
    public ResponseEntity<Long> createGuestBook(@RequestBody final GuestBookCreateRequest guestBookCreateRequest) {
        final Long guestBookId = guestBookService.save(guestBookCreateRequest);
        return ResponseEntity.ok(guestBookId);
    }
}
