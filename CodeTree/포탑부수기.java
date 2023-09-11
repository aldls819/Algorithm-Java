package 삼성기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//정렬 조건이 존재하니까 만들어줘야 함
class Tower implements Comparable<Tower> {
	// 공격력이 가장 낮은 포탑
	// 최근에 공격한 포탑
	// 행 + 열 합이 가장 큰 포탑
	// 열 값이 가장 큰 포탑 순서로 정렬해주어야 함
	int x, y, recent, attack;

	public Tower(int x, int y, int recent, int attack) {
		this.x = x;
		this.y = y;
		this.recent = recent;
		this.attack = attack;
	}

	// 음을 반환 -> 개체가 지정된 개체보다 작음
	// 0 반환 -> 같음
	// 양의 정수 반환 -> 개체가 지정된 개체보다 큼
	@Override
	public int compareTo(Tower o) {
		// 공격력 낮은 애부터 반환하기
		if (this.attack != o.attack) {
			return this.attack - o.attack;
		}
		// 최근에 공격한 포탑부터 반환하기
		if (this.recent != o.recent) {
			return o.recent - this.recent;
		}
		// 행 + 열 합이 큰 순서부터 반환하기
		if (this.x + this.y != o.x + o.y) {
			return (o.x + o.y) - (this.x + this.y);
		}
		// 열의 값이 가장 큰 순서로 반환
		return o.y - this.y;
	}

}

public class Main_포탑부수기 {

	// 완전구현문제

	// 포탑의 공격력을 저장할 2차원 배열
	// 방문처리 boolean 2차원 배열
	// 언제 공격했는지 저장해야 함
	// 정렬 조건 지정해주어야 함
	// 레이저 공격 -> 4방 우/ 하/ 좌/ 상 순서
	// 포탄 공격 -> 8방에 영향을 미침
	// 포탑 공격과 무관한 포탄들은 공격력 +1해주기

	static int[][] map; // 포탑의 공격력 저장 배열
	static int n, m, k;
	// 몇번째에 사용되었는지 체크해줄 변수
	static int turn;

	// 언제 사용되었는지
	static int[][] recentUse;
	static boolean[][] visited;
	// 공격에 사용되었는지 체크해 줄 배열
	static boolean[][] isUse;
	// 역추척할 때 사용할 배열
	static int[][] backX;
	static int[][] backY;

	// 레이저 공격 사용 -> 오른쪽 아래 왼쪽 위 순서로 움직임
	static int[] laserDx = { 0, 1, 0, -1 };
	static int[] laserDy = { 1, 0, -1, 0 };

	// 포탄 공격 사용 -> 8방 탐색
	static int[] bombDx = { 0, 0, 0, -1, -1, -1, 1, 1, 1 };
	static int[] bombDy = { 0, -1, 1, 0, -1, 1, 0, -1, 1 };

	static List<Tower> liveTower;
	static final int MAX_N = 10;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[MAX_N][MAX_N];
		// 여기에다가 횟수를 저장해서 가장 큰 값이 가장 최근에 사용된 포탑으로
		recentUse = new int[MAX_N][MAX_N];
		visited = new boolean[MAX_N][MAX_N];
		isUse = new boolean[MAX_N][MAX_N];
		backX = new int[MAX_N][MAX_N];
		backY = new int[MAX_N][MAX_N];

		// 공격력 입력받기
		// 0인 애들은 제외시키고 0 이상인 애들은 list에 담아두자
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (k-- > 0) {
			liveTower = new ArrayList<Tower>();

			// 공격력 0 이상인 애들 liveTower에 넣기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] > 0) {
						// tower 객체를 만들어서 livwTower에 넣는다
						Tower currentTower = new Tower(i, j, recentUse[i][j], map[i][j]);
						liveTower.add(currentTower);
					}
				}
			}
			// 가장 공격력이 큰 포탑 구하는거니까 포탑 1개 이하면 걔를 바로 뽑아내면 됨
			if (liveTower.size() <= 1) {
				break;
			}

			// 전처리 진행
			init();

			// 공격자 선정
			pickAttacker();

			// 레이저 공격
			boolean doLaser = attackLaser();

			// 포탄 공격
			if (!doLaser) {
				bombAttack();
			}

			// 포탑 정비하기
			renovate();
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans = Math.max(ans, map[i][j]);
			}
		}
		System.out.println(ans);

	}

	// 전처리
	// 공격이 진행될 때마다 초기화해줘야 함
	private static void init() {
		turn++;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = false;
				isUse[i][j] = false;
			}
		}
	}

	// 공격자 선정 -> 부서지지 않은 포탑 중
	// 공격력이 가장 낮은 애가 선정됨
	// n+m만큼의 공격력을 더해주어야 함
	private static void pickAttacker() {
		Collections.sort(liveTower);

		// 맨 앞에 있는 애가 공격자임
		Tower attackerTower = liveTower.get(0);
		int x = attackerTower.x;
		int y = attackerTower.y;

		// 공격력 더해주기
		map[x][y] += n + m;
		// 몇번째에 사용되었는지 저장
		recentUse[x][y] = turn;
		attackerTower.attack = map[x][y];
		attackerTower.recent = recentUse[x][y];
		isUse[x][y] = true;

		// 맨 앞쪽에 갱신된 포탑을 넣어준다
		liveTower.set(0, attackerTower);
	}

	// 레이저 공격
	private static boolean attackLaser() {
		// 공격자 타워 정보
		Tower attackerTower = liveTower.get(0);
		int attackerX = attackerTower.x;
		int attackerY = attackerTower.y;
		int attackerPower = attackerTower.attack;

		// 공격을 받을 타워는 공격자의 반대 -> 맨 뒤에 애 꺼내기
		Tower brokenTower = liveTower.get(liveTower.size() - 1);
		int brokenX = brokenTower.x;
		int brokenY = brokenTower.y;

		// 최단경로로 움직여야 함 -> BFS
		// 최단 경로 없으면 포탄 공격 해야됨
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(attackerX, attackerY));
		visited[attackerX][attackerY] = true;

		boolean canAttack = false;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;

			q.poll();

			// 도달할 수 있으면 break;
			if (x == brokenX && y == brokenY) {
				canAttack = true;
				break;
			}

			for (int idx = 0; idx < 4; idx++) {
				int nx = (x + laserDx[idx] + n) % n;
				int ny = (y + laserDy[idx] + m) % m;

				// 방문했으면 넘어가기
				if (visited[nx][ny]) {
					continue;
				}

				// 이미 부셔진 포탑이면 넘어가기
				if (map[nx][ny] == 0) {
					continue;
				}

				visited[nx][ny] = true;
				backX[nx][ny] = x;
				backY[nx][ny] = y;
				q.add(new Position(nx, ny));

			}
		}

		// 레이저 공격 가능
		if (canAttack) {
			map[brokenX][brokenY] -= attackerPower;
			if (map[brokenX][brokenY] < 0) {
				map[brokenX][brokenY] = 0;
			}
			isUse[brokenX][brokenY] = true;

			// 경로 역추적하며 나머지 애들도 공격력 감소시켜주기
			int bx = backX[brokenX][brokenY];
			int by = backY[brokenX][brokenY];

			while (!(bx == attackerX && by == attackerY)) {
				map[bx][by] -= attackerPower / 2;
				if (map[bx][by] < 0) {
					map[bx][by] = 0;
				}
				isUse[bx][by] = true;
				int nx = backX[bx][by];
				int ny = backY[bx][by];

				bx = nx;
				by = ny;
			}
		}
		return canAttack;

	}

	// 포탄 공격
	private static void bombAttack() {
		// 공격자 타워 정보
		Tower attackerTower = liveTower.get(0);
		int attackerX = attackerTower.x;
		int attackerY = attackerTower.y;
		int attackerPower = attackerTower.attack;

		// 공격을 받을 타워는 공격자의 반대 -> 맨 뒤에 애 꺼내기
		Tower brokenTower = liveTower.get(liveTower.size() - 1);
		int brokenX = brokenTower.x;
		int brokenY = brokenTower.y;

		// 공격 받을 타워 8방에 있는 애들한테 공격력 감소 시키기
		for (int idx = 0; idx < 9; idx++) {
			int nx = (brokenX + bombDx[idx] + n) % n;
			int ny = (brokenY + bombDy[idx] + m) % m;

			// 공격자 타워가 포함되어 있으면 넘어가기
			if (nx == attackerX && ny == attackerY) {
				continue;
			}
			if (nx == brokenX && ny == brokenY) {
				// 타워의 공격력 감소
				map[nx][ny] -= attackerPower;
				if (map[nx][ny] < 0) {
					map[nx][ny] = 0;
				}
				isUse[nx][ny] = true;

			} else {
				map[nx][ny] -= attackerPower / 2;
				if (map[nx][ny] < 0) {
					map[nx][ny] = 0;
				}
				isUse[nx][ny] = true;
			}

		}
	}

	// 포탄 정비하기
	private static void renovate() {
		// 사용되지 않은 포탑들의 공격력 +1
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isUse[i][j]) {
					continue;
				}
				if (map[i][j] == 0) {
					continue;
				} else {
					map[i][j]++;
				}
			}
		}
	}

}
