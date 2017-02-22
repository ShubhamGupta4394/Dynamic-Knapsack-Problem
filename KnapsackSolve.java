
public class KnapsackSolve {
	int problemId,N,W;
	int[] w,p;
	int[][] M;
	long starttime,endtime,timetaken;
	KnapsackSolve(int problemId,int N,int W,int[] w,int[] p){
	this.problemId = problemId;
	this.N = N;
	this.W = W;
	this.w =w;
	this.p =p;
	}
	void calculatetime() {
		starttime = System.currentTimeMillis();
		knapsack(N,W,w,p); 
		endtime = System.currentTimeMillis();
		timetaken = endtime - starttime; // calculating time
	}

	public void knapsack(int n, int y, int[] w, int[] p) {
		int N = n;
		int W = y;		
		M = new int[N+1][W+1];  // matrix of N+1 * W+1
		for (int i = 0; i <= W; i++) {
			M[0][i]=0; 	// Row 0 equal to 0
		}
		for (int j = 0; j <= N; j++) {
			M[j][0]=0;	// Column 0 equal to 0
		}
		for (int k = 1; k <= N; k++) {
			for(int a=1; a<=W; a++){
				if(w[k-1]<=a){
				M[k][a] = Math.max(p[k-1]+M[k-1][a-w[k-1]], M[k-1][a]);  //writing the values in matrix
				}
				else{
					M[k][a] = M[k-1][a];   //writing the values in matrix
				}
		}
}
}
public String toString() {	//Output Display
		String stats = problemId + " " + N + " " + M[N][W] + " " + timetaken + System.getProperty("line.separator");
		int i=N,k=W;
		while(i>0 && k>0){
			if(M[i][k] != M[i-1][k])
			{
				stats = stats + w[i-1]+"\t"+p[i-1] + System.getProperty("line.separator");
				i--;
				k = k-w[i];
			}
			else{
				i--;
			}
		}
		return stats;
	}
}
