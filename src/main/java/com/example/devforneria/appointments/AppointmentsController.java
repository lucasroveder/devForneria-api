package com.example.devforneria.appointments;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;

    @GetMapping
    public List<Appointments> findAll() {
        return appointmentsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointments> findById(@PathVariable Long id) {
        return appointmentsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Appointments createAppointment(@RequestBody Appointments appointments) {
        return appointmentsService.save(appointments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointments> updateAppointment(@PathVariable Long id, @RequestBody Appointments updatedAppointments) {
        try{
            Appointments appointments = appointmentsService.updateAppointment(id, updatedAppointments);
            return ResponseEntity.ok(appointments);
        }
        catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long id) {
        Appointments updatedAppointment = appointmentsService.findById(id).get();
        updatedAppointment.setStatus(StatusAppointment.cancelada);
        appointmentsService.updateAppointment(id, updatedAppointment);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentsService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
