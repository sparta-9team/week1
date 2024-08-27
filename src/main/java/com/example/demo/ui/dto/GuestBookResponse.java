package com.example.demo.ui.dto;

import com.example.demo.domain.GuestBook;
import java.util.List;

public record GuestBookResponse(
        String name,
        String content
) {

    public static GuestBookResponse from(final GuestBook guestBook) {
        return new GuestBookResponse(guestBook.getName(), guestBook.getContent());
    }

    public static List<GuestBookResponse> from(final List<GuestBook> guestBooks) {
        return guestBooks.stream()
                .map(GuestBookResponse::from)
                .toList();
    }
}
