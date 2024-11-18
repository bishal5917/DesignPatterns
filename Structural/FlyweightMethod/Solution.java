package Structural.FlyweightMethod;

import java.util.HashMap;
import java.util.Map;

// This pattern is a way to save memory in application that uses a large number of similar objects.
// Lets take a task of planting trees in a forest. In a forest, there might be large number of trees.
// Some of them may even share some amount of property, eg: name,color and texture. These refer to 
// common properties or intrinsic properties.
// While some of them might have different properties, which refer to extrinsic properties. eg: Position(x y)

//FlyWeight
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void info(int x, int y) {
        System.out.println(color + " colored " + name + " with " + texture + " texture " + "planted at " + x + "," + y);
    }
}

// A tree class represeting a tree in a forest
class Tree {
    private int x;
    private int y;
    private TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
        info();
    }

    public void info() {
        treeType.info(x, y);
    }
}

// FLyweight Factory
class TreeFactory {
    private static final Map<String, TreeType> map = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String id = name + '-' + color + '-' + texture;
        if (!map.containsKey(id)) {
            // we gotta create new only if previous doesn't exist.
            System.out.println("Creating new treetype: " + id);
            map.put(id, new TreeType(name, color, texture));
        }
        return map.get(id);
    }
}

class Forest {

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        new Tree(x, y, type);
    }
}

public class Solution {

    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree(10, 15, "Pine", "Brown", "Rough");
        forest.plantTree(10, 20, "Pine", "Brown", "Rough");
    }
}
