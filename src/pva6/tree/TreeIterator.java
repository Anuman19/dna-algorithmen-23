package pva6.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Ein Iterator, der in Depth-First Reihenfolge alle Werte der Knoten eines Baumes ausgibt.
 *
 * @param <N> Typ des Knotenwertes.
 */
public class TreeIterator<N> implements Iterator<N> {

  /**
   * Erzeugt einen neuen Baum-Knoten-Iterator
   *
   * @param node Die Wurzel des zu traversierenden Baumes.
   */

  // initialize stack
  private final Stack<TreeNode<N>> nodes = new Stack<>();

  public TreeIterator(TreeNode<N> node) {
    // TODO

    // push root node on stack in constructor
    nodes.push(node);
  }

  @Override
  public boolean hasNext() {
    //TODO

    // check if stack is empty and return
    return !nodes.empty();
  }

  @Override
  public N next() {
    // TODO

    // check if empty --> error handling
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    // get current node
    TreeNode<N> current = nodes.pop();

    // stop when current is null
    if (current != null) {
      // store all children of current node from right to left
      for (int i = current.children().size() - 1; i >= 0; i--) {
        nodes.add(current.children().get(i));
      }

      // return node value
      return current.value();
    } else {
      return null;
    }

  }

  // remove() muss nicht implementiert werden.
}
