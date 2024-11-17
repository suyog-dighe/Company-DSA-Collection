package Juspay.juspay;

import java.util.*;

class Node {
    String nodeName;                   // Name of the node
    int lockedByID;                    // ID of the user who locked the node
    boolean isLocked;                  // Lock status of the node
    List<Node> children;               // Children of the current node
    Node parent;                       // Parent of the current node
    Set<Node> lockedDescendants;       // Set of locked descendant nodes

    // Constructor to initialize a node with a name and a parent
    public Node(String name, Node parentNode) {
        this.nodeName = name;
        this.lockedByID = -1;          // Initially unlocked
        this.parent = parentNode;
        this.isLocked = false;         // Node starts unlocked
        this.children = new ArrayList<>();
        this.lockedDescendants = new HashSet<>();
    }

    // Function to add children to the current node
    public void addChildren(List<String> childNames) {
        for (String name : childNames) {
            this.children.add(new Node(name, this));
        }
    }
}

class MTree {
    private Node rootNode;                                  // Root of the tree
    private Map<String, Node> nodeMapping;                  // Map for node names to node pointers

    // Constructor to initialize the M-ary tree with a root node
    public MTree(String rootName) {
        this.rootNode = new Node(rootName, null);
        this.nodeMapping = new HashMap<>();
    }

    // Method to build the tree from a list of names
    public void buildTree(List<String> names, int branchFactor) {
        Deque<Node> nodeDeque = new ArrayDeque<>();         // Using deque for level-order traversal
        int index = 1, totalNodes = names.size();
        nodeDeque.add(this.rootNode);                       // Start with the root node

        while (!nodeDeque.isEmpty()) {
            Node currentNode = nodeDeque.poll();
            this.nodeMapping.put(currentNode.nodeName, currentNode);

            List<String> childNames = new ArrayList<>();
            for (int i = index; i < Math.min(totalNodes, index + branchFactor); i++) {
                childNames.add(names.get(i));
            }
            currentNode.addChildren(childNames);

            for (Node child : currentNode.children) {
                nodeDeque.add(child);                       // Add all children to the deque
            }
            index += branchFactor;
        }
    }

    // Method to print the tree (for debugging purposes)
    public void display(Node currentNode) {
        if (currentNode == null) return;

        System.out.println("Node -> " + currentNode.nodeName + " " + currentNode.lockedByID);
        System.out.println("Children -> ");
        for (Node child : currentNode.children) {
            System.out.println("       " + child.nodeName);
        }
        System.out.println("Locked Descendants -> ");
        for (Node descendant : currentNode.lockedDescendants) {
            System.out.println("       " + descendant.nodeName);
        }
        for (Node child : currentNode.children) {
            display(child);
        }
    }

    // Method to update locked descendants for ancestors
    public void updateAncestors(Node ancestor, Node lockedNode) {
        while (ancestor != null) {
            ancestor.lockedDescendants.add(lockedNode);
            ancestor = ancestor.parent;
        }
    }

    // Method to lock a node
    public boolean lockNode(String name, int userID) {
        Node targetNode = this.nodeMapping.get(name);
        if (targetNode.isLocked || !targetNode.lockedDescendants.isEmpty()) return false; // Check locking conditions

        Node ancestor = targetNode.parent;
        while (ancestor != null) {
            if (ancestor.isLocked) return false; // Check if any ancestor is locked
            ancestor = ancestor.parent;
        }

        updateAncestors(targetNode.parent, targetNode); // Update locked descendants for ancestors
        targetNode.isLocked = true;                    // Lock the node
        targetNode.lockedByID = userID;
        return true;
    }

    // Method to unlock a node
    public boolean unlockNode(String name, int userID) {
        Node targetNode = this.nodeMapping.get(name);
        if (!targetNode.isLocked || targetNode.lockedByID != userID) return false; // Check unlocking conditions

        Node ancestor = targetNode.parent;
        while (ancestor != null) {
            ancestor.lockedDescendants.remove(targetNode); // Update ancestors about the unlocking
            ancestor = ancestor.parent;
        }

        targetNode.isLocked = false;                    // Unlock the node
        targetNode.lockedByID = -1;
        return true;
    }

    // Method to upgrade the lock of a node
    public boolean upgradeNodeLock(String name, int userID) {
        Node targetNode = this.nodeMapping.get(name);
        if (targetNode.isLocked || targetNode.lockedDescendants.isEmpty()) return false; // Check upgrade conditions

        for (Node descendant : targetNode.lockedDescendants) {
            if (descendant.lockedByID != userID) return false; // Check if all descendants are locked by the same ID
        }

        Node ancestor = targetNode.parent;
        while (ancestor != null) {
            if (ancestor.isLocked) return false; // Check if any ancestor is locked
            ancestor = ancestor.parent;
        }

        Set<Node> descendantsToUnlock = new HashSet<>(targetNode.lockedDescendants); // Store locked descendants
        for (Node descendant : descendantsToUnlock) {
            unlockNode(descendant.nodeName, userID); // Unlock all descendants
        }

        lockNode(name, userID); // Lock the current node
        return true;
    }

    /**
     * @throws Throwable
     */
    // Destructor to clean up dynamically allocated root node
    @Override
    public void finalize() throws Throwable {
        super.finalize();
        deleteNode(rootNode);
    }

    private void deleteNode(Node node) {
        if (node == null) return;
        for (Node child : node.children) {
            deleteNode(child); // Recursively delete children
        }
    }
}

public class Juspay {
    public static void main(String[] args) {

        long startTime = System.nanoTime(); // Start time measurement
        Scanner sc = new Scanner(System.in);

        int nodeCount = sc.nextInt();
        int branchFactor = sc.nextInt();
        int operations = sc.nextInt();

        List<String> nodeNames = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            nodeNames.add(sc.next());
        }

        MTree tree = new MTree(nodeNames.get(0));
        tree.buildTree(nodeNames, branchFactor);

        for (int i = 0; i < operations; i++) {
            int operationType = sc.nextInt();
            String nodeName = sc.next();
            int userID = sc.nextInt();

            if (operationType == 1) {
                System.out.println(tree.lockNode(nodeName, userID) ? "true" : "false");
            } else if (operationType == 2) {
                System.out.println(tree.unlockNode(nodeName, userID) ? "true" : "false");
            } else if (operationType == 3) {
                System.out.println(tree.upgradeNodeLock(nodeName, userID) ? "true" : "false");
            }
        }
        sc.close();

        long endTime = System.nanoTime(); // End time measurement
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0; // Convert to seconds
        System.out.printf("Execution Time: %.6f seconds%n", durationInSeconds); // Print execution time
    }
}
