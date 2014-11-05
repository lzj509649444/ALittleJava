import java.util.Objects;

/**
 * Created by lzj on 14-11-4.
 */
public class T1_ModernToys {

    //abstract class introduces a datatype
    // class introduces a variant, and
    // extents connects a variant to a datatype

    abstract class Seasoning {
    }

    class Salt extends Seasoning {
    }

    class Pepper extends Seasoning {
    }


    abstract class Point {
    }

    class CartesianPt extends Point {
        int x;
        int y;

        CartesianPt(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    class ManhattanPt extends Point {

        int x;
        int y;

        ManhattanPt(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }


    abstract class Num {
    }

    class Zero extends Num {
    }

    class OneMoreThan extends Num {
        Num predecessor;

        OneMoreThan(Num _p) {
            predecessor = _p;
        }
    }

    OneMoreThan oneMoreThan =
            new OneMoreThan(
              new Zero());

    OneMoreThan oneMoreThan1 =
            new OneMoreThan(
                new OneMoreThan(
                    new Zero()));

    // The First Bit of Advice
    // when specifying a collection of data, use abstract classes for datatypes and
    // extends classes for variants


    abstract class Layer{}
    class Base extends Layer{
        Object o;
        Base(Object _o){
            o = _o;
        }
    }

    class Slice extends Layer{
        Layer l;
        Slice(Layer _l){
            l = _l;
        }
    }

    Base base =
            new Base(
                new Zero());
    Base base1 =
            new Base(
                new Salt());

}







































































































