package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alberto Fernández Merchán
 */
@Entity
@Table(name = "TRAINER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t"),
    @NamedQuery(name = "Trainer.findByTCod", query = "SELECT t FROM Trainer t WHERE t.tCod = :tCod"),
    @NamedQuery(name = "Trainer.findByTName", query = "SELECT t FROM Trainer t WHERE t.tName = :tName"),
    @NamedQuery(name = "Trainer.findByTSurname1", query = "SELECT t FROM Trainer t WHERE t.tSurname1 = :tSurname1"),
    @NamedQuery(name = "Trainer.findByTSurname2", query = "SELECT t FROM Trainer t WHERE t.tSurname2 = :tSurname2"),
    @NamedQuery(name = "Trainer.findByTIdnumber", query = "SELECT t FROM Trainer t WHERE t.tIdnumber = :tIdnumber"),
    @NamedQuery(name = "Trainer.findByTPhonenumber", query = "SELECT t FROM Trainer t WHERE t.tPhonenumber = :tPhonenumber"),
    @NamedQuery(name = "Trainer.findByTEmail", query = "SELECT t FROM Trainer t WHERE t.tEmail = :tEmail"),
    @NamedQuery(name = "Trainer.findByTDate", query = "SELECT t FROM Trainer t WHERE t.tDate = :tDate"),
    @NamedQuery(name = "Trainer.findByTNick", query = "SELECT t FROM Trainer t WHERE t.tNick = :tNick")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "T_COD")
    private String tCod;
    @Basic(optional = false)
    @Column(name = "T_NAME")
    private String tName;
    @Basic(optional = false)
    @Column(name = "T_SURNAME1")
    private String tSurname1;
    @Column(name = "T_SURNAME2")
    private String tSurname2;
    @Basic(optional = false)
    @Column(name = "T_IDNUMBER")
    private String tIdnumber;
    @Column(name = "T_PHONENUMBER")
    private String tPhonenumber;
    @Column(name = "T_EMAIL")
    private String tEmail;
    @Column(name = "T_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tDate;
    //private String tDate;
    @Column(name = "T_NICK")
    private String tNick;
    @OneToMany(mappedBy = "aTrainerincharge")
    private Set<Activity> activitySet = new HashSet<Activity>();

    /**
     * Constructor of the class.
     */
    public Trainer() {
    }

    /**
     * Constructor of the class with one parameter.
     *
     * @param tCod
     */
    public Trainer(String tCod) {
        this.tCod = tCod;
    }

    /**
     * Constructor of the class with 4 parameters.
     *
     * @param tCod
     * @param tName
     * @param tSurname1
     * @param tIdnumber
     */
    public Trainer(String tCod, String tName, String tSurname1, String tIdnumber) {
        this.tCod = tCod;
        this.tName = tName;
        this.tSurname1 = tSurname1;
        this.tIdnumber = tIdnumber;
    }

    /**
     * Constructor of the class with all the parameters.
     *
     * @param tCod
     * @param tName
     * @param tSurname1
     * @param tSurname2
     * @param tIdnumber
     * @param tPhonenumber
     * @param tEmail
     * @param tDate
     * @param tNick
     */
    public Trainer(String tCod, String tName, String tSurname1, String tSurname2, String tIdnumber, String tPhonenumber, String tEmail, Date tDate, String tNick) {
        this.tCod = tCod;
        this.tName = tName;
        this.tSurname1 = tSurname1;
        this.tSurname2 = tSurname2;
        this.tIdnumber = tIdnumber;
        this.tPhonenumber = tPhonenumber;
        this.tEmail = tEmail;
        this.tDate = tDate;
        this.tNick = tNick;
    }

    /**
     * Gets the identification of the trainer.
     *
     * @return
     */
    public String getTCod() {
        return tCod;
    }

    /**
     * Sets the identification of the trainer.
     *
     * @param tCod
     */
    public void setTCod(String tCod) {
        this.tCod = tCod;
    }

    /**
     * Gets the trainer's name.
     *
     * @return
     */
    public String getTName() {
        return tName;
    }

    /**
     * Sets the trainer's name
     *
     * @param tName
     */
    public void setTName(String tName) {
        this.tName = tName;
    }

    /**
     * Gets the trainer's first surname.
     *
     * @return
     */
    public String getTSurname1() {
        return tSurname1;
    }

    /**
     * Sets the trainer's first surname.
     *
     * @param tSurname1
     */
    public void setTSurname1(String tSurname1) {
        this.tSurname1 = tSurname1;
    }

    /**
     * Gets the trainer's second surname.
     *
     * @return
     */
    public String getTSurname2() {
        return tSurname2;
    }

    /**
     * Sets the trainer's second surname.
     *
     * @param tSurname2
     */
    public void setTSurname2(String tSurname2) {
        this.tSurname2 = tSurname2;
    }

    /**
     * Gets the identification number of the trainer.
     *
     * @return
     */
    public String getTIdnumber() {
        return tIdnumber;
    }

    /**
     * Sets the identification number of the trainer.
     *
     * @param tIdnumber
     */
    public void setTIdnumber(String tIdnumber) {
        this.tIdnumber = tIdnumber;
    }

    /**
     * Gets the phone number of the trainer.
     *
     * @return
     */
    public String getTPhonenumber() {
        return tPhonenumber;
    }

    /**
     * Sets the phone number of the trainer.
     *
     * @param tPhonenumber
     */
    public void setTPhonenumber(String tPhonenumber) {
        this.tPhonenumber = tPhonenumber;
    }

    /**
     * Gets the email of the trainer.
     *
     * @return
     */
    public String getTEmail() {
        return tEmail;
    }

    /**
     * Sets the email of the trainer.
     *
     * @param tEmail
     */
    public void setTEmail(String tEmail) {
        this.tEmail = tEmail;
    }

    /**
     * Gets the join date of the trainer.
     *
     * @return
     */
    public Date getTDate() {
        return tDate;
    }

    /**
     * Sets the join date of the trainer
     *
     * @param tDate
     */
    public void setTDate(Date tDate) {
        this.tDate = tDate;
    }

    /**
     * Gets the nick of the trainer.
     *
     * @return
     */
    public String getTNick() {
        return tNick;
    }

    /**
     * Sets the nick of the trainer.
     *
     * @param tNick
     */
    public void setTNick(String tNick) {
        this.tNick = tNick;
    }

    /**
     * Get the activities in which the trainer is in charge.
     *
     * @return
     */
    @XmlTransient
    public Set<Activity> getActivitySet() {
        return activitySet;
    }

    /**
     * Sets the activities where the trainer is in charge.
     *
     * @param activitySet
     */
    public void setActivitySet(Set<Activity> activitySet) {
        this.activitySet = activitySet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tCod != null ? tCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.tCod == null && other.tCod != null) || (this.tCod != null && !this.tCod.equals(other.tCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Trainer[ tCod=" + tCod + " ]";
    }

}
