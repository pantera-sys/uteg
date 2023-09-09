import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class examen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean valido = true;

        while (valido) {
            System.out.print("Ingrese la cantidad de estudiantes: ");
            int cantidadIngreso = scanner.nextInt();

            if (cantidadIngreso > 300) {
                System.out.println("No puede ingresar más de 300 estudiantes");
                valido = true;
            } else {
                valido = false;
                try {
                    imprimirParalelosEstudiantes(cantidadIngreso, "Cursos.txt");
                    System.out.println("Los resultados se han guardado en 'Cursos.txt'");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Gracias por usar nuestro sistema");
    }

    public static void imprimirParalelosEstudiantes(int total, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("Materia \t\t Paralelo \t\t #Estudiantes");
        printWriter.println("-".repeat(80));

        int[] cursos = {30, 50, 75};
        String[] materias = {"Calculo Diferencial", "Fisica 1\t\t", "Tecnicas Comunicacion Oral y Esc", "Derecho constitucional", "Herramientas digitales"};
        int[] paralelos = {1, 2, 3, 4};
        int indiceCurso = 0;

        for (int i = 1; i <= 4; i++) {
            int curso = 0;
             if (total <= 100) {
            curso = 30;
        } else if (total <= 200) {
            curso = 50;
        } else if (total <= 300) {
            curso = 75;
        } 
            if (total <= 0) {
                break;
            }

            if (curso <= total) {
                imprimirCursos(i, paralelos[indiceCurso], curso, materias, printWriter);
                printWriter.println("-".repeat(20));
                total -= curso;
                indiceCurso = (indiceCurso + 1) % cursos.length;
            } else {
                imprimirCursos(i, paralelos[indiceCurso], total, materias, printWriter);
                break;
            }
        }

        printWriter.close();
        fileWriter.close();
    }

    public static void imprimirCursos(int i, int paralelo, int curso, String[] materias, PrintWriter printWriter) {
        printWriter.printf("%s \t\t P-%d \t\t %d \n", materias[0], i, curso);
        for (int j = 1; j < materias.length; j++) {
            printWriter.printf("%s \t\t\t P-%d \t\t %d\n", materias[j], i,  curso);
        }
    }
}
