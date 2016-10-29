package playRound;


import org.objectweb.asm.ClassVisitor;

import java.util.AbstractList;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * Created by Yifan on 10/28/16.
 */
public class ClassPrinter extends ClassVisitor {
    public ClassPrinter() {
        super(ASM5);
    }

    @Override
    public void visit(int i, int i1, String s, String s1, String s2, String[] strings) {
        System.out.println(s + " extends " + s2 + " {");
    }

    @Override
    public void visitSource(String s, String s1) {
        super.visitSource(s, s1);
    }

    @Override
    public void visitOuterClass(String s, String s1, String s2) {
        super.visitOuterClass(s, s1, s2);
    }

    @Override
    public void visitEnd() {
        System.out.println("}");
    }
}
