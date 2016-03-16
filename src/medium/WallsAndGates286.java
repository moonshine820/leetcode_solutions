package medium;

public class WallsAndGates286 {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) {
            return;
        }
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void bfs(int[][] rooms, int i, int j, int distance) {
        if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length) {
            return;
        }
        if(rooms[i][j] < distance) {
            return;
        }
        rooms[i][j] = distance;
        bfs(rooms, i + 1, j, distance + 1);
        bfs(rooms, i - 1, j, distance + 1);
        bfs(rooms, i, j - 1, distance + 1);
        bfs(rooms, i, j + 1, distance + 1);
    }
}
