package com.example.demo.ui.dto;

public record GuestBookUpdateRequest(
        String name,
        String content
) {
}
