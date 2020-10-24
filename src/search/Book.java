/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author vishakha
 */
@Entity
@Table(name = "Book", catalog = "library", schema = "")
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByAvailibilty", query = "SELECT b FROM Book b WHERE b.availibilty = :availibilty"),
    @NamedQuery(name = "Book.findByAuthorid", query = "SELECT b FROM Book b WHERE b.authorid = :authorid"),
    @NamedQuery(name = "Book.findByPubid", query = "SELECT b FROM Book b WHERE b.pubid = :pubid"),
    @NamedQuery(name = "Book.findByAccessionno", query = "SELECT b FROM Book b WHERE b.accessionno = :accessionno")})
public class Book implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ISBN")
    private int isbn;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "Availibilty")
    private boolean availibilty;
    @Basic(optional = false)
    @Column(name = "Author_id")
    private int authorid;
    @Basic(optional = false)
    @Column(name = "Pub_id")
    private int pubid;
    @Id
    @Basic(optional = false)
    @Column(name = "Accession_no")
    private Integer accessionno;

    public Book() {
    }

    public Book(Integer accessionno) {
        this.accessionno = accessionno;
    }

    public Book(Integer accessionno, int isbn, String title, boolean availibilty, int authorid, int pubid) {
        this.accessionno = accessionno;
        this.isbn = isbn;
        this.title = title;
        this.availibilty = availibilty;
        this.authorid = authorid;
        this.pubid = pubid;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        int oldIsbn = this.isbn;
        this.isbn = isbn;
        changeSupport.firePropertyChange("isbn", oldIsbn, isbn);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public boolean getAvailibilty() {
        return availibilty;
    }

    public void setAvailibilty(boolean availibilty) {
        boolean oldAvailibilty = this.availibilty;
        this.availibilty = availibilty;
        changeSupport.firePropertyChange("availibilty", oldAvailibilty, availibilty);
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        int oldAuthorid = this.authorid;
        this.authorid = authorid;
        changeSupport.firePropertyChange("authorid", oldAuthorid, authorid);
    }

    public int getPubid() {
        return pubid;
    }

    public void setPubid(int pubid) {
        int oldPubid = this.pubid;
        this.pubid = pubid;
        changeSupport.firePropertyChange("pubid", oldPubid, pubid);
    }

    public Integer getAccessionno() {
        return accessionno;
    }

    public void setAccessionno(Integer accessionno) {
        Integer oldAccessionno = this.accessionno;
        this.accessionno = accessionno;
        changeSupport.firePropertyChange("accessionno", oldAccessionno, accessionno);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessionno != null ? accessionno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.accessionno == null && other.accessionno != null) || (this.accessionno != null && !this.accessionno.equals(other.accessionno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "search.Book[ accessionno=" + accessionno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
