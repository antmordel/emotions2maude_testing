package emotions2maude_testing.test;

import java.io.File;
import java.text.DecimalFormat;

import main.java.transformation.Emotions2Maude;
import maude_model2text.MaudeM2T;

public class ProductLineSystem {
	
	public static void main(String[] args) {
		System.out.println("---- ProductLineSystem (PLS) e-Motions example");
		System.out.println("---- -----------------------------------------");
		
		String BEH_PLS = "src/emotions2maude_testing/test/resources/pls/Behavior/DEVSBehavior.behavior";
		String GCS_PLS = "src/emotions2maude_testing/test/resources/pls/Behavior/DEVSgcs.gcs";
		String MAUDE_PLS  = "src/emotions2maude_testing/test/resources/pls/out_maude.xmi";
		String MAUDECODE_PLS = "src/emotions2maude_testing/test/resources/pls/out_maude.maude";
		
		long startTime = System.currentTimeMillis();
		DecimalFormat df = new DecimalFormat("#0.000");
		
		File behModel = new File(BEH_PLS);
		File gcsModel = new File(GCS_PLS);
		File maudeModel = new File(MAUDE_PLS);
		
		Emotions2Maude mt = new Emotions2Maude(behModel, gcsModel, maudeModel);
		
		mt.runTransformation().saveOutput();
		
		System.out.println("M2M transformation executed in " 
				+ df.format((System.currentTimeMillis() - startTime) / 1000.0) + "seconds");
		
		MaudeM2T trans = new MaudeM2T();
		trans.generate(MAUDE_PLS, MAUDECODE_PLS);
		
		System.out.println("M2T transformation executed in " 
				+ df.format((System.currentTimeMillis() - startTime) / 1000.0) + "seconds");
	}
}
