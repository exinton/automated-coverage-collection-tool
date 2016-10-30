import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by Yifan on 10/28/16.
 */

public class CoverageDriver implements ClassFileTransformer{
    /**
     * This class must contain current transforming class's total # of statements.
     */

    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {

        int[] curClassStateMentCount = new int[1];
        boolean[] needAdapt = new boolean[1];

        byte[] ret = passOne(classfileBuffer, curClassStateMentCount, needAdapt);

        System.out.println(curClassStateMentCount[0]);

        if (needAdapt[0]) return passTwo(ret);
        else return ret;
    }

    private byte[] passOne(byte[] classByte, int[] array, boolean[] needAdapt){
        byte[] ret;
        ClassReader cr = new ClassReader(classByte);
        ClassWriter cw = new ClassWriter(cr, 0);
        InformationCollecter ca = new InformationCollecter(cw);
        cr.accept(ca, 0);
        array[0] = ca.getStatementsCounter();
        needAdapt[0] = ca.getNeedAdapt();
        ret = cw.toByteArray();
        return ret;
    }

    private byte[] passTwo(byte[] classByte){
        byte[] ret;
        ClassReader cr = new ClassReader(classByte);
        ClassWriter cw = new ClassWriter(cr, 0);
        CoverageAdapter ca = new CoverageAdapter(cw);
        cr.accept(ca, 0);
        ret = cw.toByteArray();
        return ret;
    }
}
