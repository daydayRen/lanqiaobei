package it.game;

import java.util.Scanner;

public class Ant {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int[] a=new int[5];
		a[0]=in.nextInt();
		a[1]=in.nextInt();
		int[][] b=new int[a[0]][a[1]];
		for(int n=0;n<a[0];n++){
			for(int t=0;t<a[1];t++){
				b[n][t]=in.nextInt();
				
			}
		}
		a[2]=in.nextInt();
		a[3]=in.nextInt();
		
		char c=in.next().charAt(0);
		a[4]=in.nextInt();
		for(int i=0;i<a[4];i++){
			if(b[a[2]][a[3]]==1){
				switch (c) {
				case 'U':
					c=black(c);
					b[a[2]][a[3]]=0;
					a[3]++;
					
					break;
				case 'R':					
					c=black(c);
					b[a[2]][a[3]]=0;
					a[2]++;
					
					break;
				case 'D':
					c=black(c);
					b[a[2]][a[3]]=0;
					a[3]--;
					
					break;
				case 'L':
					c=black(c);
					b[a[2]][a[3]]=0;
					a[2]--;
					break;
				default:
					break;
				}
			}else if(b[a[2]][a[3]]==0){
				switch (c) {
				case 'U':
					c=white(c);
					b[a[2]][a[3]]=1;
					a[3]--;
					
					break;
				case 'R':					
					c=white(c);
					b[a[2]][a[3]]=1;
					a[2]--;
					
					break;
				case 'D':
					c=white(c);
					b[a[2]][a[3]]=1;
					a[3]++;
					
					break;
				case 'L':
					c=white(c);
					b[a[2]][a[3]]=1;
					a[2]++;
					
					break;
				default:
					break;
				}
			}
			}
		System.out.println(a[2]+" "+a[3]);
		}
	public static char black(char c){
		switch (c) {
		case 'U':
			c='R';
			return c;
		case 'R':
			c='D';
			return c;
		case 'D':
			c='L';
			return c;
		case 'L':
			c='U';
			return c;
			
		default:
			break;
		}
		return c;
		
	}
	private static char white(char c) {
		switch (c) {
		case 'U':
			c='L';
			return c;
		case 'R':
			c='U';
			return c;
		case 'D':
			c='R';
			return c;
		case 'L':
			c='D';
			return c;
			
		default:
			break;
		}
		return c;
	}
}
		

	


