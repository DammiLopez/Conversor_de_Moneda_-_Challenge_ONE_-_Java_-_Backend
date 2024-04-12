import java.util.InputMismatchException;
import java.util.Scanner;

import services.CalculateRates;

public class App {
    public static void main(String[] args) throws Exception {

        CalculateRates calculate = new CalculateRates();
        Scanner scan = new Scanner(System.in);
        int opt = 0;
        double amount;
        String result;

        while (true) {

            System.out.println("************************************");
            System.out.println("----- Conversor de moneda ------");
            System.out.println("----- 1. Dolar -> peso Arg ------");
            System.out.println("----- 2. Peso Arg -> Dolar ------");
            System.out.println("----- 3. Dolar -> Real Br ------");
            System.out.println("----- 4. Real Br -> Dolar ------");
            System.out.println("----- 5. Dolar -> peso Col ------");
            System.out.println("----- 6. peso Col -> Dolar ------");
            System.out.println("----- 7. Salir... ------");
            System.out.println("************************************");

            while (true) {
                try {
                    System.out.print("Seleccione una opcion -> ");
                    opt = scan.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Ingrese solamente numeros del 1 al 7.");
                }

            }

            if (opt == 7) {
                System.out.println("Saliendo...");
                scan.close();
                break;
            }

            while (true) {
                try {
                    System.out.print("Ingrese el monto a convertir -> ");
                    amount = scan.nextDouble();
                    scan.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Ingrese un numero valido...");
                }
            }

            switch (opt) {
                case 1:
                    result = "El valor para " + amount + " [USD]" + " corresponde al valor final de: "
                            + calculate.convert("USD", "ARS", amount) + " [ARS]";
                    System.out.println(result);
                    System.out.println("Presione una ENTER para continuar...");
                    scan.nextLine();
                    break;
                case 2:
                    result = "El valor para " + amount + " [ARS]" + " corresponde al valor final de: "
                            + calculate.convert("ARS", "USD", amount) + " [USD]";
                    System.out.println(result);
                    System.out.println("Presione una ENTER para continuar...");
                    scan.nextLine();
                    break;
                case 3:
                    result = "El valor para " + amount + " [USD]" + " corresponde al valor final de: "
                            + calculate.convert("USD", "BRL", amount) + " [BRL]";
                    System.out.println(result);
                    System.out.println("Presione una ENTER para continuar...");
                    scan.nextLine();
                    break;
                case 4:
                    result = "El valor para " + amount + " [BRL]" + " corresponde al valor final de: "
                            + calculate.convert("BRL", "USD", amount) + " [USD]";
                    System.out.println(result);
                    System.out.println("Presione una ENTER para continuar...");
                    scan.nextLine();
                    break;
                case 5:
                    result = "El valor para " + amount + " [USD]" + " corresponde al valor final de: "
                            + calculate.convert("USD", "COP", amount) + " [COP]";
                    System.out.println(result);
                    System.out.println("Presione una ENTER para continuar...");
                    scan.nextLine();
                    break;
                case 6:
                    result = "El valor para " + amount + " [COP]" + " corresponde al valor final de: "
                            + calculate.convert("COP", "USD", amount) + " [USD]";
                    System.out.println(result);
                    System.out.println("Presione una ENTER para continuar...");
                    scan.nextLine();
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        }

    }
}
