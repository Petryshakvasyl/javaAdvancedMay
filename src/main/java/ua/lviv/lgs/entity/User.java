package ua.lviv.lgs.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString

@EqualsAndHashCode(exclude = "greatingValue")

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery( name = "queryName", query = "select u from User u")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Transient
    private String greatingValue;

}
