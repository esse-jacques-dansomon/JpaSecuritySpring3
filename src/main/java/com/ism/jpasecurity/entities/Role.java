package com.ism.jpasecurity.entities;

/**
 * Author  : essejacaues.co
 * Date    : 24/06/2023 01:49
 * Project : JpaSecurity
 */

import lombok.*;
import jakarta.persistence.*;


import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<User> users;

}
