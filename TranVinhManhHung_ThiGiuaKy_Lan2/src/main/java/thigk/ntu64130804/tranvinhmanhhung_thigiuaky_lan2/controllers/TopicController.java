package thigk.ntu64130804.tranvinhmanhhung_thigiuaky_lan2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import thigk.ntu64130804.tranvinhmanhhung_thigiuaky_lan2.models.Topic;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TopicController {

    private final List<Topic> topicList = new ArrayList<>();

    public TopicController() {
        topicList.add(new Topic("1", "AI in Education", "Research on applying AI in teaching", "GV001", "Research"));
        topicList.add(new Topic("2", "E-commerce App", "Developing a full-stack e-commerce app", "GV002", "Development"));
        topicList.add(new Topic("3", "Blockchain Voting System", "A voting system based on blockchain", "GV003", "Research"));
    }

    @GetMapping("/topic/all")
    public String getAllTopics(ModelMap model) {
        model.addAttribute("topics", topicList);
        return "view/TopicList";
    }

    @GetMapping("/topic/new")
    public String getNewTopicForm(ModelMap model) {
        model.addAttribute("topic", new Topic());
        return "view/TopicNew";
    }

    @PostMapping("/topic/new")
    public String postNewTopic(@ModelAttribute Topic topic) {
        topicList.add(topic);
        return "redirect:/topic/all";
    }

    @GetMapping("/topic/view/{id}")
    public String getTopicById(@PathVariable String id, ModelMap model) {
        Topic selectedTopic = topicList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("topic", selectedTopic);
        return "view/TopicView";
    }

    @GetMapping("/topic/edit/{id}")
    public String getEditTopicForm(@PathVariable String id, ModelMap model) {
        Topic selectedTopic = topicList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("topic", selectedTopic);
        return "view/TopicEdit";
    }

    @PostMapping("/topic/edit/{id}")
    public String postEditTopic(@PathVariable String id, @ModelAttribute Topic updatedTopic) {
        Topic existingTopic = topicList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingTopic != null) {
            existingTopic.setTopicName(updatedTopic.getTopicName());
            existingTopic.setTopicDescription(updatedTopic.getTopicDescription());
            existingTopic.setSupervisorId(updatedTopic.getSupervisorId());
            existingTopic.setTopicType(updatedTopic.getTopicType());
        }

        return "redirect:/topic/all";
    }

    @GetMapping("/topic/delete/{id}")
    public String deleteTopic(@PathVariable String id) {
        topicList.removeIf(t -> t.getId().equals(id));
        return "redirect:/topic/all";
    }
}
