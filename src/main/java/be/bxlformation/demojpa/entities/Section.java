package be.bxlformation.demojpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "section")
@Table()
public class Section {

    @Column(name = "section_id")
    private long section_id;

    @Column(name = "section_name")
    private String section_name;

    @Column(name = "delegate_id")
    private int delegate_id;

    public void setSection_id(Long section_id) {
        this.section_id = section_id;
    }

    @Id
    public Long getSection_id() {
        return section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Integer getDelegate_id() {
        return delegate_id;
    }

    public void setDelegate_id(Integer delegate_id) {
        this.delegate_id = delegate_id;
    }
}
