package pva6.tree;

import java.util.List;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche.
 * Am einfachsten kann die Tiefensuche rekursiv programmiert werden.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserRec<N> 
{
	/**
	 * Traversiert einen Baum mit DepthFirst Strategie.
	 * @param node Die Wurzel des zu traversierenden Baumes.
	 */
	public void traverse(TreeNode<N> node) 
	{
		// TODO

		// break recursion
		if (node == null) return;

		// recur on left subtree
		preOperation(node.value());
		if (node.children() != null){
			List<TreeNode<N>> children = node.children();
			for (int i = 0; i < children.size(); i++){
				traverse(children.get(i));
			}
		}

		// recur right subtree
		postOperation(node.value());
	}
	
	/**
	 * Operation auf einem Knoten, bevor die Nachkommen besucht wurden.
	 * @param value
	 */
	abstract protected void preOperation(N value);   
    
	/**
	 * Operation auf einem Knoten, nachdem die Nachkommen besucht wurden.
	 * @param value
	 */
	abstract protected void postOperation(N value);  

}   