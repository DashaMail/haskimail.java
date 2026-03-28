package ru.haskimail.client.data.model.domains;

/**
 * Модель домена.
 */
public class Domain {
    private String name;
    private Boolean spfVerified;
    private Boolean dkimVerified;
    private Boolean weakDKIM;
    private Boolean returnPathDomainVerified;
    private Integer id;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Boolean getSpfVerified() { return spfVerified; }
    public void setSpfVerified(Boolean v) { this.spfVerified = v; }
    public Boolean getDkimVerified() { return dkimVerified; }
    public void setDkimVerified(Boolean v) { this.dkimVerified = v; }
    public Boolean getWeakDKIM() { return weakDKIM; }
    public void setWeakDKIM(Boolean v) { this.weakDKIM = v; }
    public Boolean getReturnPathDomainVerified() { return returnPathDomainVerified; }
    public void setReturnPathDomainVerified(Boolean v) { this.returnPathDomainVerified = v; }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}
