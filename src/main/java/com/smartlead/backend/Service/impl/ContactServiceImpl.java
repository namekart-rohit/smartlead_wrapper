package com.smartlead.backend.Service.impl;


import com.smartlead.backend.Entity.Contact;
import com.smartlead.backend.Respository.ContactRepository;
import com.smartlead.backend.Service.ContactService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact createContact(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> getContactById(Long contactId) {
        return contactRepository.findByContactIdAndDeletedAtIsNull(contactId);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAllByDeletedAtIsNull();
    }

    @Override
    public Contact updateContact(Long contactId, Contact contact) {
        contact.setContactId(contactId);
        contact.setUpdatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long contactId) {
        Optional<Contact> contactOpt = contactRepository.findByContactIdAndDeletedAtIsNull(contactId);
        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            contact.setDeletedAt(LocalDateTime.now());
            contactRepository.save(contact);
        }
    }
    @Override
    public List<Contact> getAllDeletedContacts() {
        return contactRepository.findAllByDeletedAtIsNotNull();
    }
}