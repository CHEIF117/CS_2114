package icecream;

import java.util.Stack;

/**
 * 
 * @author name Gunnar Nelson
 * @version 2020-02-19
 */

public class IceCreamCone implements IceCreamConeADT {
    private Stack<String> flavor;
    private int numberofScoops;

    /**
     * 
     * Creating a new instance of icecream and flavors
     *
     */
    public IceCreamCone() {
        flavor = new Stack<String>();
        numberofScoops = 0;
    }


    /**
     * 
     * @see icecream.IceCreamConeADT
     *      #eatScoop()
     *
     */
    @Override
    public String eatScoop() {
        numberofScoops--;
        return flavor.pop();
    }


    /**
     * 
     * @see icecream.IceCreamConeADT
     *      #addScoop()
     *
     */
    @Override
    public void addScoop(String newFlavor) {
        flavor.push(newFlavor);
        numberofScoops++;
    }


    /**
     * 
     * @see icecream.IceCreamConeADT
     *      #eatScoop()
     *
     */
    @Override
    public int numScoops() {
        return numberofScoops;
    }


    /**
     * 
     * @see icecream.IceCreamConeADT
     *      #flavor search
     *
     */
    @Override
    public boolean contains(String newFlavor) {
        return flavor.search(newFlavor) > -1;
    }


    /**
     * 
     * @see icecream.IceCreamConeADT
     *      #emptyCone()
     *
     */
    @Override
    public boolean emptyCone() {
        return numberofScoops == 0;
    }


    /**
     * 
     * @see icecream.IceCreamConeADT
     *      #flavorpeak()
     *
     */
    @Override
    public String currentScoop() {
        return flavor.peek();
    }


    /**
     * 
     * @see icecream.IceCreamConeADT
     *      #currentScoop()
     *
     */
    @Override
    public String toString() {
        return flavor.toString();
    }


    /**
     * 
     * @see icecream.IceCreamConeADT
     *      #equals
     *
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other == null) || (other.getClass() != IceCreamCone.class)) {
            return false;
        }
        return flavor.equals(((IceCreamCone) other).flavor);
    } 

}
