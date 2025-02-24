package com.smartlead.backend.Controller;


import com.smartlead.backend.Entity.Contact;
import com.smartlead.backend.Service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact createdContact = contactService.createContact(contact);
        return ResponseEntity.ok(createdContact);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable("id") Long contactId) {
        return contactService.getContactById(contactId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") Long contactId, @RequestBody Contact contact) {
        Contact updatedContact = contactService.updateContact(contactId, contact);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable("id") Long contactId) {
        contactService.deleteContact(contactId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<Contact>> getDeletedContacts() {
        return ResponseEntity.ok(contactService.getAllDeletedContacts());
    }
}