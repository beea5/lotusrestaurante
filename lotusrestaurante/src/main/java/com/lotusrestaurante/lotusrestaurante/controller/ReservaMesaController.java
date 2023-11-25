package com.lotusrestaurante.lotusrestaurante.controller;


import com.lotusrestaurante.lotusrestaurante.entity.ReservasEntity;
import com.lotusrestaurante.lotusrestaurante.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservamesa")
public class ReservaMesaController {

    @Autowired
    ReservasService reservas;

    ReservasEntity responseReservas;

    @PostMapping
    public ResponseEntity<ReservasEntity> criarReserva(@RequestParam String name,
                                                       @RequestParam String email,
                                                       @RequestParam String number,
                                                       @RequestParam String number2,
                                                       @RequestParam String data,
                                                       @RequestParam int npessoas,
                                                       @RequestParam String message) {

        ReservasEntity requestReservas = new ReservasEntity();


        requestReservas.setNome(name);
        requestReservas.setEmail(email);
        requestReservas.setTelefonePrincipal(number);
        requestReservas.setTelefoneReserva(number2);
        requestReservas.setDataHoraReserva(data);
        requestReservas.setNumeroPessoas(npessoas);
        requestReservas.setObservacao(message);

        responseReservas = reservas.saveReserva(requestReservas);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseReservas);
    }


}
