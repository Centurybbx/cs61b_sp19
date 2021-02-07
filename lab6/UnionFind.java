public class UnionFind {

    // TODO - Add instance variables?
    private int[] array;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        // TODO
        array = new int[n];
        int i = 0;
        // assign -1 to every element in the array (to represent its size)
        while (i < n) {
            array[i] = -1;
            i += 1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        // TODO
        if (vertex < 0 || vertex > array.length) {
            throw new IllegalArgumentException("an illegal argument, required argument 0 to array.length");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        // TODO
        int realSize = _getRealSize(array[find(v1)]);
        return realSize;
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        // TODO
        if (array[v1] < 0)
            return v1;
        return parent(array[v1]);
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        // TODO
        try {
            validate(v1);
            validate(v2);
            int sizeOfV1 = sizeOf(v1), sizeOfV2 = sizeOf(v2);
            int indexOfV1 = find(v1), indexOfV2 = find(v2);
            // compare size of the two, then assign.
            if (sizeOfV1 > sizeOfV2) {
                array[indexOfV2] = indexOfV1;
                array[indexOfV1] -= sizeOfV2;
            } else {
                array[indexOfV1] = indexOfV2;
                array[indexOfV2] -= sizeOfV1;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("catch an exception!");
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO
        while (array[vertex] >= 0) {
            vertex = array[vertex];
        }
        // return the index of root
        return vertex;
    }

    private int _getRealSize(int value) {
        return -value;
    }

}
