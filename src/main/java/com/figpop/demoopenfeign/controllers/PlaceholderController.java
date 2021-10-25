package com.figpop.demoopenfeign.controllers;

import com.figpop.demoopenfeign.external.clients.JSONPlaceHolderClient;
import com.figpop.demoopenfeign.external.models.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceholderController {

    private final JSONPlaceHolderClient jsonPlaceHolderClient;
    public PlaceholderController(JSONPlaceHolderClient jsonPlaceHolderClient) {
        this.jsonPlaceHolderClient = jsonPlaceHolderClient;
    }
    @GetMapping("/places")
    public ResponseEntity<List<Post>> getPosts() throws Exception {
        return ResponseEntity.ok().body(jsonPlaceHolderClient.getPosts());
    }

    @GetMapping("/places/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable Long postId) throws Exception {
        return ResponseEntity.ok(jsonPlaceHolderClient.getPostById(postId));
    }

}
