import java.util.Scanner;

public class ejercicio_1 {
    public static void main(String[] args) {
        int age = 0, idCard =0, countStudents = 0  ;
        String names="", lastNames ="", education, enter = "", input="";
        Scanner scanner = new Scanner(System.in);

        do {
            countStudents++;
            System.out.println("Ingrese los datos del estudiante");
            
            while (input.isEmpty()){
                try{
                    System.out.println("Ingrese el nombre");
                    input = scanner.next();
                    if(!(esString(input))){
                        names = input;
                    } else {
                        throw new IllegalArgumentException("Ingrese solo letras");
                    }
                } catch (IllegalArgumentException e){
                    System.out.println("Ingrese solamente letras");
                    input = "";
                }
            }

            input = "";
            while (input.isEmpty()){
                try{
                    System.out.println("Ingrese el apellido");
                    input = scanner.next();
                    if(!(esString(input))){
                        lastNames = input;
                    } else {
                        throw new IllegalArgumentException("Ingrese solo letras");
                    }
                } catch (IllegalArgumentException e){
                    System.out.println("Ingrese solamente letras");
                    input = "";
                }
            }

            while (!(esString(input))){
                System.out.println("Ingrese la edad del estudiante");
                input = scanner.next();

               try {
                   age = Integer.parseInt(input);

               }catch (NumberFormatException e){
                   System.out.println("Ingrese un numero para la edad");
               }
            }

            input = "";
            while (!(esString(input))) {
                System.out.println("Ingrese el numero de cedula");
                input = scanner.next();

                try {
                    if(input.length() == 10){
                        idCard = Integer.parseInt(input);
                    }
                } catch (NumberFormatException e){
                    System.out.println("Ingrese correctame el numero de cedula");
                }
            }
            System.out.println("Ingrese el nivel de educaion del estudiante");
            education = scanner.next();

            System.out.println("Usted ingreso estudiante N#: "+ countStudents + " ,Nombres: "+ names + " ,Apellidos = "+lastNames+ ", id= "+idCard+ " ,edad = "+ age  );
            System.out.println("desea agregar otro estudiante?");
            enter = scanner.next();
        } while (enter.equalsIgnoreCase("si"));


    }
    public static boolean esString(String input) {
        try {
                Integer.parseInt(input);
                return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}


