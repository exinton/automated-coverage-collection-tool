package CodeCoverage.CodeCoverage;


import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class CoverageMethodTransformVisitor extends MethodVisitor implements Opcodes{
	
	boolean isTest;
	
	
	public CoverageMethodTransformVisitor(int api, final MethodVisitor mv) {
		super(api, mv);
	}
    
	@Override
    public AnnotationVisitor visitAnnotation(String desc,boolean visible){
    	String str="Test";
    	
		if(desc.contains(str.subSequence(0, str.length()))){
    		isTest=true;
    		
    		
    		
    	} 
    	return mv.visitAnnotation(desc, visible);
    }
	
	@Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
    	if(isTest){
    		mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        	mv.visitLdcInsn("targetClass:"+desc);
        	mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    	}
    	super.visitFieldInsn(opcode, owner, name, desc);
    }
	
	@Override
	public void visitMethodInsn(int opcode,String owner,String name,String desc,boolean itf){
		
		
		super.visitMethodInsn(opcode, owner, name, desc, itf);
	}

    
    
    

}
