package ua.lviv.lgs.pv.springcore.dto;

import lombok.Data;
import ua.lviv.lgs.pv.springcore.entity.Type;

@Data

public class CategoryDTO {

    private Long id;

    private String name;

    private Type type;
}
