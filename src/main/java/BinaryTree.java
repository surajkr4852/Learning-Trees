import java.util.*;

public class BinaryTree {
  public BinaryTree() {

  }

  private Node root;

  private class Node {
    private int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  // insert elements
  public void populate(Scanner scanner) {
    System.out.println("Enter the root Node: ");
    int value = scanner.nextInt();
    root = new Node(value);
    populate(scanner, root);
  }

  private void populate(Scanner scanner, Node node) {
    System.out.println("Do you want to enter left of " + node.value);
    boolean left = scanner.nextBoolean();
    if (left) {
      System.out.println("Enter the value of the left of " + node.value);
      int value = scanner.nextInt();
      node.left = new Node(value);
      populate(scanner, node.left);
    }
    System.out.println("Do you want to enter right of " + node.value);
    boolean right = scanner.nextBoolean();
    if (right) {
      System.out.println("Enter the value of the right of " + node.value);
      int value = scanner.nextInt();
      node.right = new Node(value);
      populate(scanner, node.right);
    }
  }

  // Display elements
  public void display() {
    display(root, "");
  }

  private void display(Node node, String indent) {
    if (node == null) {
      return;
    }
    System.out.println(indent + node.value);
    display(node.left, indent + "\t");
    display(node.right, indent + "\t");
  }

  public void preetyDisplay() {
    preetyDisplay(root, 0);
  }

  private void preetyDisplay(Node node, int level) {
    if (node == null) {
      return;
    }
    preetyDisplay(node.right, level + 1);
    if (level != 0) {
      for (int i = 0; i < level - 1; i++) {
        System.out.print("\t\t");
      }
      System.out.println("|------>" + node.value);
    } else {
      System.out.println(node.value);
    }
    preetyDisplay(node.left, level + 1);
  }

}