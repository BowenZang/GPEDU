package org.example;

import static org.junit.Assert.assertTrue;

import org.example.gp.Node;
import org.example.gp.Tree;
import org.example.lucency.Course;
import org.example.lucency.CourseComponent;
import org.example.lucency.CoursePackage;
import org.example.safe.Directory;
import org.example.safe.File;
import org.example.safe.Folder;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void lucencyComponentTest() {
        System.out.println("=================透明组合模式=================");
        CourseComponent java = new Course("java", 8000);
        CourseComponent ai = new Course("AI", 5000);
        CourseComponent bigData = new Course("BigData", 10000);

        CourseComponent root = new CoursePackage("课程根目录", 1);
        CourseComponent javaP6 = new CoursePackage("javaP6", 2);

        CourseComponent pattern = new Course("设计模式", 1000);
        CourseComponent spring = new Course("spring", 500);
        CourseComponent mybaits = new Course("mybaits", 100);

        javaP6.addChild(pattern);
        javaP6.addChild(spring);
        javaP6.addChild(mybaits);

        root.addChild(javaP6);
        root.addChild(java);
        root.addChild(ai);
        root.addChild(bigData);

        root.print();
    }

    @Test
    public void directoryTest() {
        System.out.println("=================安全组合模式=================");
        File fileRoot = new File("fileRoot");
        File fileA = new File("fileA");
        File fileB = new File("fileB");
        File fileC = new File("fileC");

        Folder root = new Folder("folderRoot", 1);
        Folder folderA = new Folder("folderA", 2);
        Folder folderB = new Folder("folderB", 2);
        Folder folderC = new Folder("folderC", 2);

        Folder folderAA = new Folder("folderAA", 3);
        Folder folderBB = new Folder("folderBB", 3);
        Folder folderCC = new Folder("folderCC", 3);

        root.add(folderA);
        root.add(folderB);
        root.add(folderC);
        root.add(fileRoot);

        folderA.add(folderAA);
        folderA.add(fileA);

        folderB.add(folderBB);
        folderB.add(fileB);

        folderC.add(folderCC);
        folderC.add(fileC);

        root.show();
    }

    @Test
    public void gpTreeTest() {
        System.out.println("=================GP安全组合模式=================");
        Node nodeRoot = new Node("nodeRoot");
        Node nodeA = new Node("nodeA");
        Node nodeB = new Node("nodeB");
        Node nodeC = new Node("nodeC");

        Tree treeRoot = new Tree("treeRoot", 1);
        Tree treeA = new Tree("treeA", 2);
        Tree treeB = new Tree("treeB", 2);
        Tree treeC = new Tree("treeC", 2);

        Tree treeAA = new Tree("treeAA", 3);
        Tree treeBB = new Tree("treeBB", 3);
        Tree treeCC = new Tree("treeCC", 3);

        treeRoot.addNode(treeA);
        treeRoot.addNode(treeB);
        treeRoot.addNode(treeC);
        treeRoot.addNode(nodeRoot);

        treeA.addNode(treeAA);
        treeA.addNode(nodeA);

        treeB.addNode(treeBB);
        treeB.addNode(nodeB);

        treeC.addNode(treeCC);
        treeC.addNode(nodeC);

        treeRoot.print();
    }
}
