/**
 * 
 */
package recursivetree;

/**
 * @author name Gunnar Nelson
 * @version 2020-25-04
 *
 */
public class Expressions {

    /**
     * This is our main method
     * 
     * @param args
     *            this is the command line Args
     */
    public static void main(String[] args) {
        // 0
        BinaryTree<String> main = new BinaryTree<String>("*");
        // 1
        BinaryTree<String> left1 = new BinaryTree<String>("-");
        BinaryTree<String> right1 = new BinaryTree<String>("/");
        // 2
        BinaryTree<String> left2 = new BinaryTree<String>("a");
        BinaryTree<String> right2 = new BinaryTree<String>("b");

        BinaryTree<String> left42 = new BinaryTree<String>("+");
        BinaryTree<String> right42 = new BinaryTree<String>("e");
        // 3
        BinaryTree<String> left3 = new BinaryTree<String>("c");
        BinaryTree<String> right3 = new BinaryTree<String>("d");

        main.setLeft(left1);
        main.setRight(right1);

        left1.setLeft(left2);
        left1.setRight(right2);

        right1.setLeft(left42);
        right1.setRight(right42);

        left42.setLeft(left3);
        left42.setRight(right3);

        System.out.println(main.toInOrderString());

    }

}