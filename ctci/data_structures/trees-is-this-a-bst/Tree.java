/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    
    /*
     * MIN_VALUE / MAX_VALUE 상수 값을 사용하는 이유는,
     * 아래와 같이 child의 left, right에서 root 보다 크거나 작은 값이 나올 수 있으므로
     *          100
     *    50          200
     * 10    999  ...     ...
     */
    boolean checkBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBST(Node n, int min, int max){
        // 공집합도 이진 트리니까
        if (n == null) {
            return true;
        }
        if (n.data <= min || n.data >= max) {
            return false;
        }
        
        return isBST(n.left, min, n.data) && isBST(n.right, n.data, max);
    }

