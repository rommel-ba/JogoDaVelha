package jogodavelha;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class JediSubscriber {
    
    public static void main(String args[]){
        JediSubscriber sub = new JediSubscriber();
        sub.setupSubscriber();
    }
    
    private String servidor = "localhost";
    public JedisPubSub setupSubscriber(){
        JedisPubSub jedisPubSub = new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.println(message);
                if(message.equals("sair"))
                    System.exit(0);
            }
        };
        new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Jedis jedis = new Jedis(servidor);
					jedis.subscribe(jedisPubSub, "canal");
					jedis.quit();
				} catch (Exception e) {
					 e.printStackTrace();
				}
			}
		}, "subscriberThread").start();
        return jedisPubSub;
    }
}
