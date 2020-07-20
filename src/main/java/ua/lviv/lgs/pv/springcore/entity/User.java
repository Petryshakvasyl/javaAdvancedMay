package ua.lviv.lgs.pv.springcore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    private MoneyAccount currentAccount;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<MoneyAccount> moneyAccounts = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Category> categories = new HashSet<>();


}
