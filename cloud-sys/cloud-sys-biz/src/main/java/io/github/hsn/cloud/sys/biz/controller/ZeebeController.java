package io.github.hsn.cloud.sys.biz.controller;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.worker.JobWorker;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("zeebe")
public class ZeebeController {

    @Resource
    private ZeebeClient zeebeClient;

    @GetMapping
    public void test() {
        JobWorker open = zeebeClient.newWorker()
                .jobType("io.camunda.zeebe:userTask")
                .handler((client, job) -> {
                    System.out.println(job);
                })
                .open();
        System.out.println(open);
//        ProcessInstanceEvent test = zeebeClient.newCreateInstanceCommand()
//                .bpmnProcessId("test")
//                .latestVersion()
////                .tenantId(TenantUtil.getCurrentTenantId())
//                .send()
//                .join();
//        System.out.println(test);
    }
}
