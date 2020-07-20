package ua.lviv.lgs.pv.springcore.dto;

import lombok.Data;
import ua.lviv.lgs.pv.springcore.controller.validators.DateConstrain;
import ua.lviv.lgs.pv.springcore.entity.Type;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
public class TransactionDTO {

    private Long id;

    @NotNull(message = "Yuo must provide amount")
    @Min(value = 1, message = "you must provide valid amount")
    private BigDecimal amount;
    @DateConstrain
    private String date;

    @NotBlank
    private String description;

    @NotNull
    private Type type;
    @NotNull
    private Long categoryId;
}
