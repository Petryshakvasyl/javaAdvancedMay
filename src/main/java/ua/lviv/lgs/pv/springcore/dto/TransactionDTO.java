package ua.lviv.lgs.pv.springcore.dto;

import lombok.Data;
import ua.lviv.lgs.pv.springcore.entity.Type;

import java.math.BigDecimal;

@Data
public class TransactionDTO {

    private Long id;

    private BigDecimal amount;

    private String date;

    private String description;

    private Type type;

    private Long categoryId;
}
