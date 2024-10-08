package com.example.demo.domain;

import com.example.demo.ui.dto.GuestBookCreateRequest;
import com.example.demo.ui.dto.GuestBookUpdateRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuestBook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    private GuestBook(final String name, final String content) {
        this.name = name;
        this.content = content;
    }

    public static GuestBook from(final GuestBookCreateRequest guestBookCreateRequest) {
        return new GuestBook(guestBookCreateRequest.name(), guestBookCreateRequest.content());
    }

    public void update(final GuestBookUpdateRequest guestBookUpdateRequest){
        this.name = guestBookUpdateRequest.name();
        this.content = guestBookUpdateRequest.content();
    }
}
