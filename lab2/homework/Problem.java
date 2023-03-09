import java.util.ArrayList;

public class Problem {
        private final ArrayList<Location> locations;
        private final ArrayList<Road> roads;
  
        public Problem() {
                locations = new ArrayList<>();
                roads = new ArrayList<>();
        }
        public Problem(ArrayList<Location> givenLocations, ArrayList<Road> givenRoads)
        {
                locations = new ArrayList<>();
                roads = new ArrayList<>();

                for(Location i: givenLocations)
                        if(!locations.contains(i))
                                locations.add(i);
                for(Road i: givenRoads)
                        if(!roads.contains(i))
                                roads.add(i);
        }
        public void addLocation(Location location) {

                int alreadyExists = 0;

                for(Location i: locations)
                        if(location.equals(i)){
                                alreadyExists = 1;
                                break;
                        }

                if( alreadyExists == 0 )
                        locations.add(location);
        }
        public void addRoad(Road road){

                int alreadyExists = 0;

                for(Road i: roads)
                        if(road.equals(i)){
                                alreadyExists = 1;
                                break;
                        }

                if( alreadyExists == 0 )
                        roads.add(road);
        }
        public boolean isValid()
        {
                boolean isValid = true;
                for(Road i: roads){
                        if(i.getLength() < i.getCoordinatesLength(i.getStartLocation(),i.getEndLocation())){
                                isValid = false;
                                break;
                        }
                }
                return isValid && checkEveryRoadHasExistentLocations();
        }

        public int getMatrixDimension(){
                return locations.size();
        }

        private int[][] matrixOfLocations;
  
        public void populateMatrixOfLocations() {
                matrixOfLocations = new int[getMatrixDimension()][getMatrixDimension()];
                for(Road i: roads) {

                        Location startLocation = i.getStartLocation();
                        Location endLocation = i.getEndLocation();
                        int indexOfStartLocation = locations.indexOf(startLocation);
                        int indexOfEndLocation = locations.indexOf(endLocation);

                        matrixOfLocations[indexOfStartLocation][indexOfEndLocation] = 1;
                        matrixOfLocations[indexOfEndLocation][indexOfStartLocation] = 1;
                }
        }
        public void getMatrixOfLocations() {
                for(int i=0; i<getMatrixDimension(); i++) {
                        for (int j = 0; j < getMatrixDimension(); j++)
                                System.out.print(matrixOfLocations[i][j] + " ");
                        System.out.println();
                }

        }
        public boolean doesPathExists(Location startLocation, Location endLocation) {
                populateMatrixOfLocations();
                int indexOfStartLocation = locations.indexOf(startLocation);
                int indexOfEndLocation = locations.indexOf(endLocation);
                boolean[] visited = new boolean[getMatrixDimension()];
                return dfs(matrixOfLocations, indexOfStartLocation, indexOfEndLocation, visited);
        }

        private boolean dfs(int[][] matrix, int currentIndex, int indexOfEndLocation, boolean[] visited) {
                visited[currentIndex] = true;
                if (currentIndex== indexOfEndLocation) {
                        return true;
                }
                for (int neighborIndex = 0; neighborIndex < getMatrixDimension(); neighborIndex++) {
                        if (matrix[currentIndex][neighborIndex] == 1 && !visited[neighborIndex]) {
                                if (dfs(matrix, neighborIndex, indexOfEndLocation, visited)) {
                                        return true;
                                }
                        }
                }
                return false;
        }

        private boolean checkEveryRoadHasExistentLocations(){
                for(Road i: roads)
                        if( !locations.contains(i.getStartLocation()) || !locations.contains(i.getEndLocation()) ){
                                return false;
                        }
                return true;
        }

        public int getNumberOfLocations()
        {
                return locations.size();
        }

        public int getNumberOfRoads()
        {
                return roads.size();
        }

        @Override
        public String toString() {
                return "Problem{" + '\n' +  "locations=" + locations
                        + '\n' + "roads=" + roads +
                        '}';
        }
}
