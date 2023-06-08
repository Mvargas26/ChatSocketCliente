package clientesocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteSocket {

    public static void main(String[] args) {
     Socket cliente = null;
     String ipServidor ="127.0.0.1";	  
	
try {	
 
	cliente = new Socket(ipServidor, 8888);  
	InputStream entrada = cliente.getInputStream();
	OutputStream salida = cliente.getOutputStream();
        String mensajeEntrada="";
        String mensajeSalida="Saludos desde el cliente";
        byte[] vecBytesSalida = mensajeSalida.getBytes();
        byte[] vecBytesEntrada = new byte[2024];
        Scanner entradaUser = new Scanner(System.in);
        
        salida.write(vecBytesSalida);
        System.out.println("Cliente: "+mensajeSalida);
        salida.flush();    
        
        do{
            int bytesRead = entrada.read(vecBytesEntrada);
            byte[] datosReci = new byte[bytesRead];
            System.arraycopy(vecBytesEntrada, 0, datosReci, 0, bytesRead);
            mensajeEntrada = new String(datosReci, java.nio.charset.StandardCharsets.UTF_8);
            System.out.println("Server: " + mensajeEntrada);

            
            System.out.println("Ingrese su Mensaje: ");
            String mensUser = entradaUser.nextLine();
            vecBytesSalida=mensUser.getBytes();
            salida.write(vecBytesSalida);
            System.out.println("Cliente: "+mensUser);
            salida.flush();
        
        }while(!mensajeEntrada.equals("salir"));
        
        cliente.close();
         
       
}
catch (UnknownHostException excepcion) {
	System.err.println("El servidor no está levantado");
}
catch (Exception e) {
	System.err.println("Error: " + e );
}
 

    }//fin main
    
}//fin class


