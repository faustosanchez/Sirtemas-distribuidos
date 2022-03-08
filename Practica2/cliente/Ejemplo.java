import java.io.*;

public class Ejemplo {
    private static Verificacion_Banco vb;
   public static void main(String[] args) {
    int checar;    
    System.out.println("Hola Mundo");
        vb = new Verificacion_Banco();
        checar=vb.pago(10, 123456, 1233);
        System.out.println("El pago fue");
                if(checar==1)
        {
            System.out.println("Exitoso");
        }
        else{
            System.out.println("Rechazado");
        }
    }
}