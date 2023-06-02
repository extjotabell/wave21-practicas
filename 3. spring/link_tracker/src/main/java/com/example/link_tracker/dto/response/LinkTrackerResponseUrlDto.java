package com.example.link_tracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LinkTrackerResponseUrlDto {

    String url;
    Integer visited;
    boolean valid;
}
