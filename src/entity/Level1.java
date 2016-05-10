package entity;

import java.util.Set;

/**
 * Created by Michael on 3/21/2016.
 */
public class Level1 {

    int levelOneID;
    String listingName;
    String listingDescription;
    int versionID;
    String bookName;
    int pageNumber;
    private Set<Level2> levelTwo;

    public Level1() {
        levelOneID = 0;
        listingName = null;
        listingDescription = null;
        versionID = 0;
        bookName = null;
        pageNumber = 0;
        levelTwo = null;
    }

    public int getLevelOneID() {
        return levelOneID;
    }

    public void setLevelOneID(int levelOneID) {
        this.levelOneID = levelOneID;
    }

    public String getListingName() {
        return listingName;
    }

    public void setListingName(String listingName) {
        this.listingName = listingName;
    }

    public String getListingDescription() {
        return listingDescription;
    }

    public void setListingDescription(String listingDescription) {
        this.listingDescription = listingDescription;
    }

    public int getVersionID() {
        return versionID;
    }

    public void setVersionID(int versionID) {
        this.versionID = versionID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Set<Level2> getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(Set<Level2> inLevelTwo) {
        this.levelTwo = inLevelTwo;
    }

    public void addLevelTwo(Level2 inLevelTwo) {
        this.levelTwo.add(inLevelTwo);
    }
}
