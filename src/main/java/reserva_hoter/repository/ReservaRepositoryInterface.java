package reserva_hoter.repository;
import reserva_hoter.entity.Reserva;
import reserva_hoter.exception.ReservaExceptions;
import java.util.List;
import java.util.Optional;
public interface ReservaRepositoryInterface {

    public Reserva save(Reserva reserva) throws ReservaExceptions;
    public void deleteById(int numeroSala) throws ReservaExceptions;
    public Reserva update(Reserva reserva) throws ReservaExceptions;
    public Optional<Reserva> findById(int id) throws ReservaExceptions;
    public List<Reserva> findAll() throws ReservaExceptions;

}
