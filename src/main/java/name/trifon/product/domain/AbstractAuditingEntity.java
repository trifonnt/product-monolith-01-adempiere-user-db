package name.trifon.product.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Base abstract class for entities which will hold definitions for created,
 * last modified by and created, last modified by date.
 */
@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@CreatedBy
	@Column(name = "createdby", nullable = false, length = 50, updatable = false) // @Trifon old: createdby
	private Long createdBy; //@Trifon

	@JsonIgnore
	@CreatedDate
	@Column(name = "created", nullable = false) //@Trifon old: created_date
	private ZonedDateTime createdDate = ZonedDateTime.now();

	@JsonIgnore
	@LastModifiedBy
	@Column(name = "updatedby", length = 50) // @Trifon old: last_modified_by
	private Long lastModifiedBy; // @Trifon

	@JsonIgnore
	@LastModifiedDate
	@Column(name = "updated") // @Trifon old: last_modified_date
	private ZonedDateTime lastModifiedDate = ZonedDateTime.now();


	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public ZonedDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(ZonedDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public ZonedDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
