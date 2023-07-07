package com.example.demo.dto;

import java.util.List;

public record ErrorDTO(String msg, List<String> description) {
}
