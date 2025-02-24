package com.smartlead.backend.Controller;


import com.smartlead.backend.Entity.Lead;
import com.smartlead.backend.Entity.Tag;
import com.smartlead.backend.Service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    // Create a new Tag
    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        Tag createdTag = tagService.createTag(tag);
        return ResponseEntity.ok(createdTag);
    }

    // Get Tag by ID
    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable("id") Long tagId) {
        return tagService.getTagById(tagId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all Tags
    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        return ResponseEntity.ok(tags);
    }

    // Update an existing Tag
    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable("id") Long tagId, @RequestBody Tag tag) {
        Tag updatedTag = tagService.updateTag(tagId, tag);
        return ResponseEntity.ok(updatedTag);
    }

    // Delete a Tag (permanent deletion or soft delete as implemented)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable("id") Long tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.ok().build();
    }

    // Get all Leads associated with a given tag text
    @GetMapping("/leads/{tagText}")
    public ResponseEntity<List<Lead>> getLeadsByTagText(@PathVariable("tagText") String tagText) {
        List<Lead> leads = tagService.getLeadsByTagText(tagText);
        return ResponseEntity.ok(leads);
    }

    // Get all Tags associated with a given lead ID
    @GetMapping("/lead/{leadId}")
    public ResponseEntity<List<Tag>> getTagsByLeadId(@PathVariable("leadId") Long leadId) {
        List<Tag> tags = tagService.getTagsByLeadId(leadId);
        return ResponseEntity.ok(tags);
    }
}