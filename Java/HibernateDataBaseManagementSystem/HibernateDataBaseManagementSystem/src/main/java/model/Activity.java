package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alberto Fernández Merchán
 */
@Entity
@Table(name = "ACTIVITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a"),
    @NamedQuery(name = "Activity.findByAId", query = "SELECT a FROM Activity a WHERE a.aId = :aId"),
    @NamedQuery(name = "Activity.findByAName", query = "SELECT a FROM Activity a WHERE a.aName = :aName"),
    @NamedQuery(name = "Activity.findByADescription", query = "SELECT a FROM Activity a WHERE a.aDescription = :aDescription"),
    @NamedQuery(name = "Activity.findByAPrize", query = "SELECT a FROM Activity a WHERE a.aPrize = :aPrize")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "A_ID")
    private String aId;
    @Basic(optional = false)
    @Column(name = "A_NAME")
    private String aName;
    @Column(name = "A_DESCRIPTION")
    private String aDescription;
    @Column(name = "A_PRIZE")
    private Short aPrize;
    @JoinTable(name = "PERFORMS", joinColumns = {
        @JoinColumn(name = "P_ID", referencedColumnName = "A_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "P_NUM", referencedColumnName = "M_NUM")})
    @ManyToMany
    private Set<Member1> member1Set = new HashSet<Member1>();
    @JoinColumn(name = "A_TRAINERINCHARGE", referencedColumnName = "T_COD")
    @ManyToOne
    private Trainer aTrainerincharge;

    /**
     * Constructor of the class
     */
    public Activity() {
    }

    /**
     * Add a member who performs the activity.
     *
     * @param m
     */
    public void addMember(Member1 m) {

        member1Set.add(m);
        m.getActivitySet().add(this);

    }

    /**
     * Constructor of the class with 1 parameter.
     *
     * @param aId
     */
    public Activity(String aId) {
        this.aId = aId;
    }

    /**
     * Constructor of the class with 2 parameters
     *
     * @param aId
     * @param aName
     */
    public Activity(String aId, String aName) {
        this.aId = aId;
        this.aName = aName;
    }

    /**
     * Gets the id of the activity
     *
     * @return
     */
    public String getAId() {
        return aId;
    }

    /**
     * Sets the id of the activity
     *
     * @param aId
     */
    public void setAId(String aId) {
        this.aId = aId;
    }

    /**
     * Gets the activity's name
     *
     * @return
     */
    public String getAName() {
        return aName;
    }

    /**
     * Sets the activity's name
     *
     * @param aName
     */
    public void setAName(String aName) {
        this.aName = aName;
    }

    /**
     * Get's the activity's description
     *
     * @return
     */
    public String getADescription() {
        return aDescription;
    }

    /**
     * Sets the activity's description
     *
     * @param aDescription
     */
    public void setADescription(String aDescription) {
        this.aDescription = aDescription;
    }

    /**
     * Get's the activity prize.
     *
     * @return
     */
    public Short getAPrize() {
        return aPrize;
    }

    /**
     * Sets the activity prize
     *
     * @param aPrize
     */
    public void setAPrize(Short aPrize) {
        this.aPrize = aPrize;
    }

    /**
     * Gets a list of all the members who performs this activity.
     *
     * @return
     */
    @XmlTransient
    public Set<Member1> getMember1Set() {
        return member1Set;
    }

    /**
     * Sets a list of all the members who performs this activity.
     *
     * @param member1Set
     */
    public void setMember1Set(Set<Member1> member1Set) {
        this.member1Set = member1Set;
    }

    /**
     * Gets the trainer who is in charge of this activity.
     *
     * @return
     */
    public Trainer getATrainerincharge() {
        return aTrainerincharge;
    }

    /**
     * Sets the trainer who is in charge of this activity.
     *
     * @param aTrainerincharge
     */
    public void setATrainerincharge(Trainer aTrainerincharge) {
        this.aTrainerincharge = aTrainerincharge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aId != null ? aId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.aId == null && other.aId != null) || (this.aId != null && !this.aId.equals(other.aId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Activity[ aId=" + aId + " ]";
    }

}
