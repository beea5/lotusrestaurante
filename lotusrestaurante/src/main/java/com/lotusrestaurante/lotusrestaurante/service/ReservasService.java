package com.lotusrestaurante.lotusrestaurante.service;

import com.lotusrestaurante.lotusrestaurante.entity.ReservasEntity;
import com.lotusrestaurante.lotusrestaurante.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {

    private final ReservasRepository reservasRepository;

    @Autowired
    public ReservasService(ReservasRepository reservasRepository) {
        this.reservasRepository = reservasRepository;
    }

    public List<ReservasEntity> getAllReservas() {
        return reservasRepository.findAll();
    }

    public Optional<ReservasEntity> getReservaById(Long id) {
        return reservasRepository.findById(id);
    }

    public ReservasEntity saveReserva(ReservasEntity reserva) {
        return reservasRepository.save(reserva);
    }

    public void deleteReserva(Long id) {
        reservasRepository.deleteById(id);
    }
}