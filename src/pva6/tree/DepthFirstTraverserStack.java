package pva6.tree;

import java.util.Stack;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche. Diese Implementierung verwende keine
 * Rekursion, sondern einen Stack.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserStack<N> {

  /**
   * Traversiert einen Baum mit Tiefensuche.
   *
   * @param root Die Wurzel des zu traversierenden Baumes.
   */
  public void traverse(TreeNode<N> root) {
    //TODO

    // stack for nodes
    Stack<TreeNode<N>> nodes = new Stack<>();

    // push root node on stack
    nodes.push(root);

    // loop until stack is empty

    while (!nodes.empty()) {

      // pop current node from stack and store
      TreeNode<N> current = nodes.pop();

      // check if current node has been traversed
      if (current != null) {
        visitNode(current.value());

        // store all children of current node from right to left
        for (int i = current.children().size() - 1; i >= 0; i--) {
          nodes.add(current.children().get(i));
        }
      }
    }

  }

  /**
   * Operation auf einem Knoten bei der Traversierung; die Operation wird durchgeführt, bevor die
   * Nachkommen besucht werden.
   *
   * @param value
   */
  protected abstract void visitNode(N value);

}   