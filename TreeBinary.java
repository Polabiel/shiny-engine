public class TreeBinary<T extends Comparable<T>> implements Comparable<T> {

  private T data;
  private TreeBinary<T> left;
  private TreeBinary<T> right;

  public TreeBinary(T dataX) throws Exception {

    if (dataX == null) {
      throw new Exception("Your data isn't working");
    }

    this.data = dataX;
  }

  public TreeBinary(T dataX, TreeBinary<T> leftX, TreeBinary<T> rightX) throws Exception {

    if (dataX == null) {
      throw new Exception("Your data isn't working");
    }

    if (leftX == null) {
      throw new Exception("Your left value isn't working");
    }

    if (rightX == null) {
      throw new Exception("Your right value isn't working");
    }

    this.data = dataX;
    this.left = leftX;
    this.right = rightX;
  }

  public T getData() {
    return data;
  }

  public TreeBinary<T> getLeft() {
    return left;
  }

  public TreeBinary<T> getRight() {
    return right;
  }

  public void setLeft(TreeBinary<T> left) {
    this.left = left;
  }

  public void setRight(TreeBinary<T> right) {
    this.right = right;
  }

  public String captureAll() {

    StringBuilder allNodes = new StringBuilder();

    TreeBinary<T> current = this;

    while (current != null) {
      if (current.data != null) {
        allNodes.append(current.data.toString());

        current = current.left;
        current = current.right;
      }
    }

    return allNodes.toString();
  }

  @Override
  public int compareTo(T o) {
    if (o == null) {
      return 1;
    }
    if (this.data instanceof Comparable) {
      return (this.data).compareTo(o);
    }
    return this.data.toString().compareTo(o.toString());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    result = prime * result + ((left == null) ? 0 : left.hashCode());
    result = prime * result + ((right == null) ? 0 : right.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TreeBinary other = (TreeBinary) obj;
    if (data == null) {
      if (other.data != null)
        return false;
    } else if (!data.equals(other.data))
      return false;
    if (left == null) {
      if (other.left != null)
        return false;
    } else if (!left.equals(other.left))
      return false;
    if (right == null) {
      if (other.right != null)
        return false;
    } else if (!right.equals(other.right))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "TreeBinary [data=" + data + ", left=" + left + ", right=" + right + "]";
  }

  public void insert(T dataX) throws Exception {

    if (dataX == null) {
      throw new Exception("Your data isn't working");
    }

    if (dataX.compareTo(data) < 0) {
      if (left == null) {
        left = new TreeBinary<T>(dataX);
      } else {
        left.insert(dataX);
      }
    } else if (dataX.compareTo(data) > 0) {
      if (right == null) {
        right = new TreeBinary<T>(dataX);
      } else {
        right.insert(dataX);
      }
    }
  }

  public boolean contains(T dataX) throws Exception {

    if (dataX == null) {
      throw new Exception("Your data isn't working");
    }

    if (dataX.compareTo(data) == 0) {
      return true;
    } else if (dataX.compareTo(data) < 0) {
      if (left == null) {
        return false;
      } else {
        return left.contains(dataX);
      }
    } else {
      if (right == null) {
        return false;
      } else {
        return right.contains(dataX);
      }
    }
  }

  public void remove(T dataX) throws Exception {

    if (dataX == null) {
      throw new Exception("Your data isn't working");
    }

    if (dataX.compareTo(data) == 0) {
      if (left != null && right != null) {
        data = right.minValue();
        right.remove(data);
      } else if (left != null) {
        data = left.data;
        left = left.left;
        right = left.right;
      } else if (right != null) {
        data = right.data;
        left = right.left;
        right = right.right;
      } else {
        data = null;
      }
    } else if (dataX.compareTo(data) < 0) {
      if (left != null) {
        left.remove(dataX);
      }
    } else {
      if (right != null) {
        right.remove(dataX);
      }
    }
  }

  public T minValue() {
    if (left == null) {
      return data;
    } else {
      return left.minValue();
    }
  }

  public T maxValue() {
    if (right == null) {
      return data;
    } else {
      return right.maxValue();
    }
  }

  public int size() {
    int size = 1;

    if (left != null) {
      size += left.size();
    }

    if (right != null) {
      size += right.size();
    }

    return size;
  }

  public int depth() {
    int leftDepth = 0;
    int rightDepth = 0;

    if (left != null) {
      leftDepth = left.depth();
    }

    if (right != null) {
      rightDepth = right.depth();
    }

    return 1 + Math.max(leftDepth, rightDepth);
  }

  public void printInOrder() {
    if (left != null) {
      left.printInOrder();
    }

    System.out.println(data);

    if (right != null) {
      right.printInOrder();
    }
  }

  public void printPreOrder() {
    System.out.println(data);

    if (left != null) {
      left.printPreOrder();
    }

    if (right != null) {
      right.printPreOrder();
    }
  }

  public void printPostOrder() {
    if (left != null) {
      left.printPostOrder();
    }

    if (right != null) {
      right.printPostOrder();
    }

    System.out.println(data);
  }

  public void printLevelOrder() {
    int depth = depth();

    for (int i = 0; i < depth; i++) {
      printGivenLevel(this, i);
    }
  }

  private void printGivenLevel(TreeBinary<T> root, int level) {
    if (root == null) {
      return;
    }

    if (level == 0) {
      System.out.println(root.data);
    } else if (level > 0) {
      printGivenLevel(root.left, level - 1);
      printGivenLevel(root.right, level - 1);
    }
  }

  public static void main(String[] args) throws Exception {
    TreeBinary<Integer> tree = new TreeBinary<Integer>(5);
    tree.insert(3);
    tree.insert(8);
    tree.insert(2);
    tree.insert(4);
    tree.insert(6);
    tree.insert(9);

    System.out.println(tree.contains(3));
    System.out.println(tree.contains(7));

    tree.remove(3);
    tree.remove(9);

    System.out.println(tree.contains(3));
    System.out.println(tree.contains(9));

    System.out.println(tree.minValue());
    System.out.println(tree.maxValue());

    System.out.println(tree.size());
    System.out.println(tree.depth());

    tree.printInOrder();
    tree.printPreOrder();
    tree.printPostOrder();
    tree.printLevelOrder();
  }
}