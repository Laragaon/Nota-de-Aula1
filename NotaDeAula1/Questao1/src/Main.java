import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print(" Coloque seu nome: ");
        String nome = leitor.next();

        System.out.print(" Coloque sua primeira nota: ");
        int n1 = leitor.nextInt();

        System.out.print(" Coloque sua segunda nota: ");
        int n2 = leitor.nextInt();

        System.out.print(" Coloque sua terceira nota: ");
        int n3 = leitor.nextInt();

        int media;
        media = n1+n2+n3/3;

        if (media >=70) {
            System.out.println(nome +" Aprovado "+ media);
        } else if (media < 40) {
            System.out.println(nome +" Reprovado "+ media);
        } else {
            System.out.println(nome +" Precisa melhorar ");
        }


    }
    }
