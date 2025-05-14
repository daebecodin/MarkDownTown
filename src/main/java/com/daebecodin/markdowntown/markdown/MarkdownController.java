package com.daebecodin.markdowntown.markdown;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*Request to be made
* GET /markdowns: get all markdowns
TODO GET /markdowns:{id} - get specific markdown by id
TODO POST /markdowns: create a new markdown(request body should contain markdown content)
TODO DELETE /markdowns{id}: delete a specific markdown by id
TODO PUT /markdowns{id}: update a specific markdown
TODO GET /markdowns{id}/author: get the author of the markdown

 Example API URL's
 GET {base_url}/markdowns
 GET {base_url}/markdowns/1
 POST {base_url}/markdowns
 DELETE {base_url}/markdowns/1
 PUT {base_url}/markdowns/1
  GET {base_url}/markdowns/1/author
 */

@RestController
public class MarkdownController {
    private MarkdownService markdownService;

    public MarkdownController(MarkdownService markdownService) {
        this.markdownService = markdownService;
    }
    @GetMapping("/markdowns")
    public List<Markdown> findAll() {
        return markdownService.findAll();
    }

    @PostMapping("/markdowns")
    public String createMarkdowns(@RequestBody Markdown markdown) {
        markdownService.createMarkdown(markdown);
        return "markdown  added successfully";
    }

}

