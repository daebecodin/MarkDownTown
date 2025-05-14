package com.daebecodin.markdowntown.markdown;

import java.util.List;

//making this for lose coupling
public interface MarkdownService {

    //this methods returns a list of ll markdowns
    List<Markdown> findAll();


    void createMarkdown(Markdown markdown);
}
