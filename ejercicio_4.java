import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class ejercicio_3{
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        int option = 0;
        String enter = "";
        System.out.println("Ingrese la opcion que desee ");
        System.out.println("1. Ingreso de estudiantes.\n" +
                "2. Consulta especifica de estudiante.\n" +
                "3. Salir");
        option = scanner.nextInt();

        String head = "# Matricula \t|\t Cedula \t|\t Nombres \t|\t Apellido \t|\t Fecha de nacimiento \t|\t carrera";
        String ruta = "./estudiantes.txt";
        findStudent(0, ruta, head);

        switch (option){
            case 1:
                do {
                    String names = getNames(0);
                    String lastNames = getNames(1);
                    int idCard = GetIdCard(0);
                    System.out.println("Ingrese el numero de matricula");
                    int registrationId = scanner.nextInt();
                    System.out.println("Ingrese la fecha de nacimiento");
                    String birthday = scanner.next();
                    System.out.println("Ingrese la carrera del estudiante");
                    String career = scanner.next();
                    System.out.println("Desea ingresar otro estudiante:");
                    enter = scanner.next();
                    String data = registrationId + "\t|\t" + idCard + "\t|\t"  + names + "\t|\t" + lastNames + "\t|\t" + birthday + "\t|\t" + career;
                    findStudent(1 , ruta, data);
                }while (enter.equalsIgnoreCase("si"));
                break;
            case 2:
                int find = GetIdCard(1);
                findStudent( 0,ruta,Integer.toString(find));
                break;

            case 3:
                break;
        }

    }

    public static void findStudent(int option, String ruta, String data) {
        try {
            String[] get = new String[2];
            get[0] = "head";
            get[1]= "Data";

            FileReader reader = new FileReader(ruta);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linea;
            boolean found = false;

            System.out.println("busca + " + data);
                while ((linea = bufferedReader.readLine()) != null) {
                    if (linea.equals(data)) {
                        System.out.println("Estudiante encontrado: " + linea);
                        found = true;
                        break;
                    }
                }
            bufferedReader.close();

            if (!found) {
                fileWrite(data, ruta);
                System.out.println("escrito");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public static void fileWrite(String data, String ruta){
        try {

            FileWriter escritor = new FileWriter(ruta, true);

            escritor.write(data + "\n");
            escritor.close();
            System.out.println("Nueva informacion");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al generar el archivo: " + e.getMessage());
        }
    }

    public static int GetIdCard(int i) {
        String input = "";
        String[] get = new String[2];
        get[0] = "Ingrese el numero de cedula: ";
        get[1]= "Ingrese la cedula del estudiante a encontrar";
        int idCard = 0;
        Scanner scanner = new Scanner(System.in);
        idCard = scanner.nextInt();

       do {
           System.out.println( get[i]);
           input = scanner.next();

           if (IsValidIdCard(input)) {
               idCard = Integer.parseInt(input);
           } else {
               System.out.println("Ingrese correctamente el número de cédula (debe tener 10 dígitos numéricos).");
               continue;
           }
       } while (!IsValidIdCard(input));
        return idCard;
    }

    public static boolean esString(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static String getNames(int indice){
        String[] texto = new String[2];
        texto[0]= "nombres";
        texto[1]= "apellidos";
        Scanner scanner = new Scanner(System.in);
        String names = "";
        while (names.isEmpty()) {
            try {
                System.out.println("Ingrese el " + texto[indice]);
                names = scanner.next();
                if (!(esString(names))) {
                    break;
                } else {
                    throw new IllegalArgumentException("Ingrese solo letras");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ingrese solamente letras");
                names = "";
            }
        }
        return names;
    }

    public static boolean IsValidIdCard(String input) {
        if (input.length() != 10)
            return false;

        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }


    }

}