package App;
import model.entities.Reserva;
import model.exceptions.DominioExceptions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) {

          // Versao muito ruim
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                // entrada de dados
        try {
                    System.out.println("Numero da sala: ");
                    int sala = sc.nextInt();
                    System.out.print("Data do dia da entrada (dd/MM/yyyy) : ");
                    Date diaEntrada = sdf.parse(sc.next());
                    System.out.print("Data do dia da entrada (dd/MM/yyyy) : ");
                    Date diaSaida = sdf.parse(sc.next());

                    Reserva reserva = new Reserva(sala, diaEntrada, diaSaida);
                    System.out.println("Reserva: " + reserva);
                    System.out.println();

                    System.out.println("Introduza a data da reserva  que deseja atualizar");
                    System.out.print("Data do dia da entrada (dd/MM/yyyy) : ");
                    diaEntrada = sdf.parse(sc.next());
                    System.out.print("Data do dia da entrada (dd/MM/yyyy) : ");
                    diaSaida = sdf.parse(sc.next());
                    reserva.atualizarDatas(diaEntrada, diaSaida);
        }catch (ParseException e){
            System.out.println("Formato da data invalido");
        }catch (DominioExceptions e){
            System.out.println("Erros de argumento: "+e.getMessage());
        }
    }
}
