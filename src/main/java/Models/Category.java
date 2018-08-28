package Models;

import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;
import Exceptions.SubcategoryPresentException;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Category implements Serializable {


    private Set<Auction> auction;
    private Set<Category> subcategories;
    private String name;

    public Category(String name) {
        this.name = name;
        this.subcategories = new HashSet<Category>();
        this.auction = new HashSet<>();
    }


    public void addAuction(Auction auction) throws SubcategoryPresentException {
        if (isSubcategoryPresent()) {
            throw new SubcategoryPresentException();
        } else {
            this.auction.add(auction);
        }
    }

    public void removingAuction(Auction auction) {
        this.auction.remove(auction);
    }


    public void addSubcategory(Category category) throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
        if (!isSubcategoryPresent() && !this.subcategories.isEmpty()) {
            throw new AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException();
        }else{

            this.subcategories.add(category);
        }
    }


    public String getName() {
        return name;
    }


    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(this.name);

        for (Category subcategories : this.subcategories) {
            subcategories.print(level + 1);
        }
    }


    public boolean isSubcategoryPresent() {

        for (Category subcategories : this.subcategories) {
            if (subcategories != null) {
                return true;
            }
        }
        return false;
    }

    public Set<Auction> getAuction() {
        return auction;
    }

    public void getNameOfAuction(){
        System.out.println("SIEMANO");
    }

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(auction, category.auction) &&
                Objects.equals(subcategories, category.subcategories) &&
                Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
