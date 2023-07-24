import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Comparar dos numeros y devolver un valor \n" +
                "2. Ver si un cliente tiene descuento en su compra \n"+
                "3. Solicitar datos personales de un profesor \n"+
                "4. Generea un arreglo de numeros impares y primos");
        System.out.println("ingrese el numero del programa que desea usar");
        int option = scanner.nextInt();

        switch (option){
            case 1:
                System.out.println("Ingrese un numero");
                int num = scanner.nextInt();
                System.out.println("ingrese otro numero");
                int num2 = scanner.nextInt();
                System.out.println(pairAndOdd(num,num2));
                break;
            case 2:
                System.out.println("Ingrese el total de la compra");
                double total = scanner.nextDouble();
                discount(total);
                break;
            case 3:
                getTeacherData();
                break;
            case 4:
                oddDimiss();
        }
    }

    public static String pairAndOdd(int num1, int num2){
        if (num1 % 2 == 0 && num2 % 2 !=0){
            return "1";
        } else if (num1 % 3 == 0 && num2 % 2 ==0) {
            return "-1";
        }
        else{
            return "0";
        }
    }

    public static void discount(double total){
        if (total >= 100){
            System.out.println("EL cliente tiene un descuentp del 20%");
            double payDiscount = 0 ;
            payDiscount = total * 0.80 ;
            System.out.println("El total con descuento es de: "+ payDiscount);
        }
    }

    public static void getTeacherData (){
        Scanner scanner = new Scanner(System.in);
        int[] cedulas = new int[100];
        String[] nombres = new String[100];
        String[] apellidos = new String[100];
        String[] materias = new String[100];
        String[] horarios = new String[100];

        int contadorProfesores = 0;

        boolean continuar = true;
        while (continuar) {
            System.out.println("Ingrese los datos del profesor:");
            System.out.print("Cédula: ");
            cedulas[contadorProfesores] = scanner.nextInt();
            scanner.nextLine(); // Consumimos el salto de línea pendiente

            System.out.print("Nombres: ");
            nombres[contadorProfesores] = scanner.nextLine();

            System.out.print("Apellidos: ");
            apellidos[contadorProfesores] = scanner.nextLine();

            System.out.print("Materia a dictar: ");
            materias[contadorProfesores] = scanner.nextLine();

            System.out.print("Horario: ");
            horarios[contadorProfesores] = scanner.nextLine();

            contadorProfesores++;

            System.out.print("¿Desea agregar otro profesor? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        System.out.println("\nDatos de los profesores registrados:");
        for (int i = 0; i < contadorProfesores; i++) {
            System.out.println("Profesor " + (i + 1) + ":");
            System.out.println("Cédula: " + cedulas[i]);
            System.out.println("Nombres: " + nombres[i]);
            System.out.println("Apellidos: " + apellidos[i]);
            System.out.println("Materia a dictar: " + materias[i]);
            System.out.println("Horario: " + horarios[i]);
            System.out.println("--------------------");
        }


    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void oddDimiss (){
        int[] numeros = new int[50];
        int contadorPrimos = 0; 

        for (int i = 0; i < 50; i++) {
            numeros[i] = i + 1;
        }

        
        System.out.println("Números primos menores e impares del 1 al 50:");
        for (int i = 0; i < 50; i++) {
            if (esPrimo(numeros[i]) && numeros[i] % 2 != 0) {
                System.out.print(numeros[i] + " ");
                contadorPrimos++;
            }
        }

        
        if (contadorPrimos == 0) {
            System.out.println("No se encontraron números primos menores e impares en el rango de 1 a 50.");
        }
    }

}