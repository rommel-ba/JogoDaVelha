/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import redis.clients.jedis.Jedis;

/**
 *
 * @author rommel
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("localhost");
//        jedis.set("chave1", "valor1");
//        jedis.set("chave2", "valor2");
//        jedis.set("chave3", "valor3");
//        jedis.set("chave4", "valor4");
//        String key = jedis.randomKey();
//        System.out.println(jedis.get(key));
//        jedis.del(key);
//        System.out.println("Tentar imprimir depois de excluir");
//        System.out.println(jedis.get(key));

//          JediSubscriber sub = new JediSubscriber();
//          sub.setupSubscriber();
          JediPublisher pub = new JediPublisher();
          pub.setupPublisher();
    }
    
}
