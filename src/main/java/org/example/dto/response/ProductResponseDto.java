package org.example.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {
private String name;
private String productUrl;
private double price;
private int quantity;
private String info;
private String categoryName;
private double discount;
}