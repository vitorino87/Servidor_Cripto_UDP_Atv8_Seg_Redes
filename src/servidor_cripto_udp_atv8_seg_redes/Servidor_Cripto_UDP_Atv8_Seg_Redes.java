/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor_cripto_udp_atv8_seg_redes;

/**
 *
 * @author tiago.lucas
 */
public class Servidor_Cripto_UDP_Atv8_Seg_Redes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UDPServer udp = new UDPServer();
        try{
           udp.iniciarComunicacao(); 
        }catch(Exception ex){
            System.out.println("Deu ruim! Erro: "+ex);
        }
    }
    
}
