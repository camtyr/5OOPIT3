/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.*;

/**
 *
 * @author HP
 */
//cai dat cau truc du lieu dang tree, moi thanh phan goi la 1 node
public class Node {

    int value;//luu du lieu cua node
    Node left;
    Node right;

    //viet ham tao de moi khi tao moi 1 node thi co cac gia tri mac dinh
    public Node(int value) {
        this.value = value;
    }

    //ham them moi 1 node vao trong tree
    public Node insertNode(Node root, int value) {
        //neu cau chua ton tai.
        Node newNode = new Node(value);
        //kiem tra tree da ton tai chua
        if (root == null) {
            return newNode;
        } else {
            //cay da ton tai node goc
            //Nhieu cach to chuc tree trong may tinh
            //co nhieu cach de viet cac phuong thuc.
            Node temp = root;//muc dich de duyet
            while (true) {
                if (value < temp.value) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    //code here.
                    if (temp.right == null) {
                        temp.right = newNode;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
        return root;
    }

    //insert a node using recursion
    public Node insertNodeUsingRecursion(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.value) {
            root.left = insertNodeUsingRecursion(root.left, value);
        }
        if (value > root.value) {
            root.right = insertNodeUsingRecursion(root.right, value);
        }
        return root;
    }
    //Dem xem trong tree co bao nhieu node

    //Tim xem co node nao do ton tai trong tree hay khong
    public boolean searchNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        } else if (value < current.value) {
            return searchNode(current.left, value);
        } else {
            return searchNode(current.right, value);
        }
    }

    //duyet cay theo chieu sau DFS
    //duyet pre-order: N-L-R
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(" " + current.value);
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    public void preOrderWithoutRecursion() {
        Stack<Node> stacks = new Stack<>();
        Node current = this;
        stacks.push(current);
        while (current != null && !stacks.isEmpty()) {
            current = stacks.pop();
            System.out.print(" " + current.value);
            if (current.right != null) {
                stacks.push(current.right);
            }
            if (current.left != null) {
                stacks.push(current.left);
            }
        }

    }

    //duyet in-order: L-N-R
    public void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(" " + current.value);
            inOrder(current.right);
        }
    }
    //delete a node in the tree
    public Node deleteNode(Node current, int value){
        if(current==null){
            return null;
        }
        if(value<current.value){
            current.left=deleteNode(current.left, value);
            return current;
        }else if(value> current.value){
            current.right = deleteNode(current.right, value);
            return current;
        }else{
            //xu ly cho truong hop tim thay gia tri can xoa
            //TH1: Node can xoa khong co con
            if(current.left==null&&current.right==null){
                return null;
                
            }
            //TH2: Node chi co 1 la la con ben trai hoac con ben phai
            if(current.right==null){
                return current.left;
            }
            if(current.left==null){
                return current.right;
            }
            //TH3: Node can xoa co du 2 con 
            //Buoc 1: Tim node trai cung cua cay con ben phai
            Node smallest = findLeftSmallest(current.right);
            //Buoc 2: Thay the node can xoa bang node do
            current.value = smallest.value;
            
            //Buoc 3: Xoa node trai cung do di khoi cay ben phai
            current.right = deleteNode(current.right, smallest.value);
            return current;
            
        }
        
        
    }
    //ham lay ve node trai cung cua cay con ben phai
    public Node findLeftSmallest(Node node){
        if(node.left==null){
            return node;
        }else{
            return findLeftSmallest(node.left);
        }
    }

}