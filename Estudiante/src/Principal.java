import java.util.Date;
import java.util.Scanner;

/**
 * clase Principal
 */
public class Principal {

    /**
     * Método inicial que es ejecutado
     * @param args
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nombre:");
        String nombre = sc.next();
        System.out.printf("Fecha de nacimiento (año, mes, día):");
        Date fechaNacimiento = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());

        Estudiante estudiante = new Estudiante(nombre, fechaNacimiento);

        /** Ingresa materia por materia y verifica el rango en la calse Estudiante (Nota, # de asignatura) **/
        estudiante.ingresarYVerificarNota(sc, 1); // Materia #1
        estudiante.ingresarYVerificarNota(sc, 2); // Materia #2
        estudiante.ingresarYVerificarNota(sc, 3); // Materia #3

        /**
         * Calcular edad
         */
        int edad = estudiante.getEdad();
        System.out.println("Edad de el/la estudiante "+nombre+" es: "+edad);

        /**
         * Calcular promedio
         */
        double prom = estudiante.getPromedio();
        System.out.println("Promedio de el/la estudiante: "+prom);
    }
}
