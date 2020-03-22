package io.javabrains.courseapidata.topic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestMapping("/topics")
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping(path = "{id}")
    public Optional<Topic> getTopic(@PathVariable("id") String id){
        return topicService.getTopic(id);
    }

    @PostMapping
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping(path = "{id}")
    public void updateTopic(@PathVariable String id,
                            @RequestBody Topic topic){
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}