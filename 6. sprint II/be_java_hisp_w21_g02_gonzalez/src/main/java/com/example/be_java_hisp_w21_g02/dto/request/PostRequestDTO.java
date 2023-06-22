package com.example.be_java_hisp_w21_g02.dto.request;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigInteger;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Validated
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostRequestDTO {
    @NotNull(message = "User ID is required")
    @Positive(message = "User ID must be greater than zero")
    private Integer userId;

    @NotNull(message = "Date is required")
    @PastOrPresent(message = "Invalid date, It should be as Past or present date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    private @Valid ProductDTO product;

    @Max(value = 2147483647 , message = "The category value must be an integer with up to 10 digits")
    @NotNull(message = "Category is required")
    private BigInteger category;

    @NotNull(message = "Price is required")
    @Max(value = 10000000,message = "The maximum price of a product is 10000000")
    private Double price;
}
