package com.mz.reserva.hotel.services;
import com.mz.reserva.hotel.config.DataBaseConnection;
import repository.ReservaRepositoryInterface;
import com.mz.reserva.hotel.entity.Reserva;
import com.mz.reserva.hotel.exception.DominioExceptions;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ReservaServices implements ReservaRepositoryInterface {

    @Override
    public Reserva save(Reserva reserva)  {
        String sql = "INSERT INTO reservas (nome,dia_entrada, dia_saida) VALUES (?,?,?)";
              try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()) {
                  PreparedStatement pr = connection.prepareStatement(sql);
                  pr.setString(1,reserva.getNome());
                  pr.setDate(2,java.sql.Date.valueOf(reserva.getDiaEntrada()));
                  pr.setDate(3,java.sql.Date.valueOf(reserva.getDiaSaida()));
                  pr.executeUpdate();
              }catch (SQLException ex){
                  throw  new RuntimeException(ex);
              }
              return reserva;
    }
    @Override
    public void remove(int id) {
            String sql = "DELETE FROM reservas WHERE id = ?";
            try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()) {
                PreparedStatement pr = connection.prepareStatement(sql);
                pr.setInt(1,id);
                pr.executeUpdate();
            }catch (SQLException ex){
                throw  new RuntimeException(ex);
            }
    }
    @Override
    public Reserva update(Reserva reserva){
        String sql = "UPDATE reservas SET nome = ?,dia_entrada = ?, dia_saida = ?  WHERE id = ?";
        try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()){
                    PreparedStatement pr = connection.prepareStatement(sql);
                    pr.setString(1,reserva.getNome());
                    pr.setDate(2,java.sql.Date.valueOf(reserva.getDiaEntrada()));
                    pr.setDate(3,java.sql.Date.valueOf(reserva.getDiaSaida()));
                    pr.setInt(4,reserva.getId());
                    pr.executeUpdate();

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return  reserva;
    }
    @Override
    public Optional<Reserva> findById(int id) throws DominioExceptions {
        String sql = "SELECT  id,  nome , dia_entrada , dia_saida  FROM reservas WHERE id = ?";
        try(Connection connection = DataBaseConnection.getDataBaseConnection().connection();
            PreparedStatement prst = connection.prepareStatement(sql)){
            prst.setInt(1,id);

            ResultSet rs = prst.executeQuery();
            if(rs.next()){
                Integer chave = rs.getInt("id");
                String nome = rs.getString("nome");
                LocalDate dataEntrada  = rs.getDate("dia_entrada").toLocalDate();
                LocalDate dataSaida = rs.getDate("dia_saida").toLocalDate();

                Reserva reserva =  new Reserva (chave ,nome,dataEntrada,dataSaida);
                return Optional.of(reserva);
            }
        }catch (SQLException ex) {
            throw new RuntimeException("Id nao encontrado!");
        }
        return Optional.empty();
    }

    @Override
    public List<Reserva> findAll() throws  DominioExceptions{
        String sql = "SELECT  id , nome , dia_entrada , dia_saida FROM reservas";
        List<Reserva> reservas = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()){
            PreparedStatement pr = connection.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                LocalDate  dataEntrada = rs.getDate("dia_entrada").toLocalDate();
                java.time.LocalDate dataSaida = rs.getDate("dia_saida").toLocalDate();
                Reserva reserva = new Reserva(id,nome,dataEntrada,dataSaida);
                reservas.add(reserva);
            }
        }catch (SQLException ex){
            throw  new RuntimeException(ex);
        }
        return  reservas;
    }
}
