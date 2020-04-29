package groceries;

// -------------------------------------------------------------------------
/**
 * The Grocery Bag class is a bag data structure that holds String objects
 * that represent grocery store items.
 *
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.04.25
 * @author Grace Fields
 * @version 2016.02.01
 */
public class GroceryBag extends ArrayBasedBag {

    // Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public GroceryBag() {
        super(10);
    }


    // Public methods ........................................................
    /**
     * If an element is in both bags, then it will be in the
     * intersection. If there are multiple occurrences of that
     * element, then the number of occurrences of that element
     * in the intersection will equal the minimum number of occurrences
     * in either set.
     * 
     * Examples:
     * intersection of
     * ({"apple","apple","cereal","chips"},
     * {"chips", "apple","apple","chips","cake"})
     * = {"apple","apple","chips"}
     * 
     * @param bag
     *            Bag to be intersected with.
     * @return The intersection of the two bags.
     */
    public GroceryBag intersection(GroceryBag bag) {
        // Implement this method
        GroceryBag bagitem = new GroceryBag();
        String[] item1 = this.contents();
        String[] item2 = bag.contents();
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < bag.size(); j++) {
                if (item2[j] != null) {
                    if (item1[i].equals(item2[j])) {
                        bagitem.add(item2[j]);
                        item2[j] = null;
                        break;
                    }
                }
            }
        }

        return bagitem;
    }


    /**
     * For two bags to be equal they need to contain items
     * with the exact same value (but not the same item, so
     * equality not identity). Order does not matter, but
     * number of occurrences does.
     * 
     * @param givenBag
     *            Other GroceryBag to be compared with for equality.
     * @return Returns true if the two bags have the same items.
     */
    @Override
    public boolean equals(Object givenBag) {
        if (null == givenBag) {
            return false;
        }

        if (givenBag == this) {
            return true;
        }

        if (givenBag.getClass() != this.getClass()) {
            return false;
        }
        else {
            GroceryBag obj = (GroceryBag)givenBag;
            if (size() != obj.size()) {
                return false;
            }
            for (int i = 0; i < size(); i++) {
                if (this.occurrence(this.contents()[i]) != obj.occurrence(this
                    .contents()[i])) {
                    return false;
                }

            }
            return true;

        }

        // Implement this method

    }
}
