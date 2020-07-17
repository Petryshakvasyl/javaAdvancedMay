package ua.lviv.lgs.pv.springcore.service.mapper;

import org.mapstruct.Mapper;
import ua.lviv.lgs.pv.springcore.dto.CategoryDTO;
import ua.lviv.lgs.pv.springcore.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    Category toEntity(CategoryDTO categoryDTO);
}
