package ua.lviv.lgs.pv.springcore.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "money_account")
public class MoneyAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal initialBalance;

    private Instant initialDate;

    // TODO: 08.07.2020 add Currency
    @OneToOne
    private Currency currency;

}
