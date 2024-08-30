package com.example.demo.application;

import com.example.demo.domain.GuestBook;
import com.example.demo.domain.GuestBookRepository;
import com.example.demo.ui.dto.GuestBookCreateRequest;
import com.example.demo.ui.dto.GuestBookResponse;
import com.example.demo.ui.dto.GuestBookUpdateRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class GuestBookService {

    private final GuestBookRepository guestBookRepository;

    public Long save(final GuestBookCreateRequest guestBookCreateRequest) {
        final GuestBook guestBook = GuestBook.from(guestBookCreateRequest);
        final GuestBook savedGuestBook = guestBookRepository.save(guestBook);
        return savedGuestBook.getId();
    }

    public GuestBookResponse readGuestBook(final Long guestBookId) {
        final GuestBook guestBook = guestBookRepository.findById(guestBookId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id에 해당하는 방명록은 없습니다."));
        return GuestBookResponse.from(guestBook);
    }

    public List<GuestBookResponse> readGuestBooks() {
        final List<GuestBook> guestBooks = guestBookRepository.findAll();
        return GuestBookResponse.from(guestBooks);
    }

    public void updateGuestBook(final Long guestBookId,
                                final GuestBookUpdateRequest guestBookUpdateRequest) {
        final GuestBook guestBook = guestBookRepository.findById(guestBookId)
                .orElseThrow(() -> new IllegalArgumentException("해당 id에 해당하는 방명록은 없습니다."));
        guestBook.update(guestBookUpdateRequest);
    }
}
