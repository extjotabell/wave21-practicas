package com.example.link_tracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LinkTrackerRequestIdPassword {

    String id;
    String password;
}
