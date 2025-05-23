package com.daebecodin.mdt.markdown;


import com.daebecodin.mdt.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MarkdownServiceImpl implements MarkdownService {

    private final MarkdownRepository markdownRepository;

    @Autowired
    public MarkdownServiceImpl(MarkdownRepository markdownRepository) {
        this.markdownRepository = markdownRepository;
    }

    @Override
    public List<MarkdownDto> getAllMarkdowns() {
        return markdownRepository.findAll()
                .stream()
                .map(MarkdownDto::fromEntity)
                .toList();
    }

    @Override
    public Optional<MarkdownDto> getMarkdownById(UUID userId) {
        return markdownRepository.findById(userId)
                .map(MarkdownDto::fromEntity);

    }


}
