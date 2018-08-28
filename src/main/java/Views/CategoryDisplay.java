package Views;

import Exceptions.AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException;
import Models.CategoriesDatabase;

public class CategoryDisplay {




    public static void printCategoryTree() throws AddingSubcategoryToCategoryThatAlreadyHaveAnAuctionException {
        CategoriesDatabase.getInstance().getRootCategory().print(0);

    }

    public static void askAboutCategory() {
        System.out.println("Podaj kategorie ogólną lub szczegółową, aby zobaczyć aukcje");
    }
}
