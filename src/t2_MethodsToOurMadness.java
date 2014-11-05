/**
 * Created by lzj on 14-11-4.
 */
public class t2_MethodsToOurMadness {

    /*abstract class Point {}
    class CartesianPt extends Point{
        int x;
        int y;
        CartesianPt(int _x, int _y){
            x = _x;
            y = _y;
        }
    }

    class ManhattanPt extends Point{
        int x;
        int y;
        ManhattanPt(int _x, int _y){
            x = _x;
            y = _y;
        }
    }*/

    // The Second Bit of Advice
    // when writing a function over a datatype, place a method in each of the variants that
    // make up the datatype. if a filed of a variant belongs to the same datatype, the method
    // may call the corresponding method of the filed in computing the function

    abstract class Shish{
        abstract boolean onlyOnions();
        abstract boolean isVegetarian();
    }
    class Skewer extends Shish{

        @Override
        boolean onlyOnions() {
            return true;
        }

        @Override
        boolean isVegetarian() {
            return true;
        }
    }

    class Onion extends Shish{
        Shish s;

        Onion(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            return s.onlyOnions();
        }

        @Override
        boolean isVegetarian() {
            return s.isVegetarian();
        }
    }

    class Lamb extends Shish{
        Shish s;
        Lamb(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            return false;
        }

        @Override
        boolean isVegetarian() {
            return false;
        }
    }

    class Tomato extends Shish{
        Shish s;
        Tomato(Shish _s){
            s = _s;
        }
        @Override
        boolean onlyOnions() {
            return false;
        }

        @Override
        boolean isVegetarian() {
            return s.isVegetarian();
        }
    }

    abstract class Point{
        int x;
        int y;
        Point(int _x, int _y){
            x = _x;
            y = _y;
        }

        abstract int distanceToO();

        boolean closerToO(Point p){
            return distanceToO() <= p.distanceToO();
        }

    }

    class CartesianPt extends Point{

        CartesianPt(int _x, int _y) {
            super(_x, _y);
        }

        @Override
        int distanceToO() {
            return 0;
        }
    }


    class ManhattanPt extends Point{
        ManhattanPt(int _x, int _y) {
            super(_x, _y);
        }

        @Override
        int distanceToO() {
            return 0;
        }
    }






















































}