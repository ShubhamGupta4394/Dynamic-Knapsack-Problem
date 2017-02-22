import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class assignmentP3{
	int remweight;
		
	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			System.out.println("Run the program as : java App <inputfile>");
			return;
		}
                String outputFile = "output.txt";
                if(args.length>1) {
			outputFile = args[1];
		}	
		File f = new File(args[0]);
		PrintWriter out = new PrintWriter(outputFile,"UTF-8" );
		int k =1;
		try{
			Scanner sc = new Scanner(f);
			
			while (sc.hasNext()) {
				int N = sc.nextInt();  //stores number of weights
				int W = sc.nextInt();  //store value of maximum weights(W)
				int[] w = new int[N];
				int[] p = new int[N];
				for (int i = 0; i < N; i++) {
						int a = sc.nextInt();
						w[i] = a;    // storing weights
						int b = sc.nextInt();
						p[i] = b;    // storing profits
				}
				KnapsackSolve kn = new KnapsackSolve(k,N,W,w,p);				
				kn.calculatetime();
				k++;
				System.out.print(kn.toString());
           			out.print(kn.toString() );
    				out.flush();
			}
			out.close();
				
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}

	}	
	
}
