import java.util.Scanner;

public class ParcialMatrices {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[]estudiante=new String[5];
        double[][]notasEvaluaciones=new double[5][4];
        double[]promediosEstudiante=new double[5];
        double[]promedioEvaluaciones=new double[4];
        System.out.println("A continuación ingrese los nombres de  los 5 estudiantes");
        
        for (int i = 0; i < estudiante.length; i++) {
            estudiante[i]=sc.nextLine();
        }
        System.out.println("A continuación se le solicitarán las notas para cada estudiante");
        for (int i = 0; i < notasEvaluaciones.length; i++) {
            System.out.println("Para el estudiante número: "+(i+1));
            for (int j = 0; j < notasEvaluaciones[i].length; j++) {
                notasEvaluaciones[i][j]=sc.nextDouble();
                promediosEstudiante[i]+=notasEvaluaciones[i][j];
            }
            promediosEstudiante[i]=(promediosEstudiante[i])/4;
        }
        System.out.println("==Promedio por estudiante==");
        for (int i = 0; i < promediosEstudiante.length; i++) {
            System.out.println("Para el estudiante "+estudiante[i]+"su promedio fue de: "+promediosEstudiante[i]);
        }
        for (int i = 0; i < notasEvaluaciones[0].length; i++) {  // columnas
            for (int j = 0; j < notasEvaluaciones.length; j++) { // filas
                promedioEvaluaciones[i]+=notasEvaluaciones[j][i];
            }
                promedioEvaluaciones[i]=promedioEvaluaciones[i]/5; 
        }
        System.out.println("==Promedio por parcial==");
        for (int i = 0; i < promedioEvaluaciones.length; i++) {
            System.out.println("Para el parcial "+(i+1)+" el promedio fue de: "+promedioEvaluaciones[i]);
        }  
        System.out.println("=Estudiante con mejor promedio");
        int posicionMejorPromedio=0;
        for (int i = 0; i< promediosEstudiante.length; i++) {
            if (promediosEstudiante[i]>promediosEstudiante[posicionMejorPromedio]) {
                posicionMejorPromedio=i;
            }
        }
        System.out.println("El estudiante con mayor promedio fue "+estudiante[posicionMejorPromedio]+"("+promediosEstudiante[posicionMejorPromedio]+")");

        System.out.println("==RESULTADOS FINALES");
        System.out.println("ESTUDIANTE   |parcial 1 | parcial 2| parcial 3| pacial 4|ESTADO");
        for (int i= 0; i < estudiante.length; i++) {
            System.out.print(estudiante[i] +"  ");
            for (int j = 0; j < notasEvaluaciones[i].length; j++) {
                System.out.print(notasEvaluaciones[i][j]+" ");
            }
            System.out.print((promediosEstudiante[i]>=3.0)?"Aprobado \n ":"Reprobado \n");
        }
        sc.close();
    }
}
