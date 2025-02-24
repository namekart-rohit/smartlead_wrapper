package com.smartlead.backend.Service;



import com.smartlead.backend.Entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact createContact(Contact contact);
    Optional<Contact> getContactById(Long contactId);
    List<Contact> getAllContacts();
    Contact updateContact(Long contactId, Contact contact);
    void deleteContact(Long contactId);  // Soft delete
    List<Contact> getAllDeletedContacts();
}