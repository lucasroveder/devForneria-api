package com.example.devforneria.appointments;

import com.example.devforneria.ltable.LTable;
import com.example.devforneria.users.Users;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private LTable table;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAppointment status = StatusAppointment.pendente;

}
