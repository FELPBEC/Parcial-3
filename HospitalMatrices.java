import java.util.Scanner;
public class HospitalMatrices {
    public static void main(String[] args) {
        int[][]camasHospital=new int[3][6];
        int[]camasDesocupadasPorPiso=new int[3];
        byte option=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("A continuación escriba \n 1 en caso de que la habitación este ocupada \n 0 en caso de que este desocupada");
        for (int i = 0; i < camasHospital.length; i++) {
            for (int j = 0; j < camasHospital[i].length; j++) {
                System.out.println("Para la habitación "+ (j+1)+" del piso "+(i+1));
                camasHospital[i][j]=sc.nextInt();
            }
        }
        do {
            System.out.println(" Ingrese el número según su acción: \n 1. Mirar el estado de disponibilidad de las habitaciones \n 2. Disponibilidad de la habitación \n 3. Buscar la disponibilidad de una habitación en especifico \n 4. Modificar el estado de una habitación");
            option=sc.nextByte();
            switch (option) {
                case 1:
                    for (int i = 0; i < camasHospital.length; i++) {
                        for (int j = 0; j < camasHospital[i].length; j++) {
                            System.out.print((camasHospital[i][j]==0)?" v ":" X ");
                        }
                    System.out.println();
                    }
                    break;
                case 2:
                int CamasDisponibles=0;
                int pisoMayorDisponibilidad=0;
                    for (int i = 0; i < camasHospital.length; i++) {
                        for (int j = 0; j < camasHospital[i].length; j++) {
                           if(camasHospital[i][j]==0){
                           CamasDisponibles++;
                           camasDesocupadasPorPiso[i]++;
                           }
                        }
                    }
                    for (int i = 0; i < camasDesocupadasPorPiso.length; i++) {
                        if(camasDesocupadasPorPiso[i]>camasDesocupadasPorPiso[pisoMayorDisponibilidad]){
                            pisoMayorDisponibilidad=i;
                        }
                    }
                    System.out.println("El total de camas disponibles en el hospital es: "+CamasDisponibles);
                    for (int i = 0; i < camasDesocupadasPorPiso.length; i++) {
                        System.out.println("Hay: "+ (6-camasDesocupadasPorPiso[i])+" camas ocupadas en el piso "+ (i+1));
                    }
                    System.out.println("El piso con mayor disponibilidad de habitaciones es el: "+ (pisoMayorDisponibilidad+1));

                break;
                case 3:
                System.out.println("Ingrese el piso de la habitación (1-3)");
                int piso=sc.nextInt()-1;
                System.out.println("Ingrese el número de la habitación (1-6)");
                int habitacion=sc.nextInt()-1;
                for (int i = 0; i < camasHospital.length; i++) {
                    for (int j = 0; j < camasHospital[i].length; j++) {
                        if (i==piso && j==habitacion) {
                            System.out.print("La cama esta");
                            System.out.println((camasHospital[i][j]==0)? " v Disponible": "X Ocupada");
                        }
                    }
                }
                break;
                case 4:
                System.out.println("Ingrese el piso de la habitación (1-3)");
                 piso=sc.nextInt()-1;
                System.out.println("Ingrese el número de la habitación (1-6)");
                habitacion=sc.nextInt()-1;
                for (int i = 0; i < camasHospital.length; i++) {
                    for (int j = 0; j < camasHospital[i].length; j++) {
                        if (i==piso && j==habitacion) {
                            System.out.println("Ingrese el nuevo estado de la habitación (0 para desocupada, 1 para ocupada)");
                            camasHospital[i][j]=sc.nextInt();
                            for (int j2 = 0; j2 < camasHospital[i].length; j2++) {
                            System.out.print((camasHospital[i][j2]==0)?" v ":" X ");
                        }
                        }
                        System.out.println();
                    }
                }
                break;
                default:
                    break;
            }
        } while (option<5);
        sc.close();
    }
}
