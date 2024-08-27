package com.example.demo.application;

import com.example.demo.domain.GuestBook;
import com.example.demo.domain.GuestBookRepository;
import com.example.demo.ui.dto.GuestBookCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    public Long save(final GuestBookCreateRequest guestBookCreateRequest) {
        final GuestBook guestBook = GuestBook.of(guestBookCreateRequest);
        final GuestBook savedGuestBook = guestBookRepository.save(guestBook);
        return savedGuestBook.getId();
    }
}
