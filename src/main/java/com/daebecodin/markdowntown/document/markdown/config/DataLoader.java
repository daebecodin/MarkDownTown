package com.daebecodin.markdowntown.document.markdown.config;

import com.daebecodin.markdowntown.document.markdown.Markdown;
import com.daebecodin.markdowntown.document.markdown.MarkdownRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner commandLineRunner(MarkdownRepository markdownRepository)  {
        return args -> {
            Markdown m1 = new Markdown("markdown-1" );
            Markdown m2 = new Markdown("markdown-2");
        };
    }
}
