package jogodavelha;

import java.util.Scanner;
import org.json.JSONObject;
import redis.clients.jedis.Jedis;

public class JediPublisher {
    private String servidor = "localhost";
    
    public void setupPublisher(){
        Jedis jedis = new Jedis(servidor);
        Scanner entrada = new Scanner(System.in);
        String msg;
        JSONObject json = new JSONObject();
        System.out.println("Conectado ao servidor");
        do{
            msg = entrada.nextLine();
            json.put("usuario", "Usuario Teste Json: ");
            json.put("mensagem", msg);
            jedis.publish("canal", json.toString());
        }while(!(msg.equals("sair")));
//        jedis.publish("canal", "mensagem");
        System.out.println("Mensagem publicada no canal");
        jedis.quit();
        System.out.println("Conexão encerrada");
    }
}
