import java.io.*;

public class Ejemplo {
    private static Verificacion_Banco2 vb;
   public static void main(String[] args) {
    int checar;    
    System.out.println("Hola Mundo");
        vb = new Verificacion_Banco2();
        checar=vb.pago(10, 123456, 123);
        System.out.println("El pago fue");
                if(checar==1)
        {
            System.out.println("Exitoso");
        }
        else{
            System.out.println("Rechazado");
        }
        int t,cvv;
        float monto;
        t=123456;//tarjeta
        monto=500;//monto
        cvv=123;//cvv
        String cadena=t+"-"+monto+"-"+cvv;
        System.out.println("La cadena es :"+cadena);
        String[] parts = cadena.split("-");
        String part1 = parts[0]; // 123
        String part2 = parts[1];
        String part3 = parts[2];
        System.out.println("Tarjeta:"+part1+" Monto:"+part2+" CVV:"+part3);
 
    }
}