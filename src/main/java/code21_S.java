/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 **/
public class code21_S {


    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//自己解法，有问题，调试中....
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode t1;
        ListNode t2;

        if(p==null){
            return q;
        }
        if(q==null){
            return p;
        }

        while (p != null && q != null) {
            if ((p.val <= q.val) && (q.val <= p.next.val)) {
                t1 = p.next;
                t2 = q.next;
                p.next = q;
                q.next = t1;
                q = t2;
            } else {
                p = p.next;
            }
        }
        return l1;
    }

    //答案1：借助新的头结点
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode();  //默认给新建的节点复制
        ListNode p = preNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = (l1 == null ? l2 : l1);

        return preNode.next;//因此应该返回头结点的下一个结点
    }
}
