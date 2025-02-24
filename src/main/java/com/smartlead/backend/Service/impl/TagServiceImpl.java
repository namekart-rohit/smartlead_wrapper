package com.smartlead.backend.Service.impl;


import com.smartlead.backend.Entity.Lead;
import com.smartlead.backend.Entity.LeadTag;
import com.smartlead.backend.Entity.Tag;
import com.smartlead.backend.Respository.LeadTagRepository;
import com.smartlead.backend.Respository.TagRepository;
import com.smartlead.backend.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final LeadTagRepository leadTagRepository;

    public TagServiceImpl(TagRepository tagRepository, LeadTagRepository leadTagRepository) {
        this.tagRepository = tagRepository;
        this.leadTagRepository = leadTagRepository;
    }

    @Override
    public Tag createTag(Tag tag) {
        tag.setCreatedAt(LocalDateTime.now());
        tag.setUpdatedAt(LocalDateTime.now());
        return tagRepository.save(tag);
    }

    @Override
    public Optional<Tag> getTagById(Long tagId) {
        return tagRepository.findById(tagId);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag updateTag(Long tagId, Tag tag) {
        Optional<Tag> existingOpt = tagRepository.findById(tagId);
        if (existingOpt.isPresent()) {
            Tag existing = existingOpt.get();
            existing.setTagText(tag.getTagText());
            existing.setColor(tag.getColor());
            existing.setDescription(tag.getDescription());
            existing.setCategory(tag.getCategory());      // Ensure your Tag entity has getCategory() & setCategory()
            existing.setParentTag(tag.getParentTag());
            existing.setIsActive(tag.getIsActive());          // Ensure your Tag entity has getIsActive() & setIsActive()
            existing.setUpdatedAt(LocalDateTime.now());
            existing.setUpdatedBy(tag.getUpdatedBy());
            return tagRepository.save(existing);
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }

    @Override
    public List<Lead> getLeadsByTagText(String tagText) {
        Optional<Tag> tagOpt = tagRepository.findByTagText(tagText);
        if (tagOpt.isEmpty()) {
            return Collections.emptyList();
        }
        Tag tag = tagOpt.get();
        List<LeadTag> leadTags = leadTagRepository.findByTag_TagId(tag.getTagId());
        if (leadTags == null || leadTags.isEmpty()) {
            return Collections.emptyList();
        }
        return leadTags.stream()
                .map(LeadTag::getLead)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tag> getTagsByLeadId(Long leadId) {
        List<LeadTag> leadTags = leadTagRepository.findByLead_LeadId(leadId);
        if (leadTags == null || leadTags.isEmpty()) {
            return Collections.emptyList();
        }
        return leadTags.stream()
                .map(LeadTag::getTag)
                .collect(Collectors.toList());
    }
}