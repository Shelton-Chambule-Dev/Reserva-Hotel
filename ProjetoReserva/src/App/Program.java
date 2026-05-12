package App;
import entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) throws ParseException {

          // Versao muito ruim
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                // entrada de dados
        System.out.println("Numero da sala: ");
        int sala = sc.nextInt();
        System.out.print("Data do dia da entrada (dd/MM/yyyy) : ");
        Date diaEntrada = sdf.parse(sc.next());
        System.out.print("Data do dia da entrada (dd/MM/yyyy) : ");
        Date diaSaida = sdf.parse(sc.next());

        if(!diaSaida.after(diaEntrada)){
            System.out.println("Erro: a data de saida deve ser depois da data de entrada!");
        }else{
            Reserva reserva = new Reserva(sala,diaEntrada,diaSaida);
            System.out.println("Reserva: "+reserva);
            System.out.println();
            System.out.println("Introduza a data da reserva  que deseja atualizar");
            System.out.print("Data do dia da entrada (dd/MM/yyyy) : ");
            diaEntrada = sdf.parse(sc.next());
            System.out.print("Data do dia da entrada (dd/MM/yyyy) : ");
            diaSaida = sdf.parse(sc.next());
            Date now = new Date();
            if(diaEntrada.before(now) || diaSaida.before(now)){
                System.out.println("As datas deve estar no futuro nao no passado!");
            }else if(!diaSaida.after(diaEntrada)){
                System.out.println("Erro: a data de saida deve ser depois da data de entrada!");
            }else {
                reserva.atualizarDatas(diaEntrada,diaSaida);
                System.out.println("Data atualizada: "+reserva);
            }
        }
    }
}
