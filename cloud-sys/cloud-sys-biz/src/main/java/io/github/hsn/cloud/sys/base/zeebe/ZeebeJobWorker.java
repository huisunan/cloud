package io.github.hsn.cloud.sys.base.zeebe;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class ZeebeJobWorker {
    @JobWorker(type = "io.camunda.zeebe:userTask")
    public void foo(final JobClient client, final ActivatedJob job) {
        System.out.println(job);
    }

    @JobWorker(type = "userTask")
    public void foo2(final JobClient client, final ActivatedJob job) {
        System.out.println(job);
    }

      @JobWorker(type = "USER_TASK")
    public void foo3(final JobClient client, final ActivatedJob job) {
        System.out.println(job);
    }
}
