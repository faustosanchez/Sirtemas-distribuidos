package server;
import java.net.*;
import java.io.*;
import java.text.*;
import java.util.*;
import rmi.EchoInterface;
public class EchoObjectSkeleton implements EchoInterface {
    String myURL="localhost";
    //Clase de donde se llaman los metodos
    private static Verificacion_Banco2 vb= new Verificacion_Banco2();

    //Constructor de la clase EchoObjectSkeleton
    public EchoObjectSkeleton()
    {
        try {
// obtengo el nombre del equipo donde estoy ejecutando y lo guardo en la propiedad MyURL
            myURL=InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) 
               {
                // si no pude conocer el nombre del equipo, mantengo el nombre localhost para MyURL
               myURL="localhost";
              }
    }
// el Metodo Echo que es la implementacion de la interfaz EchoInterface
    public int pago(Float monto,int tarjeta, int cvv) throws java.rmi.RemoteException 

    {
        
// toma la fecha y hora 
        // escribe la fecha y la hora, nombre de compuadora y lo regresa
        Date h = new Date();
        int checar=0;
           
        // obtengo la fecha y hora actual 
        String fecha = DateFormat.getTimeInstance(3,Locale.FRANCE).format(h);
        /*
        String[] array = input.split("-");//Split para obtener los datos
        String tarjeta_s = array[0]; 
        String monto_s = array[1];
        String cvv_s = array[2];
        int tarjeta_int;
        int cvv_int;
        float monto_float;
        tarjeta_int=Integer.parseInt(tarjeta_s);//Parseo de Tarjeta
        monto_float=Float.parseFloat(monto_s);//Parseo de Monto
        cvv_int=Integer.parseInt(cvv_s);//Parseo de CVV
        */
        String ret = myURL + ":" + fecha + "> " + tarjeta;
        checar=vb.pago(monto, tarjeta, cvv);
        System.out.println("El pago fue");
                if(checar==1)
        {
            System.out.println("Exitoso");
        }
        else{
            System.out.println("Rechazado");
        }
        System.out.println("Procesando: '" + tarjeta + "'");
        try {
            Thread.sleep(3000); // hilo actual
            ret = ret + " (retrasada 3 segundos)";
        } catch (InterruptedException e) {}
        System.out.println("Procesamiento de '"+ tarjeta +"'terminado.");
        //return ret;
        return checar;
    }
   }