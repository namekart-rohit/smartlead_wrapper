package com.smartlead.backend.Entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class LeadTagId implements Serializable {

    private Long leadId;
    private Long tagId;

    public LeadTagId() {}

    public LeadTagId(Long leadId, Long tagId) {
        this.leadId = leadId;
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeadTagId)) return false;
        LeadTagId that = (LeadTagId) o;
        return Objects.equals(leadId, that.leadId) &&
                Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leadId, tagId);
    }
}
