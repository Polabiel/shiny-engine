public class Node<X> {

  private X data;
  private Node<X> next;

  public Node(X dataX) throws Exception {

    if (dataX == null) {
      throw new Exception("Your data isn't working");
    }

    this.data = dataX;
  }

  public Node(X dataX, Node<X> nextX) throws Exception {

    if (dataX == null) {
      throw new Exception("Your data isn't working");
    }

    if (nextX == null) {
      throw new Exception("Your next value isn't working");
    }

    this.data = dataX;
    this.next = nextX;
  }

  public X getData() {
    return data;
  }

  public Node<X> getNext() {
    return next;
  }

  public void setNext(Node<X> next) {
    this.next = next;
  }

  public String captureAll() {

    StringBuilder allNodes = new StringBuilder();

    Node<X> current = this;

    while (current != null) {
      if (current.data != null) {
        allNodes.append(current.data.toString());

        current = current.next;
      }
    }

    return allNodes.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    result = prime * result + ((next == null) ? 0 : next.hashCode());
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
    Node other = (Node) obj;
    if (data == null) {
      if (other.data != null)
        return false;
    } else if (!data.equals(other.data))
      return false;
    if (next == null) {
      if (other.next != null)
        return false;
    } else if (!next.equals(other.next))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Node [data=" + data + ", next=" + next + "]";
  }

}
