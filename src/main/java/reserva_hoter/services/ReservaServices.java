package reserva_hoter.services;
import reserva_hoter.config.DataBaseConnection;
import reserva_hoter.repository.ReservaRepositoryInterface;
import reserva_hoter.entity.Reserva;
import reserva_hoter.exception.ReservaExceptions;
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
    public Reserva save(Reserva reserva) throws ReservaExceptions {
        String sql = "INSERT INTO reservas (nome,dia_entrada, dia_saida) VALUES (?,?,?)";
        PreparedStatement pr =  null;
              try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()) {
                 pr  = connection.prepareStatement(sql);
                  pr.setString(1,reserva.getNome());
                  pr.setDate(2,java.sql.Date.valueOf(reserva.getDiaEntrada()));
                  pr.setDate(3,java.sql.Date.valueOf(reserva.getDiaSaida()));
                  pr.executeUpdate();
              }catch (SQLException ex){
                  throw  new ReservaExceptions(ex.getMessage());
              }finally {
                  DataBaseConnection.closeStatement(pr);
              }
              return reserva;
    }
    @Override
    public void remove(int id) throws ReservaExceptions {
            String sql = "DELETE FROM reservas WHERE id = ?";
        PreparedStatement pr =  null;
            try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()) {
                 pr = connection.prepareStatement(sql);
                pr.setInt(1,id);
                pr.executeUpdate();
            }catch (SQLException ex){
                throw  new RuntimeException(ex);
            }finally {
                DataBaseConnection.closeStatement(pr);
            }
    }
    @Override
    public Reserva update(Reserva reserva)throws  ReservaExceptions{
        String sql = "UPDATE reservas SET nome = ?,dia_entrada = ?, dia_saida = ?  WHERE id = ?";
        PreparedStatement pr =  null;
        try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()){
                    pr = connection.prepareStatement(sql);
                    pr.setString(1,reserva.getNome());
                    pr.setDate(2,java.sql.Date.valueOf(reserva.getDiaEntrada()));
                    pr.setDate(3,java.sql.Date.valueOf(reserva.getDiaSaida()));
                    pr.setInt(4,reserva.getId());
                    pr.executeUpdate();

        }catch (SQLException ex){
            throw new ReservaExceptions(ex.getMessage());
        }finally {
            DataBaseConnection.closeStatement(pr);
        }
        return  reserva;
    }
    @Override
    public Optional<Reserva> findById(int id) throws ReservaExceptions {
        PreparedStatement prst = null;
        ResultSet rs = null;
        String sql = "SELECT  id,  nome , dia_entrada , dia_saida  FROM reservas WHERE id = ?";
        try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()){
             prst = connection.prepareStatement(sql);
            prst.setInt(1,id);

             rs = prst.executeQuery();
            if(rs.next()){
                Integer chave = rs.getInt("id");
                String nome = rs.getString("nome");
                LocalDate dataEntrada  = rs.getDate("dia_entrada").toLocalDate();
                LocalDate dataSaida = rs.getDate("dia_saida").toLocalDate();

                Reserva reserva =  new Reserva (chave ,nome,dataEntrada,dataSaida);
                return Optional.of(reserva);
            }
        }catch (SQLException ex) {
            throw new ReservaExceptions("Id nao encontrado!");
        }finally{
            DataBaseConnection.closeStatement(prst);
            DataBaseConnection.closeResultSet(rs);
        }
        return Optional.empty();
    }

    @Override
    public List<Reserva> findAll() throws ReservaExceptions {
        String sql = "SELECT  id , nome , dia_entrada , dia_saida FROM reservas";
        ResultSet rs = null;
        PreparedStatement pr = null;
        List<Reserva> reservas = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getDataBaseConnection().connection()){
        pr = connection.prepareStatement(sql);
            rs = pr.executeQuery();

            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                LocalDate  dataEntrada = rs.getDate("dia_entrada").toLocalDate();
                java.time.LocalDate dataSaida = rs.getDate("dia_saida").toLocalDate();
                Reserva reserva = new Reserva(id,nome,dataEntrada,dataSaida);
                reservas.add(reserva);
            }
        }catch (SQLException ex){
            throw  new ReservaExceptions(ex.getMessage());
        }finally {
            DataBaseConnection.closeResultSet(rs);
            DataBaseConnection.closeStatement(pr);
        }
        return  reservas;
    }
}
