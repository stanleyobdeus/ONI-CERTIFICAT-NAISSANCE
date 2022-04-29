package oni.gouv.ht.Configuration;


import oni.gouv.ht.Models.Messagerie;
import oni.gouv.ht.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronService {

    @Autowired
    RequestRepository requestRepository;


    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @Scheduled(cron="*/3 * * * * ?")
    public void demoServiceMethod()
    {

       Long countRequest=requestRepository.count();
       messagingTemplate.convertAndSend("/topic/messages", new Messagerie(countRequest+""));
    }
}
