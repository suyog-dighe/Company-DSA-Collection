package Juspay.juspay;

import java.io.*;
import java.util.*;

public class again {
    static class LockingTree {
        static class Node {
            int id;
            int owner = -1;
            BitSet descendants = new BitSet(10000);
            BitSet ancestors = new BitSet(10000);
            boolean isLocked = false;

            Node(int id) {
                this.id = id;
            }
        }

        private final Node[] nodes;
        private final int[] parent;
        private final HashMap<String, Integer> nameToId;
        private final String[] idToName;

        private void dfs(int v, int p) {
            if (p != -1) {
                nodes[v].ancestors = (BitSet) nodes[p].ancestors.clone();
                nodes[v].ancestors.set(p);
            }

            for (int i = 0; i < idToName.length; i++) {
                if (parent[i] == v) {
                    nodes[v].descendants.set(i);
                    dfs(i, v);
                    nodes[v].descendants.or(nodes[i].descendants);
                }
            }
        }

        public LockingTree(String[] names, int b) {
            int n = names.length;
            nodes = new Node[n];
            parent = new int[n];
            nameToId = new HashMap<>();
            idToName = names;

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i);
                nameToId.put(names[i], i);
                parent[i] = i == 0 ? -1 : (i - 1) / b;
            }

            dfs(0, -1);
        }

        public boolean lock(String name, int user) {
            int nodeId = nameToId.get(name);
            Node node = nodes[nodeId];

            if (node.isLocked) return false;

            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].isLocked &&
                        (node.ancestors.get(i) || node.descendants.get(i))) {
                    return false;
                }
            }

            node.isLocked = true;
            node.owner = user;
            return true;
        }

        public boolean unlock(String name, int user) {
            int nodeId = nameToId.get(name);
            Node node = nodes[nodeId];

            if (!node.isLocked || node.owner != user)
                return false;

            node.isLocked = false;
            node.owner = -1;
            return true;
        }

        public boolean upgrade(String name, int user) {
            int nodeId = nameToId.get(name);
            Node node = nodes[nodeId];

            if (node.isLocked) return false;

            boolean hasLockedDescendant = false;
            List<Integer> toUnlock = new ArrayList<>();

            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].isLocked) {
                    if (node.ancestors.get(i)) return false;
                    if (node.descendants.get(i)) {
                        hasLockedDescendant = true;
                        if (nodes[i].owner != user) return false;
                        toUnlock.add(i);
                    }
                }
            }

            if (!hasLockedDescendant) return false;

            for (int i : toUnlock) {
                nodes[i].isLocked = false;
                nodes[i].owner = -1;
            }

            node.isLocked = true;
            node.owner = user;
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] firstLine = br.readLine().trim().split("\\s+");
            if (firstLine.length < 3) {
                throw new IllegalArgumentException("First line must contain three integers: n, b, and q");
            }

            int n = Integer.parseInt(firstLine[0]);
            int b = Integer.parseInt(firstLine[1]);
            int q = Integer.parseInt(firstLine[2]);

            String[] namesLine = br.readLine().trim().split("\\s+");
            if (namesLine.length < n) {
                throw new IllegalArgumentException("Not enough names provided. Expected " + n + " names");
            }

            String[] names = Arrays.copyOf(namesLine, n);
            LockingTree tree = new LockingTree(names, b);

            for (int i = 0; i < q; i++) {
                String line = br.readLine();
                if (line == null) break;

                String[] query = line.trim().split("\\s+");
                if (query.length < 3) {
                    bw.write("Invalid query format. Skipping...\n");
                    continue;
                }

                try {
                    int op = Integer.parseInt(query[0]);
                    String name = query[1];
                    int user = Integer.parseInt(query[2]);

                    if (!tree.nameToId.containsKey(name)) {
                        bw.write("false\n");
                        continue;
                    }

                    boolean result = false;
                    switch (op) {
                        case 1: result = tree.lock(name, user); break;
                        case 2: result = tree.unlock(name, user); break;
                        case 3: result = tree.upgrade(name, user); break;
                    }
                    bw.write(result ? "true\n" : "false\n");

                } catch (NumberFormatException e) {
                    bw.write("Invalid number format in query. Skipping...\n");
                }
            }

            bw.flush();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}