import java.util.ArrayList;
import java.util.List;

/*
 * 二叉查找树
 * */
public class BinarySearchTree{
	
	//根结点
	private TreeNode root = null;
	
	//遍历结点列表
	private List<TreeNode> nodelist = new ArrayList<TreeNode>();
	
	private class TreeNode{
		private int key;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;
		
		public TreeNode(int key,TreeNode leftChild,TreeNode rightChild,TreeNode parent){
			this.key = key;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.parent = parent;
		}
		
		public int getKey(){
			return key;
		}
		
		public String toString(){
			String leftkey = leftChild == null ? "" : String.valueOf(leftChild.key);
			String rightkey = rightChild == null ? "" : String.valueOf(rightChild.key);
			return "(" + leftkey + "," + key + "," + rightkey + ")";//返回关键点及其左结点、右结点
		}
	}
	
	/*
	 * 判断二叉树是否为空：空返回true
	 * */
	public boolean isEmpty(){
		if (root == null) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * TreeEmpty 树为空，抛出异常
	 * */
	public void TreeEmpty() throws Exception{
		if (isEmpty()) {
			throw new Exception("树为空！");
		}
	}
	
	/*
	 * 二叉树中查找给定关键字
	 * @param key 给定关键字
	 * @return 给定关键字的树结点
	 * */
	public TreeNode search(int key){
		TreeNode pNode = root;
		//当根结点的值不为空或不为查找的关键字时
		while(pNode != null && pNode.key != key){
			if (key > pNode.key) {
				pNode = pNode.rightChild;
			}else {
				pNode = pNode.leftChild;
			}
		}
		return pNode;
	}
	
	/*
	 * insert 关键字插入到二叉树中
	 * */
	public void insert(int key){
		TreeNode parentNode = null;
		TreeNode newNode = new TreeNode(key, null, null, null);
		TreeNode pNode = root;
		
		//空树的话将插入点作为根结点
		if (root == null) {
			root = newNode;
			return;
		}
		
		//当根结点不为空时，确定插入元素的位置
		while(pNode != null){
			parentNode = pNode;//根结点作为父结点
			if (key < pNode.key) {
				pNode = pNode.leftChild;
			}else if (key > pNode.key) {
				pNode = pNode.rightChild;
			}else {
				return;//树中已存在匹配给定关键字的结点，则什么都不做直接返回  
			}
		}
		
		//确定插入元素，设置插入元素的父结点
		if (key < parentNode.key) {
			parentNode.leftChild = newNode;
			newNode.parent = parentNode;
		}else {
			parentNode.rightChild = newNode;
			newNode.parent = parentNode;
		}
	}
	
	/*
	 * minElemNode 最小关键字结点
	 * @return 二叉查找树的最小关键字结点
	 * */
	public TreeNode minElemNode(TreeNode node) throws Exception{
		if (node == null) {
			throw new Exception("树为空！");
		}
		TreeNode pNode = node;
		while(pNode.leftChild != null){ // 找左子树的最小结点
			pNode = pNode.leftChild;
		}
		return pNode;
	} 
	
	/*
	 * maxElemNode 最大关键字结点
	 * @return 二叉查找树的最大关键字结点
	 * */
	public TreeNode maxElemNode(TreeNode node) throws Exception{
		if (node == null) {
			throw new Exception("树为空");
		}
		TreeNode pNode = node;
		while(pNode.rightChild != null){
			pNode = pNode.rightChild;
		}
		return pNode;
	}
	
	/*
	 * successor 获取给定结点在中序遍历下的后继结点
	 * @param 给定树中的结点
	 * @param 若该结点存在中序遍历顺序下的后继结点，则返回其后继结点；否则返回 null
	 * @throws Expection
	 * */
	public TreeNode successor(TreeNode node) throws Exception{
		if (node == null) {
			return null;
		}
		
		//若结点的右子树不为空，则其后继结点为右子树的最小关键字结点
		if (node.rightChild != null) {
			return minElemNode(node.rightChild);
		}
		
		//若结点右子树为空
		TreeNode parentNode = node.parent;
		while(parentNode != null && node == parentNode.rightChild){
			node = parentNode;
			parentNode = parentNode.parent;
		}
		return parentNode;
	}
	
	/*
	 * successor 获取给定结点在中序遍历下的前趋结点
	 * @param 给定树中的结点
	 * @param 若该结点存在中序遍历顺序下的前趋结点，则返回其前趋结点；否则返回 null
	 * @throws Expection
	 * */
	public TreeNode precessor(TreeNode node) throws Exception{
		if (node == null) {
			return null;
		}
		
		//若结点的左子树不为空，则其前趋结点为左子树的最大关键字结点
		if (node.leftChild != null) {
			return maxElemNode(node.leftChild);
		}
		
		//若结点左子树为空
		TreeNode parentNode = node.parent;
		while(parentNode != null && node == parentNode.leftChild ) {
			node = parentNode;
			parentNode = parentNode.parent;
		}
		return parentNode;
	}
	
	/*
	 * delete 删除匹配给定关键字相应的树结点
	 * @param key 给定关键字
	 *        pNode 关键字对应的树结点
	 * */
	public void delete(int key) throws Exception{
		TreeNode pNode = search(key);//由关键字找到该字在二叉树中的树结点
		if (pNode == null) {
			throw new Exception("树中不存在要删除的关键字");
		}else {
			System.out.println("要删除的关键字为：" + key + "，对应的二叉子树结点为：" + pNode);
		}
		delete(pNode);//调用delete()删除树结点
	}
	
	/*
	 * delete 从二叉树中删除给定的结点
	 * @param pNode 要删除的结点
	 * 前置条件：给定结点在二叉树中已经存在
	 * @throws Exception
	 * */
	public void delete(TreeNode pNode) throws Exception {
		if (pNode == null) {
			return;//从当前方法中退出，返回到方法调用出继续执行。
		}
		
		//该结点即无左结点，也无右结点
		if (pNode.leftChild == null && pNode.rightChild == null) {
			TreeNode parentNode = pNode.parent;//设置该结点的父结点
			if (pNode == parentNode.leftChild) {
				parentNode.leftChild = null;
			}else {
				parentNode.rightChild = null;
			}
			return;//从当前方法中退出，返回到方法调用出继续执行。
		}
		
		//该结点左子树结点为空，右子树结点非空
		if(pNode.leftChild == null && pNode.rightChild != null){
			TreeNode parentNode = pNode.parent;//设置该结点的父结点
			if (pNode == parentNode.leftChild) {//如果该结点是父结点的左孩子
				parentNode.leftChild = pNode.rightChild;
				pNode.rightChild.parent = parentNode;
			}else {//如果该结点是父结点的右孩子
				parentNode.rightChild = pNode.rightChild;//将该点的右子树设置为父结点的右子树
				pNode.rightChild.parent = parentNode;//将父结点设置为该结点右子树的父结点
			}
			return;//从当前方法中退出，返回到方法调用出继续执行。
		}
		
		//该结点左子树结点非空，右子树结点为空
		if (pNode.rightChild == null && pNode.leftChild != null) {
			TreeNode parentNode = pNode.parent;
			if (pNode == parentNode.leftChild) {
				parentNode.leftChild = pNode.leftChild;
				pNode.leftChild.parent = parentNode;
			}else {
				parentNode.rightChild = pNode.leftChild;
				pNode.leftChild.parent = parentNode;
			}
			return;//从当前方法中退出，返回到方法调用出继续执行。
		}
		
		//该结点左、右子树结点均非空
		TreeNode successorNode = successor(pNode);
		delete(successorNode);  //删除该结点的后继结点
		pNode.key = successorNode.key;  //用后继结点取代该结点 
	}
 
	/*
	 * inorderTraverseList 获得二叉查找树的中序遍历结点列表
	 * @return 二叉查找树的中序遍历结点列表 
	 * */	
	public List<TreeNode> inorderTraverseList(){
		if (nodelist != null) {
			nodelist.clear();
		}
		inorderTraverse(root);
		return nodelist;
	}
	
	/*
	 * inorderTraverse 对二叉查找树中序遍历      左结点-根-右结点
	 * @param root 给定二叉树的根结点 
	 * */
	public void inorderTraverse(TreeNode root){
		if (root != null) {
			inorderTraverse(root.leftChild);
			nodelist.add(root);
			inorderTraverse(root.rightChild);
		}
	}
	
	/*
	 * toStringOfOrderList 获取二叉查找树中关键字的有序列表 
	 * @return 二叉查找树中关键字的有序列表  
	 * */
	public String toStringOfOrderList() {
		StringBuilder sBuilder = new StringBuilder(" [ ");
		for(TreeNode p : inorderTraverseList()){
			sBuilder.append(p.key);
			sBuilder.append(" ");
		}
		sBuilder.append("]");
		return sBuilder.toString();
	}
	
	/*
	 * toString 获取该二叉查找树的字符串表示
	 * @return 
	 * */
	public String toString(){
		StringBuilder sBuilder = new StringBuilder();
		for(TreeNode p : inorderTraverseList()){
			sBuilder.append(p);
			sBuilder.append(" ");
		}
		sBuilder.append("]");
		return sBuilder.toString();
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	//测试前趋结点与后继结点
	public static void testNode(BinarySearchTree bst,TreeNode pNode) throws Exception {
		System.out.println("本结点：" + pNode);
		System.out.println("前趋结点： " + bst.precessor(pNode));
		System.out.println("后继结点：" + bst.successor(pNode));
	}
	
	//测试二叉树遍历
	public static void testTraverse(BinarySearchTree bst){
		System.out.println("二叉树遍历：" + bst);
		System.out.println("二叉查找树转换为有序列表：" + bst.toStringOfOrderList());
	}
	
	//测试插入
	public static void testinsert(BinarySearchTree bst,int key) throws Exception{
		bst.insert(key);
		System.out.println("要插入的点为：" + key);
		System.out.println("插入后的有序列表结果：" + bst.toStringOfOrderList());
	}
	
	//测试删除
	public static void testdelete(BinarySearchTree bst,int key) throws Exception{
		bst.delete(key);
		System.out.println("删除后的根结点二叉树为：" + bst.root);
		System.out.println("删除后的有序列表结果：" + bst.toStringOfOrderList());
	}
	
	public static void main(String[] args){
		try{
			BinarySearchTree bst = new BinarySearchTree();
			System.out.println("查找树是否为空？" + (bst.isEmpty() ? "是" : "否"));//是
			
			int deletePoint = 6;//要删除的结点
			int insertPoint = 11;//要插入的结点
			int[] keys = new int[]{15, 6, 18, 3, 7, 13, 20, 2, 9, 4 };
			for(int key : keys){
				bst.insert(key);
			}
			
			System.out.println("查找树是否为空？" + (bst.isEmpty() ? "是" : "否"));//否
			
			TreeNode minkeyNode = bst.minElemNode(bst.getRoot());
			System.out.println("最小关键字" + minkeyNode.getKey());//2
			
			TreeNode maxkeyNode = bst.maxElemNode(bst.getRoot());
			System.out.println("最大关键字" + maxkeyNode.getKey());//20
			
			System.out.println("根结点关键字" + bst.getRoot().getKey());//15
			
			//测试前趋结点与后继结点
			testNode(bst, minkeyNode);   //本结点：(,2,)			前趋结点： null 			后继结点：(2,3,4)
			testNode(bst, maxkeyNode);   //本结点：(,20,)			前趋结点： (,18,20)			后继结点：null
			testNode(bst, bst.getRoot());//本结点：(6,15,18)   	前趋结点： (9,13,)			后继结点：(,18,20)
			
			testTraverse(bst);  //二叉树遍历：(,2,) (2,3,4) (,4,) (3,6,7) (,7,13) (,9,) (9,13,) (6,15,18) (,18,20) (,20,) ]
								//二叉查找树转换为有序列表： [ 2 3 4 6 7 9 13 15 18 20 ]
			
			//测试插入结点
			testinsert(bst,insertPoint);  //要插入的点为：11
										  //插入后的有序列表结果： [ 2 3 4 7 9 11 13 15 18 20 ]
			
			//测试删除结点
			testdelete(bst,deletePoint);  //要删除的关键字为：6，对应的二叉子树结点为：(3,6,7)
										  //删除后的根结点二叉树为：(7,15,18)
									      //删除后的有序列表结果： [ 2 3 4 7 9 13 15 18 20 ]			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

