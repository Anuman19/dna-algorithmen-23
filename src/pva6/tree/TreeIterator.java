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
   * Erzeugt einen neuen neuen Baum-Knoten-Iterator
   *
   * @param node Die Wurzel des zu traversierenden Baumes.
   */

  private Stack<TreeNode<N>> nodes = new Stack<>();

  public TreeIterator(TreeNode<N> node) {
    // TODO

    nodes.push(node);
  }

  @Override
  public boolean hasNext() {
    //TODO

    return !nodes.empty();
  }

  @Override
  public N next() {
    // TODO

    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    TreeNode<N> current = nodes.pop();

    if (current != null) {
      // store all children of current node from right to left
      for (int i = current.children().size() - 1; i >= 0; i--) {
        nodes.add(current.children().get(i));
      }
      return current.value();
    } else {
      return null;
    }

  }

  // remove() muss nicht implementiert werden.
}
