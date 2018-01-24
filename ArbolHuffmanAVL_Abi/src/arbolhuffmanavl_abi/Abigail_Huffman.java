/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolhuffmanavl_abi;

/**
 *
 * @author Abigail
 */
import java.util.*;
import javax.swing.JOptionPane;

abstract class HuffmanTree implements Comparable<HuffmanTree> {
	public final String values = "";
    public final int frequency; // the frequency of this tree

    public HuffmanTree(int freq) {
        frequency = freq;
    }

    
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends HuffmanTree {

    public final char value; // the character this leaf represents

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}

class HuffmanNode extends HuffmanTree {

    public final HuffmanTree left, right; // subtrees

    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;

    }
}

public class Abigail_Huffman {

    public static HuffmanTree construirArbol(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
       
        for (int i = 0; i < charFreqs.length; i++) {
            if (charFreqs[i] > 0) {
                trees.offer(new HuffmanLeaf(charFreqs[i], (char) i));
            }
        }
        assert trees.size() > 0;
        while (trees.size() > 1) {
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();
            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static String imprimir(HuffmanTree tree, StringBuffer prefix) {
        
    	String values = "";
        assert tree != null;
		if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf) tree;
            values  += ("Valor: "+ leaf.value + "  -  " + prefix);
            System.out.println(values);
            
        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode) tree;

            prefix.append("0");
            imprimir(node.left, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

            prefix.append("1");
            imprimir(node.right, prefix);
            prefix.deleteCharAt(prefix.length() - 1);

        }
        return values;
    }


}

