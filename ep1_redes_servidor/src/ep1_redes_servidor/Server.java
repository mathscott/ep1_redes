package ep1_redes_servidor;

import java.io.*;
import java.net.*;
 
class Server
{
   public static void main(String argv[]) throws Exception
      {
 
            System.out.println(" Server is Running  " );
         ServerSocket mysocket = new ServerSocket(5555);
         //comentario2
         while(true)
         {
            Socket connectionSocket = mysocket.accept();
 
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            BufferedWriter writer= 
                    new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
 
            writer.write(" Bem-vindo ao incrivel HUB de games do EP de Redes!!!! \r\n");
            writer.write("*** Insira o numero correspondente ao jogo que deseja jogar e pressione Enter : \n"
                    + "1 - Forca\n"
                    + "2 - Velha\n"
                    + "3 - Pedra-Papel-Tesoura\n");
            writer.flush();
            String data1 = reader.readLine().trim();
   
            
            int opcaoJogo=Integer.parseInt(data1);
            String respostaOpcaoJogo = "Numero invalido!";
 
            switch(opcaoJogo){
            case 1:
                respostaOpcaoJogo = "Jogo da Forca selecionado!";
                break;
            case 2:
                respostaOpcaoJogo = "Jogo da Velha selecionado!";
                break;
            case 3:
                respostaOpcaoJogo = "Pedra-Papel-Tesoura selecionado!";
                break;
            }

            System.out.println("Opcao de jogo selecionada.");
 
            writer.write("\r\n"+respostaOpcaoJogo);
            writer.flush();
            connectionSocket.close();
         }
      }
}