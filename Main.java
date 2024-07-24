import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
    private final String nome;
    private final int horas;
    private final double valorPorHora;

    public Funcionario(String nome, int horas, double valorPorHora) {
        this.nome = nome;
        this.horas = horas;
        this.valorPorHora = valorPorHora;
    }

    public String getNome() {
        return nome;
    }

    public double pagamento() {
        return horas * valorPorHora;
    }
}


class Tercerizado extends Funcionario {
    private final double cobrancaAdicional;

    public Tercerizado(String nome, int horas, double valorPorHora, double cobrancaAdicional) {
        super(nome, horas, valorPorHora);
        this.cobrancaAdicional = cobrancaAdicional;
    }

    public double pagamento() {
        return super.pagamento() + cobrancaAdicional * 1.1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.print("Insira o número de funcionários: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.println("Funcionário #" + (i + 1) + " dados:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Terceirizado (y/n)? ");
            char isTerceirizado = sc.next().charAt(0);
            System.out.print("Total das horas trabalhadas: ");
            int horas = sc.nextInt();
            System.out.print("Qual valor por hora: ");
            double valorPorHora = sc.nextDouble();

            if (isTerceirizado == 'y') {
                System.out.print("Taxa extra: ");
                double cobrancaAdicional = sc.nextDouble();
                funcionarios.add(new Tercerizado(nome, horas, valorPorHora, cobrancaAdicional));
            } else {
                funcionarios.add(new Funcionario(nome, horas, valorPorHora));
            }
        }

        System.out.println();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Tercerizado tercerizado) {
                System.out.println(tercerizado.getNome() + " - R$ " + String.format("%.2f", tercerizado.pagamento()));
            }                                     sc.close();
        }
    }
}
