package scheduler;

import api.endpoints.AccountCreationRequest;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import test.TestAccountCreation;

import java.io.IOException;

@Component
@EnableScheduling
@Slf4j
public class SchedulerExecutor {


    public  final TestAccountCreation testAccountCreation;

    @Autowired
    public SchedulerExecutor(TestAccountCreation testAccountCreation) {
        this.testAccountCreation = testAccountCreation;
    }

    @Scheduled(cron = "0 0 * * * *") // Execute every hour
    public void executeHourlyTask() {
        try {
            log.info("************** Executing hourly task  **************");
            //testAccountCreation.createUser();
            testAccountCreation.searchUser();
            log.info("************** Hourly task execution completed ********");
        } catch (IOException | ParseException e) {
            log.error("Error executing hourly task: {}", e.getMessage());
        }
    }
}
