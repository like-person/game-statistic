package statistic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;

public class Event {

	@Id private String id;

	private String secretKey;
	private String eventName;
	private String eventIp;
       	private String eventTime;


	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
        
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;

                //При добавлении события фиксируем время принятия и IP отправителя
                
                this.eventTime = LocalDateTime.now().toString();
                
                String IP;
                IP = "0.0.0.0";
                try {
                    InetAddress i = InetAddress.getLocalHost();
                    IP =  i.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                this.eventIp = IP;
	}
        
	public String getEventIp() {
		return eventIp;
	}
       
	public String getEventTime() {
		return eventTime;
	}
}
