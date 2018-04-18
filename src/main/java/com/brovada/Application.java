package com.brovada;

import com.brovada.document.Job;
import com.brovada.document.JobConfig;
import com.brovada.document.config.DefaultJob;
import com.brovada.document.config.DefaultJobConfig;
import com.brovada.repository.JobConfigRepository;
import com.brovada.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private JobConfigRepository jobConfigRepository;

    @Autowired
    private JobRepository jobRepository;
    
    public static void main(String[] args) {

        // check application.properties for port.   currently 9090.
        SpringApplication.run(Application.class, args);

//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
//
//        System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }


    @Override
    public void run(String... args) throws Exception {

        initDb();

        System.out.println("JobConfigs found with findAll():");
        System.out.println("-------------------------------");
        for (JobConfig jobConfig : jobConfigRepository.findAll()) {
            System.out.println(jobConfig);
        }
        System.out.println();
        System.out.println("Jobs found with findAll():");
        System.out.println("-------------------------------");
        for (Job job : jobRepository.findAll()) {
            System.out.println(job);
        }
        System.out.println();
    }

    private void initDb() {
        jobConfigRepository.deleteAll();

        DefaultJobConfig defaultJobConfig = new DefaultJobConfig();
        jobConfigRepository.save(defaultJobConfig);
       

        jobRepository.deleteAll();
        jobRepository.save(new DefaultJob().withJobConfig(defaultJobConfig));

    }

}
