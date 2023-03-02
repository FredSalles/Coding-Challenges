package Practice.BinarySearchTree;

class Solution {

    public TreeNode insert(TreeNode root, int value) {

        if (root == null)
            return new TreeNode(value);
        if (value < root.val)
            root.left = insert(root.left, value);
        if (value > root.val)
            root.right = insert(root.right, value);
        return root;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {

        // Root is empty
        if (root == null)
            return root;

        // Root is to be deleted
        if (root.val > low && root.val < high) {

            // Has one child nodes
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            // Has two children
            // TreeNode left = root.left;
            TreeNode right = root.right;
            //
            // Look for next in succession order
            //
            // SMALLEST VALUE TO THE RIGHT
            // or
            // HIGHEST VALUE TO THE LEFT
            //
            int min = minValue(right);
            root.val = min;  
            root.right = trimBST(root.right, min-1, min+1);
        }

        // recurse on left and right nodes
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    static void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private int minValue(TreeNode root) {
        int value = root.val;
        while (root.left != null) {
            value = root.left.val;
            root = root.left;
        }
        return value;
    }

    public static void main(String[] args) {

        TreeNode node40 = new TreeNode(40);
        TreeNode node60 = new TreeNode(60);
        TreeNode node80 = new TreeNode(80);

        TreeNode node70 = new TreeNode(70, node60, node80);
        TreeNode node30 = new TreeNode(30, null, node40);

        TreeNode r = new TreeNode(50, node30, node70);

        Solution s = new Solution();
        TreeNode res = s.insert(r, 20);
        inOrder(res);
        System.out.println("");
        TreeNode res1 = s.trimBST(r, 35, 55);
        inOrder(res1);
    }
}
