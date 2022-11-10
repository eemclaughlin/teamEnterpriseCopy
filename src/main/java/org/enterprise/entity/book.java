package org.enterprise.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * The type Book.
 */
@Entity(name = "book")
@Table(name = "books")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "isbnTen")
    private String isbnTen;

    @Column(name = "isbnThirteen")
    private String isbnThirteen;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publishedDate")
    private String publishedDate;

    @Column(name = "pageCount")
    private int pageCount;

    @Column(name = "language")
    private String language;

    @Column(name = "smallImageLink")
    private String smallImageLink;

    @Column(name = "medImageLink")
    private String medImageLink;

    /**
     * Instantiates a new Book.
     */
    public book() {}

    /**
     * Instantiates a new Book.
     *
     * @param id             the id
     * @param isbnTen        the isbn ten
     * @param isbnThirteen   the isbn thirteen
     * @param title          the title
     * @param author         the author
     * @param description    the description
     * @param location       the location
     * @param publisher      the publisher
     * @param publishedDate  the published date
     * @param pageCount      the page count
     * @param language       the language
     * @param smallImageLink the small image link
     * @param medImageLink   the med image link
     */
    public book(int id, String isbnTen, String isbnThirteen, String title,
                String author, String description, String location,
                String publisher, String publishedDate, int pageCount,
                String language, String smallImageLink, String medImageLink) {
        this.id = id;
        this.isbnTen = isbnTen;
        this.isbnThirteen = isbnThirteen;
        this.title = title;
        this.author = author;
        this.description = description;
        this.location = location;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.pageCount = pageCount;
        this.language = language;
        this.smallImageLink = smallImageLink;
        this.medImageLink = medImageLink;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets isbn ten.
     *
     * @return the isbn ten
     */
    public String getIsbnTen() {
        return isbnTen;
    }

    /**
     * Sets isbn ten.
     *
     * @param isbnTen the isbn ten
     */
    public void setIsbnTen(String isbnTen) {
        this.isbnTen = isbnTen;
    }

    /**
     * Gets isbn thirteen.
     *
     * @return the isbn thirteen
     */
    public String getIsbnThirteen() {
        return isbnThirteen;
    }

    /**
     * Sets isbn thirteen.
     *
     * @param isbnThirteen the isbn thirteen
     */
    public void setIsbnThirteen(String isbnThirteen) {
        this.isbnThirteen = isbnThirteen;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets publisher.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets publisher.
     *
     * @param publisher the publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets published date.
     *
     * @return the published date
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Sets published date.
     *
     * @param publishedDate the published date
     */
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * Gets page count.
     *
     * @return the page count
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Sets page count.
     *
     * @param pageCount the page count
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets small image link.
     *
     * @return the small image link
     */
    public String getSmallImageLink() {
        return smallImageLink;
    }

    /**
     * Sets small image link.
     *
     * @param smallImageLink the small image link
     */
    public void setSmallImageLink(String smallImageLink) {
        this.smallImageLink = smallImageLink;
    }

    /**
     * Gets med image link.
     *
     * @return the med image link
     */
    public String getMedImageLink() {
        return medImageLink;
    }

    /**
     * Sets med image link.
     *
     * @param medImageLink the med image link
     */
    public void setMedImageLink(String medImageLink) {
        this.medImageLink = medImageLink;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbnTen='" + isbnTen + '\'' +
                ", isbnThirteen='" + isbnThirteen + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", pageCount=" + pageCount +
                ", language='" + language + '\'' +
                ", smallImageLink='" + smallImageLink + '\'' +
                ", medImageLink='" + medImageLink + '\'' +
                '}';
    }
}
