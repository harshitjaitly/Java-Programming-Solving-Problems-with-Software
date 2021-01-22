import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int num_pts = 0;
        for (Point currPt : s.getPoints()) {
            //incrementing num_pts in each iteration
            num_pts++ ;
        }   
        return num_pts;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        // getting total number of points
        int num_pts = getNumPoints(s);
        // calculating total perimeter of the shape
        double totalPerimeter = getPerimeter(s);
        // calculating average size of an edge in Shape S
        double avg_size = totalPerimeter/num_pts ;
        return avg_size;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largeSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // check and Update largeSide
            if(currDist > largeSide){
                largeSide = currDist ;
            }
        }
        return largeSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        // for each point currPt in the shape
        for (Point currPt : s.getPoints()){
            // extracting X-coordinate of each point
            double x = currPt.getX() ;
            // comparing and updating Largest X
            if (x > largestX){
                largestX = x ; 
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        double num_pts = getNumPoints(s) ;
        System.out.println("number of points = " + num_pts);
        double avg_length = getAverageLength(s) ;
        System.out.println("average length = " + avg_length);
        double largest_Side = getLargestSide(s) ;
        System.out.println("largest side = " + largest_Side);
        double largest_X = getLargestX(s) ;
        System.out.println("largest X = " + largest_X);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
