package com.smartlead.backend.Respository;


import com.smartlead.backend.Entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Optional<Tag> findByTagText(String tagText);
}
