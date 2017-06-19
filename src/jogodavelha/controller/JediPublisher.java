package jogodavelha.controller;

import org.json.JSONObject;
import redis.clients.jedis.Jedis;

public class JediPublisher {

    private String servidor;
    private Jedis jedis;

    public JediPublisher(String servidor){
        this.servidor = servidor;
    }
    
    public void enviarJogada(Integer[] jogada, String topico){
        JSONObject json = new JSONObject();
        json.put(topico, jogada);
        publicar(topico, json.toString());
    }
    
    private void publicar(String mensagem, String topico) {
        jedis.publish(topico, mensagem);
        jedis.quit();
    }
  
}
