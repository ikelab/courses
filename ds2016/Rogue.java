package ds;


import java.util.Vector;
import java.util.Random;


class Room {
	int x, y, a, b;
	Room[] A = new Room[4];

	Room(int x, int y, int a, int b) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.b = b;
	}
}


public class Rogue {

	/*
	 * 중요!! 이 함수만 수정하세요!!
	 */
	static Room myDungeon() {
		Room r0 = new Room(34, 9, 6, 3);
		Room r1 = new Room(44, 8, 2, 2);
		Room r2 = new Room(16, 17, 7, 6);
		Room r3 = new Room(30, 27, 4, 7);
		Room r4 = new Room(4, 20, 3, 6);
		Room r5 = new Room(11, 39, 5, 2);
		Room r6 = new Room(12, 29, 2, 4);
		Room r7 = new Room(28, 42, 6, 3);
		Room r8 = new Room(42, 40, 4, 2);
		Room r9 = new Room(44, 22, 3, 2);
		r0.A[RIGHT] = r1;
		r0.A[LEFT] = r2;
		r2.A[RIGHT] = r3;
		r2.A[LEFT] = r4;
		r4.A[DOWN] = r5;
		r5.A[UP] = r6;
		r2.A[DOWN] = r7;
		r0.A[DOWN] = r8;
		r8.A[UP] = r9;
		return r0;
	}

	
	final static int RIGHT = 0, UP = 1, LEFT = 2, DOWN = 3;
	
	final static int L = 50;
	final static int D0 = RIGHT, X0 = 0, Y0 = 7;
	final static int[] DX = {1, 0, -1, 0}, DY = {0, -1, 0, 1};
	
	static Random randgen = new Random();
	

	static int[][] make(Room r, int[][] M) {
		if (M == null) {
			M = new int[L][L];
	        make_aisle(M, D0, X0, Y0, r.x, Y0);
		}
		
	    for (int i = r.y - r.b; i < r.y + r.b + 1; i++) {
	        for (int j = r.x - r.a; j < r.x + r.a + 1; j++) {
	            M[i][j] = 1;
	        }
	    }
	    
	    for (int d = 0; d < 4; d++) {
	        if (r.A[d] != null) {
	            int[] AP = locate_aisle(d, r.x, r.y, r.a, r.b,
	                                    r.A[d].x, r.A[d].y, r.A[d].a, r.A[d].b);
	            make_aisle(M, d, AP[0], AP[1], AP[2], AP[3]);
	            make(r.A[d], M);
	        }
	    }
	    
	    return M;
	}

	static void make_aisle(int[][] M, int d, int u, int v, int u1, int v1) {
	    int j = u, i = v;
	    while (true) {
	        M[i][j] = 2;
	        if (j == u1 && i == v1) {
	            break;
	        }
	        j += DX[d];
	        i += DY[d];
	    }
	}
	
	static int[] locate_aisle(int d, int x, int y, int a, int b,
							  int x1, int y1, int a1, int b1) {
		int u, v, u1, v1;
	    if (DX[d] != 0) {
	        u = x + DX[d] * (a + 1);
	        u1 = x1 - DX[d] * (a1 + 1);
	        v = v1 = (Math.max(y - b, y1 - b1) + Math.min(y + b, y1 + b1)) / 2;
	    } else {
	        u = u1 = (Math.max(x - a, x1 - a1) + Math.min(x + a, x1 + a1)) / 2;
	        v = y + DY[d] * (b + 1);
	        v1 = y1 - DY[d] * (b1 + 1);
	    }
	    
	    int[] rv = {u, v, u1, v1};
	    return rv;
	}
	
	static void show(int[][] M) {
		System.out.print(" ");
		for (int j = 0; j < L; j++) {
			System.out.print(" " + (j % 10));
		}
		System.out.println();
		for (int i = 0; i < L; i++) {
			System.out.print((i % 10) + " ");
			for (int j = 0; j < L; j++) {
				System.out.print(M[i][j] == 1 ? "  " : (M[i][j] == 2 ? "'." : "##")); 
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	static Room generate() {
		int[][] M = new int[L][L];
		
	    Room r0 = null;
	    while (r0 == null) {
	        r0 = generate_room(M, RIGHT, 0, 7, 0, 0);
	    }
	    
	    Vector<Room> S = new Vector<Room>();
	    S.add(r0);
	    
	    final int NUM_TRY_GENERATE_ONE_ROOM = 100;
	    while (!S.isEmpty()) {
	        Room r = S.remove(randgen.nextInt(S.size()));
	        for (int d = 0; d < 4; d++) {
	            for (int k = 0; k < NUM_TRY_GENERATE_ONE_ROOM; k++) {
	                r.A[d] = generate_room(M, d, r.x, r.y, r.a, r.b);
	                if (r.A[d] != null) {
	                    S.add(r.A[d]);
	                    break;
	                }
	            }
	        }
	    }
	    
	    return r0;
	}

	static Room generate_room(int[][] M, int d, int x, int y, int a, int b) {
		int x1 = randgen.nextInt(L - 4 - 3) + 3;
		int y1 = randgen.nextInt(L - 4 - 3) + 3;
		int a1 = randgen.nextInt(8 - 2) + 2;
		int b1 = randgen.nextInt(8 - 2) + 2;
		
		// Check location.
		if (x1 - a1 < 1 || x1 + a1 > L - 2 || y1 - b1 < 1 || y1 + b1 > L - 2) {
			return null;
		}
		if (DX[d] != 0) {
			if (y1 - b1 >= y + b || y1 + b1 <= y - b || DX[d] * (x1 - x) < a1 + a + 2) {
				return null;
			}
		} else {
			if (x1 - a1 >= x + a || x1 + a1 <= x - a || DY[d] * (y1 - y) < b1 + b + 2) {
				return null;
			}
		}
	    
	    // Check overlapping.
        int[] AP = locate_aisle(d, x, y, a, b, x1, y1, a1, b1);
        int u = AP[0], v = AP[1], u1 = AP[2], v1 = AP[3];
	    int j = u, i = v;
	    while (true) {
	        if (M[i][j] != 0 ||
	            M[Math.min(Math.max(i + DX[d], 0), L - 1)][Math.min(Math.max(j + DY[d], 0), L - 1)] != 0 ||
	            M[Math.min(Math.max(i - DX[d], 0), L - 1)][Math.min(Math.max(j - DY[d], 0), L - 1)] != 0) {
	            return null;
	        }
	        if (j == u1 && i == v1) {
	            break;
	        }
	        j += DX[d];
	        i += DY[d];
	    }
	    for (i = Math.max(y1 - b1 - 1, 0); i < Math.min(y1 + b1 + 2, L); i++) {
	        for (j = Math.max(x1 - a1 - 1, 0); j < Math.min(x1 + a1 + 2, L); j++) {
	            if (M[i][j] != 0) {
	                return null;
	            }
	        }
	    }
	    
	    // Make.
	    make_aisle(M, d, u, v, u1, v1);
	    for (i = y1 - b1; i < y1 + b1 + 1; i++) {
	        for (j = x1 - a1; j < x1 + a1 + 1; j++) {
	            M[i][j] = 1;
	        }
	    }
	    
	    return new Room(x1, y1, a1, b1);
	}

	static boolean check(int[][] M0, int[][] M1) {
	    for (int i = 0; i < L; i++) {
	        for (int j = 0; j < L; j++) {
	        	if (M0[i][j] != M1[i][j]) {
	        		System.out.println("(" + j + ", " + i + ")이(가) 다릅니다.");
	        		return false;
	        	}
	        }
	    }
	    
	    return true;
	}
	
	public static void main(String[] args) {
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("학번을 넣으세요: ");
		int seed = s.nextInt();
		
        randgen.setSeed(seed);
	    int[][] map_gen = make(generate(), null);
	    int[][] map_my = make(myDungeon(), null);
		
		while (true) {
			System.out.print("어떤 작업(1: 던전 보기, 2: 내가 만든 던전 보기, 3: 비교, 0: 종료)? ");
			int op = s.nextInt();
			
			if (op == 1) {
			    show(map_gen);
			} else if (op == 2) {
			    show(map_my);
			} else if (op == 3) {
				if (check(map_gen, map_my)) {
					System.out.println("똑같습니다. 축하합니다!");
					break;
				}
			} else if (op == 0) {
				break;
			}
		}
		
		s.close();
	}
}
