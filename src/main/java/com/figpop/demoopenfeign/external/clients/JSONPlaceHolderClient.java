package com.figpop.demoopenfeign.external.clients;
import com.figpop.demoopenfeign.external.models.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        value = "${external.api.jplaceholder.name}",
        url = "${external.api.jplaceholder.url}")
public interface JSONPlaceHolderClient {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts() throws Exception;

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
    Post getPostById(@PathVariable("postId") Long postId) throws Exception;
}
