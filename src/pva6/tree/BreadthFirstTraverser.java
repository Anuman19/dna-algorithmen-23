package pva6.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Traverser-Klasse für Breitensuche. Ein Traverser mit Breitensuche besucht zuerst die Wurzel, dann
 * die Kinder der Wurzel, dann die Enkel usw.
 *
 * @param <N>
 */
public abstract class BreadthFirstTraverser<N> {

  /**
   * Methode zum Traversieren eines Baumes.
   *
   * @param node Wurzelknoten des Baumes.
   */
  public void traverse(TreeNode<N> node) {
    //TODO

    // break
    if (node == null) {
      return;
    }

    // create queue
    Queue<TreeNode<N>> queue = new LinkedList<>();

    // add root to queue
    queue.add(node);

    // loop until queue is empty
    while (!queue.isEmpty()) {

      // retrieve and remove head of queue
      TreeNode<N> current = queue.poll();

      // check if already visited
      if (current != null) {
        visitNode(current.value());

        // add all children to queue
        queue.addAll(current.children());
      }
    }

  }

  /**
   * Diese Methode gibt an, was beim travsersieren gemacht werden sollte.
   *
   * @param value
   */
  protected abstract void visitNode(N value);

}   