package edu.examples.orders.service;

import edu.examples.orders.domain.Appointment;

import java.util.List;

public interface TechnicianService {

    List<Appointment> getAppointments();

}
