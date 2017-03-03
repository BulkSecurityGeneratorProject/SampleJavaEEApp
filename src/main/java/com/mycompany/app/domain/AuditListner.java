package com.mycompany.app.domain;

import java.util.Date;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import com.mycompany.app.security.SecurityUtils;

/**
 * Entity listener class for audit info
 */
public class AuditListner {

    @Inject
    private SecurityUtils securityUtils;

    @PrePersist
    void onCreate(AbstractAuditingEntity entity) {
        entity.setCreatedDate(new Date());
        entity.setCreatedBy(securityUtils.getCurrentUserLogin());
    }

    @PreUpdate
    void onUpdate(AbstractAuditingEntity entity) {
        entity.setLastModifiedDate(new Date());
        entity.setLastModifiedBy(securityUtils.getCurrentUserLogin());
    }
}
