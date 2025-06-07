package com.codewithmosh.store.mappers;

import com.codewithmosh.store.dtos.ProductDto;
import com.codewithmosh.store.entities.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toEntity(ProductDto request);

    @AfterMapping
    default void setCategoryId(@MappingTarget ProductDto dto, Product product) {
        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getId());
        }
    }

    @Mapping(target = "id", ignore = true)
    void update(ProductDto request, @MappingTarget Product product);
}
