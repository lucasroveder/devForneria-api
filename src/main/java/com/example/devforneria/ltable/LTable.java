package com.example.devforneria.ltable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ltable")
public class LTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int name;

    @Column(nullable = false)
    private int capacity;

    @Enumerated(EnumType.STRING)
    private StatusTable status = StatusTable.disponivel;

}

