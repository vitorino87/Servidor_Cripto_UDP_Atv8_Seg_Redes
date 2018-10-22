package servidor_cripto_udp_atv8_seg_redes;

// created on 29/09/2010 at 22:33
import java.io.*;
import java.net.*;

class UDPServer {
    //public static void main(String args[]) throws Exception

    public void iniciarComunicacao() throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        String sentence;
        
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("******************************************************");
            System.out.println("Servidor aguardando...");
            serverSocket.receive(receivePacket);
            sentence = new String(receivePacket.getData());
            //int q = Integer.valueOf(sentence.substring(0, sentence.indexOf("|")));
            //sentence = sentence.substring(sentence.indexOf("|")+1);
            //sentence = sentence.substring(0, q);
            sentence = sentence.trim();
            System.out.println("Mensagem recebida: " + sentence);
            System.out.println("Para descriptografar a mensagem, digite a senha:");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String senha = br.readLine();
            StringEncrypter c = new StringEncrypter(senha);
            sentence = c.decrypt(sentence);
            System.out.println("Mensagem descriptografada: "+sentence);           
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
            receivePacket = null;
            receiveData = null;
            receiveData = new byte[1024];
            System.out.println("******************************************************");
        }
    }
}
