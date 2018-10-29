package com.nationwide.pilotadmin.controller;

import com.nationwide.pilotadmin.repository.LabelRepository;
import com.nationwide.pilotadmin.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author rushidesai
 */
@RestController
public class CanaryController {

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    PilotRepository pilotRepository;

    @GetMapping("/")
    @ResponseBody
    public Mono<String> hello() {
        return Mono.just("Running");
    }



/*
    @GetMapping("/pilots")
    @ResponseBody
    public Mono<Iterable<Node>> pilots() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Iterable<Node> pilots = pilotRepository.findAll(pageRequest);
        return Mono.just(pilots);
    }

    @GetMapping("/pilots/{pilotName}")
    @ResponseBody
    public Mono<Node> pilot(@PathVariable("pilotName") String pilotName) {
//        PageRequest pageRequest = PageRequest.of(1, 10);
        Node node = pilotRepository.findByName(pilotName);
        return Mono.just(node);
    }
*/

//    @PutMapping("/nodes/{pilotName}")
//    @ResponseBody
//    public Mono<Node> pilotPut(@PathVariable("pilotName") String pilotName) {
////        PageRequest pageRequest = PageRequest.of(1, 10);
//        Node build = Node.builder().name(pilotName).build();
//        Node pilot = pilotRepository.save(build);
//        return Mono.just(pilot);
//    }
}
