class AddNode {
    fun addNode(node: Node?, value: Int): Node {

        if (node == null) {
            return Node(value)
        } else if (value < node.data) {
            node.left = this.addNode(node.left, value)

        } else if (value > node.data) {
            node.right = this.addNode(node.right, value)
        }
        return node
    }

    //Display Node
    fun preOrderTraversal(node:Node?){
        if(node !=null){
            print("${node.data} ")
            preOrderTraversal(node.left)
            preOrderTraversal(node.right)
        }
    }

    //Display Node
    fun inOrderTraversal(node:Node?){
        if(node !=null){
            inOrderTraversal(node.left)
            print("${node.data} ")
            inOrderTraversal(node.right)
        }
    }

    //Display Node
    fun postOrderTraversal(node:Node?){
        if(node !=null){
            postOrderTraversal(node.left)
            postOrderTraversal(node.right)
            print("${node.data} ")
        }
    }

    fun delete(root: Node?, value: Int): Node? {
        if (root == null) {
            return null
        }

        if (value < root.data) {
            root.left = delete(root.left, value)
        } else if (value > root.data) {
            root.right = delete(root.right, value)
        } else {
            // case 1: no children
            if (root.left == null && root.right == null) {
                return null
            }
            // case 2: one child
            else if (root.left == null) {
                return root.right
            } else if (root.right == null) {
                return root.left
            }
            // case 3: two children
            else {
                val minValue = findMin(root.right!!)
                root.data = minValue.data
                root.right = delete(root.right, minValue.data)
            }
        }

        return root
    }

    fun findMin(root: Node): Node {
        var current = root
        while (current.left != null) {
            current = current.left!!
        }
        return current
    }

}

fun main() {
    AddNode().apply {
        val node = Node(10)
        this.addNode(node, 7)
        this.addNode(node, 6)
        this.addNode(node, 4)
        this.addNode(node, 3)
        this.addNode(node, 12)
        this.addNode(node, 11)
        this.addNode(node, 14)
        this.addNode(node, 13)
        this.addNode(node, 15)
        preOrderTraversal(node)
        print("\n")
        inOrderTraversal(node)
        print("\n")

        delete(node,12)

        postOrderTraversal(node)

    }
}

/*
                  10
              /       \
             7         12
            / \       /  \
           6   null  11  14
          /  f          /  \
        4              13   15
       /
      3
*/


