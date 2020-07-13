package ua.lviv.lgs.pv.springcore.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.lviv.lgs.pv.springcore.dto.TransactionDTO;
import ua.lviv.lgs.pv.springcore.entity.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "category.id", target = "categoryId")
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(source = "categoryId", target = "category.id")
    Transaction toEntity(TransactionDTO transactionDTO);
}
