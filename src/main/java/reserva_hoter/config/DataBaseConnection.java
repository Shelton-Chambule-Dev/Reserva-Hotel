package reserva_hoter.config;
import reserva_hoter.exception.ReservaExceptions;

import java.sql.*;
import java.util.Objects;
public class DataBaseConnection {

    private Connection connection;
    private static  DataBaseConnection instance;

    String url = "jdbc:postgresql://localhost:5432/reserva";
    String user = "postgres";
    String password = "1234";

    private  DataBaseConnection() {
         try {
             connection = DriverManager.getConnection(url,user,password);
         }catch(SQLException ex){
             throw  new RuntimeException("Ocorreu um erro ao se conectar com banco de dados!");
         }
    }

    public static DataBaseConnection getDataBaseConnection() {
        if(Objects.isNull(instance)){
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public Connection connection(){
        return  connection;
    }

    public static  void closeStatement(Statement st) throws ReservaExceptions{
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                    throw new ReservaExceptions(e.getMessage());
            }
        }

    }
    public static  void closeResultSet(ResultSet rs) throws ReservaExceptions{
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new ReservaExceptions(e.getMessage());
            }
        }

    }
}
