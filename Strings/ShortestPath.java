public class ShortestPath {
    public static void findPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++){
            char dir = path.charAt(i);
            if(dir == 'E') x++;
            else if(dir == 'W') x--;
            else if(dir == 'N') y++;
            else if(dir == 'S') y--;
            else System.out.println("Invalid Direction!");
        }
        float distance = (float)Math.sqrt((x*x)+(y*y));
        System.out.println("Shortest path = " + distance);
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        findPath(path);
    }
}