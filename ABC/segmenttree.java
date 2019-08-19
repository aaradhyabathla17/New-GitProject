package crux7april;

public class segmenttree {
	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;
	private segmenttreeI segmenttreeI;

	public segmenttree(int[] arr, segmenttreeI segmentI) {
		this.segmenttreeI = segmentI;
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {
		if (lo == hi) {
			Node bn = new Node();
			bn.data = arr[lo];
			bn.si = lo;
			bn.ei = hi;
			return bn;
		}

		int mid = (lo + hi) / 2;
		Node nn = new Node();
		nn.si = lo;
		nn.ei = hi;

		nn.left = construct(arr, lo, mid);
		nn.right = construct(arr, mid + 1, hi);
		nn.data = segmenttreeI.operation(nn.left.data, nn.right.data);

		return nn;

	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		if (node.left == null) {
			str += ".";
		} else
			str += node.left.data;

		str += "->" + node.data + "<-";
		if (node.right == null)
			str += ".";
		else
			str += node.right.data;
//		System.out.println("...................");
		System.out.println(str);
//		System.out.println("..................");

		display(node.left);
		display(node.right);
	}

	public int query(int qsi, int qei) {
		return query(this.root, qsi, qei);
	}

	private int query(Node n, int qsi, int qei) {

		if (n.si >= qsi && n.ei <= qei) {
			return n.data;
		} else if (n.ei < qsi || n.si > qei) {
			return segmenttreeI.defaultvalue();
		} else {

			int fh = query(n.left, qsi, qei);
			int sh = query(n.right, qsi, qei);
			int res = segmenttreeI.operation(fh, sh);
			return res;
		}
	}

//	public int minsteps()
//	{
//		return minsteps(this.root);
//	}
//
//	private int minsteps(Node node) {
//		
//		return 0;
//	}
	public void updation(int idx, int item) {
		updation(this.root, idx, item);

	}

	private int updation(Node n, int idx, int item) {

		if (n.si == idx && n.ei == idx) {
			n.data = item;
			return n.data;
		} else if (n.si <= idx && idx <= n.ei) {
			int lupdate = updation(n.left, idx, item);
			int rupdate = updation(n.right, idx, item);
			n.data = segmenttreeI.operation(lupdate, rupdate);
			return n.data;
		} else {
			return n.data;
		}
	}

//      private int updation(Node n, int idx, int item) {
//		
//		if(n.si==idx && n.ei==idx)
//		{
//			n.data=item;
//			return n.data;
//		}
//		else if(n.si<=idx && idx<=n.ei)
//		{
//			int lupdate=updation(n.left,idx,item);
//			int rupdate=updation(n.right,idx,item);
//			n.data=lupdate+rupdate;
//			return n.data;
//		}
//		else
//		{
//			return n.data;
//		}
	public int minsteps() {
		return minsteps(this.root);
	}

	private int minsteps(Node nn) {
		

	}
}
