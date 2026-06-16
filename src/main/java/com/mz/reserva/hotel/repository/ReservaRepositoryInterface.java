package com.mz.reserva.hotel.repository;
import com.mz.reserva.hotel.entity.Reserva;
import com.mz.reserva.hotel.exception.DominioExceptions;
import java.util.List;
import java.util.Optional;
public interface ReservaRepositoryInterface {

    public Reserva save(Reserva reserva) throws DominioExceptions;
    public void remove(int numeroSala);
    public Reserva update(Reserva reserva);
    public Optional<Reserva> findById(int id) throws DominioExceptions;
    public List<Reserva> findAll() throws  DominioExceptions;

}
