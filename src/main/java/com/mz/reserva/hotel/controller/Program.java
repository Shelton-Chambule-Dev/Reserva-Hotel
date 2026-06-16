package com.mz.reserva.hotel.controller;
import com.mz.reserva.hotel.entity.Reserva;
import com.mz.reserva.hotel.exception.DominioExceptions;
import com.mz.reserva.hotel.services.ReservaServices;

import java.time.LocalDate;
import java.util.List;

public class Program {
    public static void main(String[] args) throws DominioExceptions {

        Reserva reserva1 = new Reserva();
        ReservaServices reservaServices = new ReservaServices();

       List<Reserva> reservaList = reservaServices.findAll();
        for(Reserva que: reservaList){
            System.out.println("Id: "+que.getId());
            System.out.println("Nome: "+que.getNome());
            System.out.println("Data entrada: "+que.getDiaEntrada());
            System.out.println("Data Saida: "+que.getDiaSaida());
            System.out.println("==================================");
        }
        reserva1.setNome("Ristem Baquim");
        reserva1.setDiaEntrada(LocalDate.of(2026,6,9));
        reserva1.setDiaSaida(LocalDate.of(2026,6,20));
      // reservaServices.save(reserva1);

        //reserva1.setId(9);
        reserva1.setNome("Nelsa Macamo");
        reserva1.setDiaEntrada(LocalDate.of(2026,6,9));
        reserva1.setDiaSaida(LocalDate.of(2026,6,15));
        // reservaServices.update(reserva1);

//        Optional<Reserva> reservaOptional = reservaServices.findById(8);
//        if(reservaOptional.isPresent()){
//            Reserva reserva2 = reservaOptional.get();
//            System.out.println("ID: "+reserva2.getId());
//            System.out.println("Nome: "+reserva2.getNome());
//            System.out.println("Dia entrada: "+reserva2.getDiaEntrada());
//            System.out.println("Dia Saida: "+reserva2.getDiaSaida());
//        }else {
//            System.out.println("Id nao encontrado!");
//        }

    }
}
