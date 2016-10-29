package playRound;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * Created by Yifan on 10/28/16.
 */
public class Driver {
    public static void main(String[] args) {
        ClassPrinter cp = new ClassPrinter();
        try {
            ClassReader cr = new ClassReader("java.lang.Runnable");
            cr.accept(cp, 0);
            ClassWriter cw = new ClassWriter(0);
            ClassVisitor cv = new ClassVisitor(ASM5, cw){};

            cr.accept(cv, 0);
            byte[] b1 = new byte[10];

            cr.accept(cw, 0);
            byte[] b2 = cw.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
