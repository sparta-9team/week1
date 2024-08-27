package com.example.demo.ui.dto;

public record GuestBookCreateRequest(
        String name,
        String content
) {
}
