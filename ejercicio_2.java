import java.util.Scanner;

public class ejercicio_2 {
    public static void main(String[] args) {
        String input , keyWord = "computadora" ;
        int attempts = 0;
        Scanner scanner = new Scanner(System.in);

        char firstLetter = keyWord.charAt(0);
        char lastLetter = keyWord.charAt(keyWord.length() - 1);

        StringBuilder cadena = new StringBuilder();
        for (int i = 1; i < keyWord.length() - 1; i++) {
            cadena.append("_");
        }

        do {
            attempts++;
            System.out.println("Adivine la palabra secreta");

            System.out.println(firstLetter + cadena.toString() + lastLetter);
            input = scanner.next();

            if (!input.equals(keyWord)){
                System.out.println("palabra incorrecta");
                System.out.println("Te dare una pista");
                switch (attempts){
                    case 1:
                        System.out.println("Es un dispositivo electronico");
                        break;
                    case 2:
                        System.out.println("Es algo que usas a diario");
                        break;
                    case 3:
                        System.out.println("La mayoria de las personas tienen al menos una en sus casas");
                        break;
                }
            }
            if (input.equals(keyWord) && attempts <= 3){
                GetMessage(attempts);
            }
            if (attempts > 3 && !input.equals(keyWord)){
                System.out.println("Lo siento no conseguiste adivinar la palabra");
                input = keyWord;
            }
        }while (!input.equals(keyWord));
        
    }

    public static void GetMessage(int count){
        if (count == 1){
            System.out.println("Felicitaciones adivinaste la palabra\n"
            + "Consiguio 100 puntos!!");
        } else if (count == 2) {
            System.out.println("Felicitaciones adivinaste la palabra\n"
                    + "Consiguio 80 puntos!!");
        } else if (count == 3) {
            System.out.println("Felicitaciones adivinaste la palabra\n"
                    + "Consiguio 60 puntos!!");
        } else {
            System.out.println("Felicitaciones adivinaste");
        }
    }
}
