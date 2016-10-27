package CodeCoverage.CodeCoverage;


import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class CoverageMethodTransformVisitor extends MethodVisitor implements Opcodes{
	
	boolean isBefore;
	
	
	public CoverageMethodTransformVisitor(int api, final MethodVisitor mv) {
		super(api, mv);
	}
    
	@Override
    public AnnotationVisitor visitAnnotation(String desc,boolean visible){
    	String str="Test";
    	
		if(desc.contains(str.subSequence(0, str.length()))){
    		isBefore=true;
    		System.out.println(desc);
    		
    		
    	} 
    	return visitAnnotation(desc,visible);
    }
	

	/**
    @Override
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
    	if(isBefore){
    		System.out.println(owner);
    	}
    }

    */
    
    
    

}
