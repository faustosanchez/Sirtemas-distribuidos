
package client;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.xml.transform.Source;

public class EchoClient {
    //definimos el Stub del cliente
    public static Scanner entrada=new Scanner(System.in);
    private static EchoObjectStub ss;
    public static void main(String[] args) 
    {
        // revisamos que los argumentos para ejecutar el programa son correctos
        String cadena="";
        int t,cvv;
        float monto=0;  
        if (args.length<2) {
            System.out.println("Para ejecutar , hazlo en este formato: Echo <nombre o IP del Equipo> <numero de puerto>");
            System.exit(1);
        }
        //instanciamos el STUB
        ss = new EchoObjectStub();
    // le asignamos al STUB el puerto y nombre del equipo HOST (el nombre del servidor) 
        ss.setHostAndPort(args[0],Integer.parseInt(args[1]));
        String input,output;
        try {  
                    //construyo un bucle infinito:
                    int n;
            while(true){
                //Aqui realizaremos el simulado de tienda Online
                System.out.println("Bienvenido a la tienda online!");
                System.out.println("Contamos con los siguientes apartados:");
                System.out.println("0.-Salir");
                System.out.println("1.-Sueter = $500");
                System.out.println("2.- Pantalon = $7000");
                System.out.println("3.- Camisa = $ 2500");
                System.out.println("4.- Laptop DELL N3023 = $ 5000");
                System.out.println("5.- Celular Xiaomi X90 5G = $ 3000");
                do{ 

                     n=entrada.nextInt();
                     if(n<0||n>5)
                     {
                         System.out.println("Opcion No Valida, Intentalo de Nuevo !");
                     }
                }while(n<0||n>5);
                switch (n)
                {
                    case 0:
                    System.exit(0);
                    break;
                    case 1:
                        monto=500;
                    break;
                    case 2:
                        monto=7000;
                    break;
                    case 3:
                        monto=2500;
                    break;
                    case 4:
                        monto=5000;
                    break;
                    case 5:
                        monto=3000;
                    break;
                    default:
                }
                //preparo "apuntador" que es el lector de flujo para el teclado
                BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));
                // asigno a una variable y leo una linea del lector de flujo que leyo del teclado
                //cadena=in.readLine();
                System.out.println("Excelente compran\nDigite la tarjeta digital para procesar su compra");
                cadena=in.readLine();
                t=Integer.parseInt(cadena);//tarjeta
                //cadena=in.readLine();//monto
                //monto=Float.parseFloat(cadena);
                cadena=in.readLine();//cvv
                cvv=Integer.parseInt(cadena);
                //System.out.println("Valores tarjeta="+t+" monto= $"+monto+" cvv="+cvv);
                System.out.println("Procesando la tarjeta="+t+" por un monto= $"+monto);
                // Invocar el stub con el metodo remoto echo e Imprimir .. 
                //por pantalla lo que regreso el metodo remoto echo
                cadena=t+"-"+monto+"-"+cvv;
                //lo guardamos en variable y vemos si rechazo o acepto conexion
                int res=ss.pago(monto,t,cvv);
                if (res==1)
                {
                    System.out.println("Su pago fue Exitoso, El envio esta en camino!! :D");
                }
                else
                {
                    System.out.println("Transaccion No Exitosa\nSu pago fue rechazado");
                }
                System.out.print("\n\n\n\n");
                System.out.flush();

            }
        } 
        //catch (UnknownHostException e) {
            //System.err.println("Don't know about host: "+ args[0]);
        //} 
        catch (IOException e) {
            System.err.println("Falla conexion de E/S con el host:"+args[0]);
        }
    }
}