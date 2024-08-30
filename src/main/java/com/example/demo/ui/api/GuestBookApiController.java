package com.example.demo.ui.api;

import com.example.demo.application.GuestBookService;
import com.example.demo.ui.dto.GuestBookCreateRequest;
import com.example.demo.ui.dto.GuestBookResponse;
import com.example.demo.ui.dto.GuestBookUpdateRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/guestBook")
public class GuestBookApiController {

    private final GuestBookService guestBookService;

    @PostMapping()
    public ResponseEntity<Long> createGuestBook(@RequestBody final GuestBookCreateRequest guestBookCreateRequest) {
        final Long guestBookId = guestBookService.save(guestBookCreateRequest);
        return ResponseEntity.ok(guestBookId);
    }

    @GetMapping("/{guestBookId}")
    public ResponseEntity<GuestBookResponse> readGuestBook(@PathVariable("guestBookId") final Long guestBookId) {
        final GuestBookResponse guestBookResponse = guestBookService.readGuestBook(guestBookId);
        return ResponseEntity.ok(guestBookResponse);
    }

    @GetMapping("/guestBooks")
    public ResponseEntity<List<GuestBookResponse>> readGuestBooks() {
        final List<GuestBookResponse> guestBookResponses = guestBookService.readGuestBooks();
        return ResponseEntity.ok(guestBookResponses);
    }

    @PutMapping("/{guestBookId}")
    public ResponseEntity<Void> updateGuestBook(
            @PathVariable("guestBookId") final Long guestBookId,
            @RequestBody final GuestBookUpdateRequest guestBookUpdateRequest) {
        guestBookService.updateGuestBook(guestBookId, guestBookUpdateRequest);
        return ResponseEntity.ok().build();
    }
}
