package controllers;


import models.Topic;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public class TopicController {
    private final List<Topic> topics = new ArrayList<>();

    public TopicController() {
        topics.add(new Topic("1", "Home", "home, main", "Welcome to the homepage", "0"));
        topics.add(new Topic("2", "About", "about, information", "About the website", "1"));
        topics.add(new Topic("3", "Contact", "contact, support", "Contact us for more information", "1"));
        topics.add(new Topic("4", "Products", "products, items", "Browse our product catalog", "1"));
        topics.add(new Topic("5", "Services", "services, offerings", "Explore our services", "1"));
        topics.add(new Topic("6", "FAQ", "faq, questions", "Frequently asked questions", "1"));
    }
    @GetMapping("/topic/all")
    public String getAllTopics(ModelMap model) {
        model.addAttribute("topicList", topics);
        return "view/TopicList";
    }

    @GetMapping("/topic/new")
    public String getNewTopic(ModelMap model) {
        model.addAttribute("topic", new Topic());
        return "view/TopicNew";
    }

    @PostMapping("/topic/new")
    public String postNewTopic(@ModelAttribute Topic topic) {
        topics.add(topic);
        return "redirect:/topic/all";
    }

    @GetMapping("/topic/view/{id}")
    public String getTopicById(@PathVariable String id, ModelMap model) {
        Topic foundTopic = topics.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("topicView", foundTopic);
        return "view/TopicView";
    }

    @GetMapping("/topic/edit/{id}")
    public String getEditTopic(@PathVariable String id, ModelMap model) {
        Topic foundTopic = topics.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        model.addAttribute("topicEdit", foundTopic);
        return "view/TopicEdit";
    }

    @PostMapping("/topic/edit/{id}")
    public String postEditTopic(@PathVariable String id, @ModelAttribute Topic topic) {
        Topic existingTopic = topics.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (existingTopic != null) {
            existingTopic.setPageName(topic.getPageName());
            existingTopic.setKeyword(topic.getKeyword());
            existingTopic.setContent(topic.getContent());
            existingTopic.setParentPageId(topic.getParentPageId());
        }
        return "redirect:/topic/all";
    }

    @GetMapping("/topic/delete/{id}")
    public String getDeleteTopic(@PathVariable String id) {
        topics.removeIf(t -> t.getId().equals(id));
        return "redirect:/topic/all";
    }
}
