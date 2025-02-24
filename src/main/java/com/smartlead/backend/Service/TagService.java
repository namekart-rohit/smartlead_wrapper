package com.smartlead.backend.Service;

import com.smartlead.backend.Entity.Lead;
import com.smartlead.backend.Entity.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Tag createTag(Tag tag);
    Optional<Tag> getTagById(Long tagId);
    List<Tag> getAllTags();
    Tag updateTag(Long tagId,Tag tag);
    void deleteTag(Long tagId);
    List<Lead> getLeadsByTagText(String tagText);
    List<Tag> getTagsByLeadId(Long leadId);
}
