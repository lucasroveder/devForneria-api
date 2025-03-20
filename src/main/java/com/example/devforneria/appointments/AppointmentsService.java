package com.example.devforneria.appointments;


import com.example.devforneria.ltable.LTable;
import com.example.devforneria.ltable.LTableRepository;
import com.example.devforneria.ltable.StatusTable;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsService {

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private LTableRepository lTableRepository;

    public List<Appointments> findAll() {
        return appointmentsRepository.findAll();
    }

    public Optional<Appointments> findById(Long id) {
        return appointmentsRepository.findById(id);
    }


    //make a new appointment
    @Transactional
    public Appointments save(Appointments appointments) {
        //search if the table exists
        LTable lTable = lTableRepository.findById(appointments.getTable().getId()).orElseThrow(
                () -> new RuntimeException("Mesa não encontrada"));

        //verify if the table is available
        if (lTable.getStatus() != StatusTable.disponivel){
            throw new RuntimeException("A mesa não está disponivel");
        }

        //update the status and save table
        lTable.setStatus(StatusTable.reservado);
        lTableRepository.save(lTable);


        //return and save the new appointment
        return appointmentsRepository.save(appointments);
    }

    //update an existing appointment
    @Transactional
    public Appointments updateAppointment(Long id, Appointments updatedAppointments) {
        Appointments existingAppointments = appointmentsRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Reserva inexistente"));

        existingAppointments.setUser(updatedAppointments.getUser());
        existingAppointments.setTable(updatedAppointments.getTable());
        existingAppointments.setDateTime(updatedAppointments.getDateTime());
        existingAppointments.setStatus(updatedAppointments.getStatus());

        return appointmentsRepository.save(existingAppointments);
    }

    //cancel an appointment
    @Transactional
    public void deleteAppointment(Long id) {
        Appointments appointments = appointmentsRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Reserva inexistente"));

        //update the table status
        LTable lTable = appointments.getTable();
        lTable.setStatus(StatusTable.disponivel);
        lTableRepository.save(lTable);

        //delete the appointment
        appointmentsRepository.deleteById(id);
    }


}
