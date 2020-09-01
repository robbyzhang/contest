package org.robby;

public class Test {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ret = 0;
        for(int a=0; a<A.length; a++)
            for(int b=0; b<B.length; b++)
                for(int c=0; c<C.length; c++)
                    for(int d=0; d<D.length; d++){
                        if(A[a] + B[b] + C[b] + D[d] == 0){
                            ret ++;
                        }
                    }
        return ret;
    }
}
