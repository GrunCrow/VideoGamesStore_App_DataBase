package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "MEMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Member1.findAll", query = "SELECT m FROM Member1 m"),
    @NamedQuery(name = "Member1.findByMNum", query = "SELECT m FROM Member1 m WHERE m.mNum = :mNum"),
    @NamedQuery(name = "Member1.findByMName", query = "SELECT m FROM Member1 m WHERE m.mName = :mName"),
    @NamedQuery(name = "Member1.findByMId", query = "SELECT m FROM Member1 m WHERE m.mId = :mId"),
    @NamedQuery(name = "Member1.findByMBirhtdate", query = "SELECT m FROM Member1 m WHERE m.mBirhtdate = :mBirhtdate"),
    @NamedQuery(name = "Member1.findByMPhone", query = "SELECT m FROM Member1 m WHERE m.mPhone = :mPhone"),
    @NamedQuery(name = "Member1.findByMEmailmember", query = "SELECT m FROM Member1 m WHERE m.mEmailmember = :mEmailmember"),
    @NamedQuery(name = "Member1.findByMStartingdatemember", query = "SELECT m FROM Member1 m WHERE m.mStartingdatemember = :mStartingdatemember"),
    @NamedQuery(name = "Member1.findByMCathegorymember", query = "SELECT m FROM Member1 m WHERE m.mCathegorymember = :mCathegorymember")})
public class Member1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "M_NUM")
    private String mNum;
    @Basic(optional = false)
    @Column(name = "M_NAME")
    private String mName;
    @Basic(optional = false)
    @Column(name = "M_ID")
    private String mId;
    @Column(name = "M_BIRHTDATE")
    private String mBirhtdate;
    @Column(name = "M_PHONE")
    private String mPhone;
    @Column(name = "M_EMAILMEMBER")
    private String mEmailmember;
    @Column(name = "M_STARTINGDATEMEMBER")
    private String mStartingdatemember;
    @Basic(optional = false)
    @Column(name = "M_CATHEGORYMEMBER")
    private String mCathegorymember;
    @ManyToMany(mappedBy = "member1Set")
    private Set<Activity> activitySet = new HashSet<Activity>();

    /**
     * Constructor of the class
     */
    public Member1() {
    }

    /**
     * Constructor of the class with 1 parameter.
     *
     * @param mNum
     */
    public Member1(String mNum) {
        this.mNum = mNum;
    }

    /**
     * Constructor of the class with 4 parameters.
     *
     * @param mNum
     * @param mName
     * @param mId
     * @param mCathegorymember
     */
    public Member1(String mNum, String mName, String mId, String mCathegorymember) {
        this.mNum = mNum;
        this.mName = mName;
        this.mId = mId;
        this.mCathegorymember = mCathegorymember;
    }

    /**
     * Constructor of the class with all the parameters.
     *
     * @param mNum
     * @param mName
     * @param mId
     * @param mBirhtdate
     * @param mPhone
     * @param mEmailmember
     * @param mStartingdatemember
     * @param mCathegorymember
     */
    public Member1(String mNum, String mName, String mId, String mBirhtdate, String mPhone, String mEmailmember, String mStartingdatemember, String mCathegorymember) {
        this.mNum = mNum;
        this.mName = mName;
        this.mId = mId;
        this.mBirhtdate = mBirhtdate;
        this.mPhone = mPhone;
        this.mEmailmember = mEmailmember;
        this.mStartingdatemember = mStartingdatemember;
        this.mCathegorymember = mCathegorymember;
    }

    /**
     * Gets the id of the member.
     *
     * @return
     */
    public String getMNum() {
        return mNum;
    }

    /**
     * Sets the id of the member.
     *
     * @param mNum
     */
    public void setMNum(String mNum) {
        this.mNum = mNum;
    }

    /**
     * Gets the name of the member.
     *
     * @return
     */
    public String getMName() {
        return mName;
    }

    /**
     * Sets the name of the member.
     *
     * @param mName
     */
    public void setMName(String mName) {
        this.mName = mName;
    }

    /**
     * Gets the id document of the member.
     *
     * @return
     */
    public String getMId() {
        return mId;
    }

    /**
     * Sets the id document of the member.
     *
     * @param mId
     */
    public void setMId(String mId) {
        this.mId = mId;
    }

    /**
     * Gets the birth date of the member
     *
     * @return
     */
    public String getMBirhtdate() {
        return mBirhtdate;
    }

    /**
     * Sets the birth date of the member
     *
     * @param mBirhtdate
     */
    public void setMBirhtdate(String mBirhtdate) {
        this.mBirhtdate = mBirhtdate;
    }

    /**
     * Gets the phone number of the member.
     *
     * @return
     */
    public String getMPhone() {
        return mPhone;
    }

    /**
     * Sets the phone number of the member
     *
     * @param mPhone
     */
    public void setMPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    /**
     * Gets the email of the member.
     *
     * @return
     */
    public String getMEmailmember() {
        return mEmailmember;
    }

    /**
     * Sets the email of the member.
     *
     * @param mEmailmember
     */
    public void setMEmailmember(String mEmailmember) {
        this.mEmailmember = mEmailmember;
    }

    /**
     * Gets the starting date of the member
     *
     * @return
     */
    public String getMStartingdatemember() {
        return mStartingdatemember;
    }

    /**
     * Sets the starting date of the member.
     *
     * @param mStartingdatemember
     */
    public void setMStartingdatemember(String mStartingdatemember) {
        this.mStartingdatemember = mStartingdatemember;
    }

    /**
     * Gets the cathegory of the member.
     *
     * @return
     */
    public String getMCathegorymember() {
        return mCathegorymember;
    }

    /**
     * Sets the category of the member.
     *
     * @param mCathegorymember
     */
    public void setMCathegorymember(String mCathegorymember) {
        this.mCathegorymember = mCathegorymember;
    }

    /**
     * Gets the list of activity where a member is enrolled.
     *
     * @return
     */
    @XmlTransient
    public Set<Activity> getActivitySet() {
        return activitySet;
    }

    /**
     * Sets the list of activity where a member is enrolled.
     *
     * @param activitySet
     */
    public void setActivitySet(Set<Activity> activitySet) {
        this.activitySet = activitySet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mNum != null ? mNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Member1)) {
            return false;
        }
        Member1 other = (Member1) object;
        if ((this.mNum == null && other.mNum != null) || (this.mNum != null && !this.mNum.equals(other.mNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Member1[ mNum=" + mNum + " ]";
    }

}
