import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;
public class Estudiante {
    /**
     * Atributos
     */
    private String nombre;
    private Date fechaNacimiento;
    private double notaMateria1;
    private double notaMateria2;
    private double notaMateria3;

    /****************************************************************************************************/
    /******************************************* CONSTRUCTORES ******************************************/
    /****************************************************************************************************/

    /**
     * Método constuctor para inicializar los atributos de la clase
     * @param nombre Nombre de el/la estudiante
     * @param fechaNacimiento Fecha de nacimiento de el/la estudiante
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public Estudiante(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.notaMateria1 = 0.0;
        this.notaMateria2 = 0.0;
        this.notaMateria3 = 0.0;
    }

    /**
     * Método que permite modificar la nota de la Materia #1 para un estudiante específico
     * @param notaMateria1 Nota 1
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public void setNotaMateria1(double notaMateria1) {
        this.notaMateria1 = notaMateria1;
    }

    /**
     * Método que permite modificar la nota de la Materia #2 para un estudiante específico
     * @param notaMateria2 Nota 2
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public void setNotaMateria2(double notaMateria2) {
        this.notaMateria2 = notaMateria2;
    }

    /**
     * Método que permite modificar la nota de la Materia #3 para un estudiante específico
     * @param notaMateria3 Nota 3
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public void setNotaMateria3(double notaMateria3) {
        this.notaMateria3 = notaMateria3;
    }

    /**
     * Método para obtener el nombre del estudiante
     * @return Retorna el nombre
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para obtener la fecha de nacimiento
     * @return Retornar fecha de nacimiento
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método para obtener y verificar el rango de las notas ingresadas
     * @param sc Scanner que obtiene la nota ingresada
     * @param numeroMateria Número de la asignatura a la que pertenece la nota ingresada
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public void ingresarYVerificarNota(Scanner sc, int numeroMateria) {
        double nota;
        do {
            System.out.println("Nota Materia #" + numeroMateria + " (utilizar ',' como separador decimal):");
            nota = sc.nextDouble();
            if (nota < 0.0 || nota > 5.0) {
                System.out.println("Error: La nota debe estar en el rango de 0 a 5.");
                System.out.println("Por favor, ingrese la nota para Materia #" + numeroMateria + " nuevamente:");
            }
        } while (nota < 0.0 || nota > 5.0);

        switch (numeroMateria) {
            case 1:
                setNotaMateria1(nota);
                break;
            case 2:
                setNotaMateria2(nota);
                break;
            case 3:
                setNotaMateria3(nota);
                break;
            default:
                System.out.println("Número de materia no válido.");
        }
    }

    /**
     * Método que calcula la edad exacta del estudiante
     * @return Retorna la edad
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public int getEdad() {
        LocalDate fechaActual = LocalDate.now();
        int dia = fechaActual.getDayOfMonth();
        int mes = fechaActual.getMonthValue();
        int anno = fechaActual.getYear();

        int edad = anno - getFechaNacimiento().getYear();

        if (mes < getFechaNacimiento().getMonth() || (mes == getFechaNacimiento().getMonth() && dia < getFechaNacimiento().getDay())) {

            edad = edad - 1;
        }

        return edad;
    }

    /**
     * Método que calcula el promedio del estudiante con las notas ingresadas anteriormente
     * @return Retorna el proimedio del estudiante
     *
     * Complejidad temporal: O(1) Tiempo constante
     */
    public double getPromedio() {
        double promedio = (notaMateria1 + notaMateria2 + notaMateria3)/3;
        return promedio;
    }
}
